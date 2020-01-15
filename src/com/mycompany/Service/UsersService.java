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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Session;
import com.mycompany.Entite.users;
import com.mycompany.gui.welcomeentreprise;
import com.mycompany.gui.welcomeuser;
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
    
        public ArrayList<users> parseListTaskJson(String json) {
                    ArrayList<users> listUsers = new ArrayList<>();
                      try {
            JSONParser j = new JSONParser();
                        Map<String, Object> Users= j.parseJSON(new CharArrayReader(json.toCharArray()));

             List<Map<String, Object>> list = (List<Map<String, Object>>) Users.get("root");
                  
             if (list != null)
                for (Map<String, Object> obj : list) {
               
                users p = new users();
               
              float id= Float.parseFloat(obj.get("id").toString());
                p.setId((int) id);
                
               p.setUsername(obj.get("username").toString());
                p.setEmail(obj.get("email").toString());
                p.setPassword(obj.get("password").toString());
                p.setRoles(obj.get("roles").toString());
                p.setFullname(obj.get("fullname").toString());
                p.setAddress(obj.get("adresse").toString());
                p.setTel(obj.get("tel").toString());
                /*System.out.println(p);*/
                
                listUsers.add(p);

            }
                } catch (IOException ex) {
        }
                      /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
 
        return listUsers;

    }
        ArrayList<users> listUsers = new ArrayList<>();
        public ArrayList<users> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/alluser");  
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
            String Url ="http://localhost/pidev/web/app_dev.php/update/"+f.getId()+"/"+
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
            Map<String, Object> obj;
            obj = j.parseJSON(new CharArrayReader(json.toCharArray()));
             System.out.println(obj);
            
           int userId = Integer.valueOf(obj.get("id").toString().substring(0, obj.get("id").toString().indexOf('.')));
            user.setId(userId);
            user.setPassword(obj.get("password").toString());
            user.setEmail(obj.get("email").toString());
//            user.setAdresse(users.get("adresse").toString());
            user.setRoles(obj.get("roles").toString());
            user.setUsername(obj.get("username").toString());
           
            
               return user;

            
        } catch (IOException ex) {
        }

        return user;

    }
  public void verifielogin(String e,String b) {
       a=0;
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/finduser1/"+e+"/"+b);
        con.setHttpMethod("GET");
             con.setPost(false);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
               byte[] data = (byte[]) con.getResponseData();
                 String s = new String(data);
           
                if (!(parseListTaskJson(s)).isEmpty()) {
                 users user=parseListTaskJson(s).get(0);
                 String z="[ROLE_USER]";
                 String h="["+"ROLE_ENTREPRISE"+", ROLE_USER"+"]";
                 Session.setId(user.getId());
                 int id=user.getId();
                 String username=user.getUsername();
                     if(user.getRoles().equals(z)){
                 welcomeuser a=new welcomeuser(username,id);
                 a.getF().show();}
                 else if(user.getRoles().equals(h)){
                     welcomeentreprise c=new welcomeentreprise();
                     c.getF().show();
                 }
                }
                
                else if ((parseListTaskJson(s)).isEmpty()) Dialog.show("erreur", "verifier vos parametres", "ok", "cancel");
            }
        });
         NetworkManager.getInstance().addToQueueAndWait(con);
         
      
        
       
 }
 }
            
        
        
        
     
        

    

