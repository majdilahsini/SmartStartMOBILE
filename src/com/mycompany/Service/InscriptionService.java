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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Inscription;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public class InscriptionService {
      public ArrayList<Inscription> parseListTaskJson(String json) {
                    ArrayList<Inscription> listProduits = new ArrayList<>();
                      try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                        Map<String, Object> produits= j.parseJSON(new CharArrayReader(json.toCharArray()));
                        /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
             List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                         //Parcourir la liste des tâches Json
                for (Map<String, Object> obj : list) {
                    Inscription i = new Inscription();
                                    Map<String, Object> refformation = (Map<String, Object>) obj.get("formationRef");
                                                    Map<String, Object> domaine = (Map<String, Object>) refformation.get("domaine");
                                                    Map<String, Object> userid = (Map<String, Object>) obj.get("user");
                                                    Map<String, Object> datecreation = (Map<String, Object>) obj.get("datecreation");
                                                    Map<String, Object> entrepris = (Map<String, Object>) refformation.get("entreprise");

                                                    
float id = Float.parseFloat(obj.get("id").toString());
                i.setId((int) id);
float iduser = Float.parseFloat(userid.get("id").toString());
                i.setUser_id((int) iduser);
    float idformation = Float.parseFloat(refformation.get("ref").toString());
    i.setFormation_ref((int) idformation);
    i.setNomformation(refformation.get("nom").toString());
     i.setNomdomaine(domaine.get("nomDomaine").toString());
          i.setNomentreprise(entrepris.get("fullname").toString());
                i.setImage(refformation.get("image").toString());
      
    i.setLettre_motivation(obj.get("lettreMotivation").toString());
                        i.setSpecialite(obj.get("specialite").toString());
    i.setEcole(obj.get("ecole").toString());
    float idetat = Float.parseFloat(obj.get("etat").toString());
                i.setEtat((int) idetat);
                 double creation_date =(double)datecreation.get("timestamp");
Date dt = new Date((long)(creation_date*1000));
 DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                i.setDate_creation(f.format(dt));
                listProduits.add(i);

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
      ArrayList<Inscription> listProduits = new ArrayList<>();
        public ArrayList<Inscription> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev2/web/app_dev.php/api/inscriptions/formations/inscriptions/alluser/"+2);  
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                InscriptionService ser = new InscriptionService();
                listProduits = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }
}
