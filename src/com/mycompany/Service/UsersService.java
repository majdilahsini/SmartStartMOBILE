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
import com.codename1.io.URL;
import com.codename1.io.URL.URLConnection;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.location.GeofenceManager.Listener;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.users;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 *
 * @author firos
 */

 public class UsersService {
     int a;
     String s;
        public ArrayList<users> parseListTaskJson(String json) {
                    ArrayList<users> listUsers = new ArrayList<>();
                      try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                        Map<String, Object> Users= j.parseJSON(new CharArrayReader(json.toCharArray()));
 /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
             List<Map<String, Object>> list = (List<Map<String, Object>>) Users.get("root");
                         //Parcourir la liste des tâches Json
                for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                users p = new users();
                Map<String, Object> username = (Map<String, Object>) obj.get("username");
                Map<String, Object> password = (Map<String, Object>) obj.get("password");
                Map<String, Object> datedebl = (Map<String, Object>) obj.get("roles");
                Map<String, Object> fullname = (Map<String, Object>) obj.get("fullname");
                Map<String, Object> adresse = (Map<String, Object>) obj.get("adresse");
              float id= Float.parseFloat(obj.get("id").toString());
                p.setId((int) id);
                
               p.setUsername(Users.get("username").toString());

                p.setPassword(Users.get("password").toString());
                p.setRoles(obj.get("roles").toString());
                p.setFullname(obj.get("fullname").toString());
                p.setAddress(obj.get("adresse").toString());
                float tel = Float.parseFloat(obj.get("tel").toString());
               p.setTel((int) tel);
                System.out.println(p);
                
                listUsers.add(p);

            }
                } catch (IOException ex) {
        }
                      /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listUsers);
        return listUsers;

    }
        ArrayList<users> listUsers = new ArrayList<>();
        public ArrayList<users> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/smartStartWeb/web/app_dev.php/alluser");  
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                UsersService ser = new UsersService();
                listUsers = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUsers;
    }
        
        
        public void ModifierUser(users f){
            ConnectionRequest con = new ConnectionRequest();
            String Url ="http://localhost/smartStartWeb/web/app_dev.php/update/"+f.getId()+"/"+
            f.getUsername()+"/"+f.getEmail()+"/"+"1"+"/"+ f.getPassword()+"/"+f.getRoles()+"/"+f.getFullname()+"/"+f.getAddress()+"/"+f.getTel();
            
            con.setUrl(Url);
        con.setPost(true);
        
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
          NetworkManager.getInstance().addToQueueAndWait(con);
    }
        public users getUserById(int id){
            UsersService is = new UsersService();
            ArrayList<users> li =is.getList2();
            for(users i:li)
            {
                if(i.getId()==id)
                    return i;
            }
            return null;
        }
public users RecupererUser(String json) {
        users user = new users();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> users;
            users = j.parseJSON(new CharArrayReader(json.toCharArray()));
            float id = Float.parseFloat(users.get("id").toString());
            user.setId((int) id);
            user.setUsername(users.get("username").toString());
            user.setEmail(users.get("email").toString());
            user.setPassword(users.get("password").toString());
            user.setRoles(users.get("roles").toString());
            user.setFullname(users.get("fullname").toString());
            user.setAddress(users.get("adresse").toString());
            float tel = Float.parseFloat(users.get("tel").toString());
            user.setTel((int) tel);
               
 System.out.println(user);
            
        } catch (IOException ex) {
        }

        return user;

    }
  public int verifielogin(String e,String b) {
       a = 0;
       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/smartStartWeb/web/app_dev.php/finduser1/"+e+"/"+b);
        con.setHttpMethod("GET");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                byte[] data = (byte[]) con.getResponseData();
                 s = new String(data);
                 
                System.out.println(s);
                
                if (s!= null) {
                    a =1;
                    
                }
            }
        });
         NetworkManager.getInstance().addToQueueAndWait(con);
         System.out.println(a);
        return a;
        
       
 }
 }
            
        
        
        
     
        

    

