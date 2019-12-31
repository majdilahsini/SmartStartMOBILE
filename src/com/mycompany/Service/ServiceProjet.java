/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Projet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceProjet {
    
      public void ajoutinvest(int montant,long Numcartebancaire,int idP,int idU) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:82/piedv/web/app_dev.php/projetuser/showvisiteur?montant=" + montant+"&Numcartebancaire="+Numcartebancaire+"&idU="+idU+"&idP="+idP;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
      public ArrayList<Projet> parseListProjetJson(String json) throws ParseException {

        ArrayList<Projet> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Projet p = new Projet();

                float id = Float.parseFloat(obj.get("idProjet").toString());
             float i1=  Float.parseFloat(obj.get("votreFinance").toString());
            long i2=  Long.parseLong(obj.get("montant").toString());
            long i3=  Long.parseLong(obj.get("compteBancaire").toString());
            float i4=  Float.parseFloat(obj.get("nbreTeam").toString());
            float i5= Float.parseFloat(obj.get("idEtat").toString());
            float i7= Float.parseFloat(obj.get("telProjet").toString());
                p.setIdProjet((int) id);
                //--------------------------------------------
                
    p.setNomprojet(obj.get("nomProjet").toString());
   p.setVotreFinance(i1);
   p.setMontant(i2);
    p.setCompteBancaire(i3);
   
    p.setDateDebutProjet(obj.get("dateDebutProjet").toString());
     p.setDateFinProjet(obj.get("dateFinProjet").toString());
    p.setAdresseProjet(obj.get("adresseProjet").toString());
    p.setTelProjet((int) i7);
   p.setNbreTeam((int) i4);
    p.setDescriptionProjet(obj.get("descriptionProjet").toString());
    p.setEmailProjet(obj.get("emailProjet").toString());
    p.setImage(obj.get("image").toString());
    Map<String, Object> o= (Map<String, Object>) obj.get("idCategorie");
    p.setIdCategorie(o.get("nom").toString());
   
    p.setIdEtat((int) i5);
    //-------------------------------------
    Map<String, Object> o1= (Map<String, Object>) obj.get("idEntreprise");
  float i6=  Float.parseFloat(o1.get("id").toString());
     p.setId_enterprise((int) i6);
                //---------------------------------------------
                
                
                System.out.println(p);
                
                listTasks.add(p);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<Projet> listProjets = new ArrayList<>();
    
    
    
    public ArrayList<Projet> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:82/piedv/web/app_dev.php/projetuser/indexall");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProjet ser = new ServiceProjet();
                String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
                try {
                    listProjets = ser.parseListProjetJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                   // Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProjets;
    }
    ArrayList<Projet> listProjet = new ArrayList<>();
    
    public ArrayList<Projet> getList3(int id,int idEtat){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:82/piedv/web/app_dev.php/projetuser/domainfiltre?id=" +id+"&idEtat="+idEtat);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProjet ser = new ServiceProjet();
                String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            //System.out.println(str);//Affichage de la réponse serveur sur la console
                try {
                    listProjets = ser.parseListProjetJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                   // Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProjets;
    }
    
    
//-------------------------------------------------supprimer------------------------------------------------
     
    public void supprimerProjet(int idP) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:82/piedv/web/app_dev.php/projetuser/supprimerM?id="+ idP;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    //-----------------------------------------modifier--------------------------------------------------------
    
   public void modifierProjet(Projet p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:82/piedv/web/app_dev.php/projetuser/modifierM?id="+p.getIdProjet()+"&montant=" + p.getMontant()+"&dated="+p.getDateDebutProjet()+"&compte="+p.getCompteBancaire()+"&desc="+p.getDescriptionProjet()+"&vf="+p.getVotreFinance()+"&NT="+p.getNbreTeam()+"&cat="+p.getIdCategorie()+"&datef="+p.getDateFinProjet();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    //-----------------------------------------ajouter--------------------------------------------------------
      
      
      
}
