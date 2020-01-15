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
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.users;
import com.mycompany.Service.UsersService;
/**
 * Sign in UI
 *
 * @author Shai Almog
 */
public class SignInForm extends Form {

    public SignInForm(Resources res) {
        
        this.setLayout(new FlowLayout(CENTER, CENTER));
        
        Container c = new Container();
        c.setLayout(BoxLayout.y());
        
        ImageViewer logo = new ImageViewer(res.getImage("logo.png"));
        
        c.add(logo);
        
        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");
        signUp.addActionListener(e -> new SignUpForm(res).show());
        
        //signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("Don't have an account?","HugeDarkLabel");
        doneHaveAnAccount.getAllStyles().setFgColor(0xEFEFF4);
        signUp.getAllStyles().setFgColor(0xEFEFF4);
        //signIn.getAllStyles().setMargin(20, 20, 0 ,0);
        
        String a=username.getText();
        String b=password.getText();
        UsersService t=new UsersService();
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 if( t.verifielogin ("fartasa","firo") == 1 ){
            Dialog.show("ok", "ok", "ok", "ok");
                    
                    }
                 else 
                         Dialog.show("no", "no", "no", "no");
            
            }
        });
        
        c.add(username);
        c.add(password);
        c.add(signIn);
        c.add(signUp);
        
        this.add(c);
       
    }
    
    
 
    
    
}
