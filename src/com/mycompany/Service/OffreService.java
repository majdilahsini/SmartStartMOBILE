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
import com.mycompany.Entite.Application;
import com.mycompany.Entite.Inscription;
import com.mycompany.Entite.Offre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sadbo
 */
public class OffreService {
    
    public ArrayList<Offre> parseListTaskJson(String json) {

        ArrayList<Offre> listOffres = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> offres = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) offres.get("root");
            
            for (Map<String, Object> obj : list) {
               
                Offre o = new Offre();
                
                Map<String, Object> domaine = (Map<String, Object>) obj.get("domaine");
                Map<String, Object> timestamp = (Map<String, Object>) obj.get("datePublication");
                Map<String, Object> typePost = (Map<String, Object>) obj.get("typePost");
                Map<String, Object> skill1 = (Map<String, Object>) obj.get("skill1");
                Map<String, Object> skill2 = (Map<String, Object>) obj.get("skill2");
                Map<String, Object> skill3 = (Map<String, Object>) obj.get("skill3");
                Map<String, Object> langueRef = (Map<String, Object>) obj.get("langueRef");
                
                double timestpam_date = (double) timestamp.get("timestamp");
                Date dt = new Date((long) (timestpam_date * 1000));
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                
                o.setId((int) Float.parseFloat(obj.get("id").toString()));
                o.setTitre(obj.get("titre").toString());
                o.setDomaine(domaine.get("nom").toString());
                o.setDate_publication(df.format(dt));
                o.setSalaire((int) Float.parseFloat(obj.get("salaire").toString()));
                o.setType_post(typePost.get("name").toString());
                o.setNiveau_etude((int) Float.parseFloat(obj.get("niveauEtude").toString()));
                o.setSkill1(skill1.get("name").toString());
                o.setSkill2(skill2.get("name").toString());
                o.setSkill3(skill3.get("name").toString());
                o.setLangue(langueRef.get("nom").toString());

                listOffres.add(o);
            }

        } catch (IOException ex) {
        }
        return listOffres;
    }
    
    ArrayList<Offre> listOffres = new ArrayList<>();
    
    public ArrayList<Offre> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/offre/api/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OffreService os = new OffreService();
                listOffres = os.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffres;
    }
    
        public ArrayList<Offre> getList3(String titre){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/offre/api/chercher/"+titre);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OffreService os = new OffreService();
                listOffres = os.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffres;
    }

    String score;
    
    public String getscore(int offre_id, int user_id) {
        
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/offre/api/"+offre_id+"/getscore/"+user_id);  
        con.addResponseListener((NetworkEvent evt) -> {
            score = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return score;
    } 
    
    public void PostulerOffre(Application a){
         ConnectionRequest con = new ConnectionRequest();
         String url="http://localhost/pidev/web/app_dev.php/offre/api/postuleroffre/"+a.getOffre_id()+"/"+a.getMatch()+"/"+a.getUser_id();
                     
        con.setUrl(url);
        con.setPost(true);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

 
    
}
