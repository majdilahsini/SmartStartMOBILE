package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Inscription;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class FormationService {
        public ArrayList<Formation> parseListTaskJson(String json) {
                    ArrayList<Formation> listProduits = new ArrayList<>();
                      try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                        Map<String, Object> produits= j.parseJSON(new CharArrayReader(json.toCharArray()));
 /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
             List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                         //Parcourir la liste des tâches Json
                for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Formation p = new Formation();
                Map<String, Object> domaine = (Map<String, Object>) obj.get("domaine");
                Map<String, Object> entreprise = (Map<String, Object>) obj.get("entreprise");
                Map<String, Object> datedebl = (Map<String, Object>) obj.get("dateDebut");
                Map<String, Object> dateFinl = (Map<String, Object>) obj.get("dateFin");
                float ref = Float.parseFloat(obj.get("ref").toString());
                p.setRef((int) ref);
              //  float domain = Float.parseFloat(obj.get("domaine").toString());
               p.setNomentreprise(entreprise.get("username").toString());

                p.setNomdomaine(domaine.get("nomDomaine").toString());
                                p.setNom(obj.get("nom").toString());
                p.setDescription(obj.get("description").toString());
                p.setImage(obj.get("image").toString());
                   float duree = Float.parseFloat(obj.get("duree").toString());
               p.setDuree((int) duree);
               
               float etatt = Float.parseFloat(obj.get("etatFormation").toString());
               p.setEtat((int) etatt);
                double deb_date =(double)datedebl.get("timestamp");
                double fin_date =(double)dateFinl.get("timestamp");
                Date dt = new Date((long)(deb_date*1000));
                Date ddt = new Date((long)(fin_date*1000));
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                p.setDate_debut(f.format(dt));
               p.setDate_fin(f.format(ddt));
                               p.setAdresse(obj.get("adresse").toString());
               float prix = Float.parseFloat(obj.get("prix").toString());
               p.setPrix((double) prix);
               float contact = Float.parseFloat(obj.get("contact").toString());
                 p.setContact((int) contact);
                                p.setEmail(obj.get("email").toString());
                                             float  nombres = Float.parseFloat(obj.get("nombres").toString());
                p.setNbres_inscrits((int) nombres);
                  float  nombrestotales = Float.parseFloat(obj.get("nombrestotale").toString());
                p.setNbres_initiale((int) nombrestotales);
             //   p.setNomentreprise(obj.get("entreprise.").toString());


            //    System.out.println(p);
                
                listProduits.add(p);

            }
                } catch (IOException ex) {
        }
                      /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
      //  System.out.println(listProduits);
        return listProduits;

    }
        ArrayList<Formation> listProduits = new ArrayList<>();
        public ArrayList<Formation> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
     //   con.setUrl("http://localhost/pidev2/web/app_dev.php/api/inscriptions/formations/allfor/"+1);  
     con.setUrl("http://localhost/pidev2/web/app_dev.php/api/inscriptions/alluserformations");
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                FormationService ser = new FormationService();
                listProduits = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }
        
        public ArrayList<Formation> getList1(){       
        ConnectionRequest con = new ConnectionRequest();
       con.setUrl("http://localhost/pidev2/web/app_dev.php/api/inscriptions/formations/allfor/"+1);  
    // con.setUrl("http://localhost/pidev2/web/app_dev.php/api/inscriptions/alluserformations");
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                FormationService ser = new FormationService();
                listProduits = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }
        public void SupprimerFormation(int ref){
            ConnectionRequest con = new ConnectionRequest();
            String Url="http://localhost/pidev2/web/app_dev.php/api/formations/delete/"+ref;
            
            con.setUrl(Url);
            con.setPost(true);
            
            con.addResponseListener((e)->{
                String str = new String(con.getResponseData());
                System.out.println(str);
            });
            NetworkManager.getInstance().addToQueueAndWait(con);
        }
        
        public void ModifierFormation(Formation f){
            ConnectionRequest con = new ConnectionRequest();
            String Url ="http://localhost/pidev2/web/app_dev.php/api/formations/update/"+f.getRef()+"/"+
            f.getNom()+"/"+f.getDescription()+"/"+f.getDuree()+"/"+ f.getDate_debut()+"/"+f.getDate_fin()+"/"+f.getPrix()+"/"+f.getAdresse()+"/"+f.getEmail()+"/"+f.getContact();
            
            con.setUrl(Url);
        con.setPost(true);
        
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
          NetworkManager.getInstance().addToQueueAndWait(con);
    }
        public Formation getFormationById(int id){
            FormationService is = new FormationService();
            ArrayList<Formation> li =is.getList2();
            for(Formation i:li)
            {
                if(i.getRef()==id)
                    return i;
            }
            return null;
        }
        
     public void AjouterInscription(Inscription i){
         ConnectionRequest con = new ConnectionRequest();
         String url="http://localhost/pidev2/web/app_dev.php/api/inscriptions/addinscription/"
                 +i.getUser_id()+"/"+i.getFormation_ref()+"/"+i.getLettre_motivation()+"/"+
                 i.getSpecialite()+"/"+i.getEcole();
          con.setUrl(url);
        con.setPost(true);
          con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     
        
}

        
                
                                 




                


        