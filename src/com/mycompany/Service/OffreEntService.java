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
import com.mycompany.Entite.Interviews;
import com.mycompany.Entite.OffreEnt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class OffreEntService {
    public ArrayList<OffreEnt> parseListTaskJson(String json) {

        ArrayList<OffreEnt> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                OffreEnt e = new OffreEnt();
                 Map<String,Object> name= (Map<String,Object>) obj.get("idCondidat");
                 //////////////////////////////////
                 Map<String,Object> namee= (Map<String,Object>) obj.get("idEntreprise");
                 e.setNomEntreprise(namee.get("fullname").toString());

                 //////////////////////////////////
                 e.setNomCondidat(name.get("fullname").toString());
     

                float id = Float.parseFloat(obj.get("offreId").toString());

                e.setOffre_id((int) id);
                e.setPoste(obj.get("poste").toString());

                e.setLettreMotivation(obj.get("lettreMotivation").toString());
               /* e.setFullname(obj.get("offre").toString());*/

                System.out.println(e);
                
                listTasks.add(e);

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
    
    ArrayList<OffreEnt> listTasks = new ArrayList<>();
    
    public ArrayList<OffreEnt> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev2/web/app_dev.php/interviews/interview/affichoffres_ent");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OffreEntService ser = new OffreEntService();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
}

     public void SupprimerOffreEnt(int ref) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev2/web/app_dev.php/interviews/interview/refuserDemandeinterview/"+ref;

        
        con.setUrl(Url);
        con.setPost(true);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public OffreEnt getOffreEntById(int id) {
OffreEntService is=new OffreEntService();
            ArrayList<OffreEnt> li=is.getList2();
            for(OffreEnt i:li)
            {
                if(i.getOffre_id()==id)
                    return i;
            }
            return null;
                }

 

   
}
