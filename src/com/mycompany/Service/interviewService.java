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
import com.mycompany.Entite.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class interviewService {
    
public ArrayList<Interviews> parseListTaskJson(String json) {

        ArrayList<Interviews> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                Interviews e = new Interviews();
                 Map<String,Object> idcondidat= (Map<String,Object>) obj.get("offre");
                 Map<String,Object> name= (Map<String,Object>) idcondidat.get("idCondidat");
                 Map<String, Object> date = (Map<String, Object>) obj.get("dateEnt");


                 e.setFullname(name.get("fullname").toString());
                 
                 double batch_date = (double) date.get("timestamp"); 
    Date dt = new Date ((long) (batch_date * 1000)); 
    DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                      e.setDate(f.format(dt));

               
                      float id = Float.parseFloat(obj.get("refEnt").toString());
                                            float id2 = Float.parseFloat(obj.get("etat").toString());

                e.setEtat((int) id2);

                e.setRef_ent((int) id);
                e.setPoste(idcondidat.get("poste").toString());

                e.setHeure_ent(obj.get("heureEnt").toString());
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
    
    ArrayList<Interviews> listTasks = new ArrayList<>();
    
    public ArrayList<Interviews> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev2/web/app_dev.php/interviews/interview/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                interviewService ser = new interviewService();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
}
    
    
    public void SupprimerEntretien(int ref) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev2/web/app_dev.php/interviews/interview/deleteInteview/"+ref;

        
        con.setUrl(Url);
        con.setPost(true);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void AjouterEntretien(Interviews i) {
        ConnectionRequest con = new ConnectionRequest();
    String Url = "http://localhost/pidev2/web/app_dev.php/interviews/interview/ajouterInterview/"+ i.getRef_ent()+"/"+i.getDate()+"/"+i.getHeure_ent() ;

        
        con.setUrl(Url);
        con.setPost(true);
          con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
    public void ModifierEntretien(Interviews i) {
        ConnectionRequest con = new ConnectionRequest();
    String Url = "http://localhost/pidev2/web/app_dev.php/interviews/interview/update/"+ i.getRef_ent()+"/"+i.getDate()+"/"+i.getHeure_ent() ;

        
        con.setUrl(Url);
        con.setPost(true);
          con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
            public Interviews getInterviewById(int id){
          interviewService is=new interviewService();
            ArrayList<Interviews> li=is.getList2();
            for(Interviews i:li)
            {
                if(i.getRef_ent()==id)
                    return i;
            }
            return null;
            
        }
}
