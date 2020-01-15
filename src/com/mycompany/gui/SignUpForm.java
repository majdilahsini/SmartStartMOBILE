/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm extends Form {
TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        TextField confirmPassword = new TextField("", "Confirm Password", 20, TextField.PASSWORD);
        CheckBox role1 =new CheckBox("role enreprise");
        CheckBox role2 =new CheckBox("role user");
        TextField fullname = new TextField("", "fullname", 20, TextField.EMAILADDR);
        TextField adresse = new TextField("", "adresse", 20, TextField.EMAILADDR);
        TextField tel = new TextField("", "tel", 20, TextField.EMAILADDR);
        Button signup = new Button("signin");
  public String roleres;

    public SignUpForm(Resources res) {
        setTitle("signup");
        username.setSingleLineTextArea(false);
        email.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        confirmPassword.setSingleLineTextArea(false);
       fullname.setSingleLineTextArea(false);
       adresse.setSingleLineTextArea(false);
       tel.setSingleLineTextArea(false);

        Button next = new Button("Next");
        Button signIn = new Button("Sign In");
        signIn.setUIID("Link");
      
       add(username);
       add(email);
       add(password);
       add(confirmPassword);
       add(role1);
       add(role2);
       add(fullname);
              add(adresse);

                    add(tel);

       add(signup);
       
      
           role1.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
                    String roleres ;
                    roleres="a:1:{i:0;s:15:\"ROLE_ENTREPRISE\";}";
                    signup.addActionListener(new ActionListener() {
          
           
           
           
           
           
            @Override
           
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/pidev/web/app_dev.php/adduser?username="+username.getText()+"&email="+email.getText()+"&enabled=1&password="+password.getText()+
                        "&roles="+roleres+"+&fullname="+fullname.getText()+"&adresse="+adresse.getText()+"&tel="+tel.getText()
                        );
                System.out.println(req.getUrl());
                req.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);

                        Dialog.show("Compte Crée", "Cliquer sur OK pour retourner a la page de connexion", "Ok", null);

                        
                    }
                });

                NetworkManager.getInstance().addToQueue(req);

            }
        });
       System.out.println(roleres);
       
       
       if ((role2.isSelected())&&(role1.isSelected())) Dialog.show("errur", "verifier", "verifier", "retour");
               }
           });
          
       
     role2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String roleres ;
                    roleres="a:0:{}";
                    signup.addActionListener(new ActionListener() {
          
           
           
           
           
           
            @Override
           
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/smartStartWeb/web/app_dev.php/adduser?username="+username.getText()+"&email="+email.getText()+"&enabled=1&password="+password.getText()+
                        "&roles="+roleres+"+&fullname="+fullname.getText()+"&adresse="+adresse.getText()+"&tel="+tel.getText()
                        );
                
                req.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);

                        Dialog.show("Compte Crée", "Cliquer sur OK pour retourner a la page de connexion", "Ok", null);

                        
                    }
                });

                NetworkManager.getInstance().addToQueue(req);

            }
        });
       System.out.println(roleres);
       if ((role2.isSelected())&&(role1.isSelected())) Dialog.show("errur", "verifier", "verifier", "retour");
            }
        });
       
       
     /*  signup.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
                ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/smartStartWeb/web/app_dev.php/adduser"
                        + username.getText().toString() + "/" + email.getText().toString() + "/"+"1"+ "/" + password.getText().toString() + "/" + roleres + "/" + fullname.getText().toString() + "/" +
                        adresse.getText().toString() + "/" + tel.getText().toString()
                        );
                            System.out.println(username.getText() );
                              
          NetworkManager.getInstance().addToQueueAndWait(req);

           }
       });*/
      
    }
    
}
