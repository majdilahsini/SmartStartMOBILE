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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Investissement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceInvestissement {
    
    
   
    
     public ArrayList<Investissement> parseListInvestmentJson(String json) throws ParseException {

        ArrayList<Investissement> listInvest = new ArrayList<>();

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
            Map<String, Object> invest = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) invest.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Investissement i = new Investissement();

             float id = Float.parseFloat(obj.get("idInvestissement").toString());
            // float i1=  Float.parseFloat(obj.get("votreFinance").toString());
            float i2=  Float.parseFloat(obj.get("montant").toString());
            float i3=  Float.parseFloat(obj.get("numcartebancaire").toString());
            
            
               
                //--------------------------------------------
    i.setIdInvestissement((int) id); 
     Map<String, Object> o= (Map<String, Object>) obj.get("idInvesstisseur");
     float i4=  Float.parseFloat(o.get("id").toString());
    i.setIdInvesstisseur((int)i4);
     Map<String, Object> o1= (Map<String, Object>) obj.get("idProjet");
      //float i5=  Float.parseFloat(obj.get("id").toString());
   i.setIdProjet(o1.get("nomProjet").toString());
   
   i.setMontant((long)i2);
    i.setNumcartebancaire((long)i3);
   
   i.setDateInvesstissement(obj.get("dateInvesstissement").toString());
   
    
    
                
               
                
                listInvest.add(i);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listInvest);
        return listInvest;

    }
    ArrayList<Investissement> listinvest= new ArrayList<>();
    
    public ArrayList<Investissement> getInvest(int id){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:82/pidev2/web/app_dev.php/project/projetuser/affichinvM?id="+id); 
       // System.out.println("---------------------------------------------------------------------test1-----------------------------------");//
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceInvestissement ser = new ServiceInvestissement();
                       // System.out.println("---------------------------------------------------------------------test2-----------------------------------");//

                String str = new String(con.getResponseData());//Récupération de la réponse du serveur
                       // System.out.println("---------------------------------------------------------------------"+str+"-----------------------------------");//

            //System.out.println(str);//Affichage de la réponse serveur sur la console
                try {
                    listinvest = ser.parseListInvestmentJson(new String(con.getResponseData()));
                } catch (ParseException ex) {
                   // Logger.getLogger(ServiceProjet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       
        return listinvest;
    }
}
