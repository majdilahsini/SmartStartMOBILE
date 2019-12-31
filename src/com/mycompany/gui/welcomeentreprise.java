/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author lenovo
 */
public class welcomeentreprise { Form f;
  
          SpanLabel lb;
          Container c1;
               Resources theme;
               public welcomeentreprise(){
    theme = UIManager.initFirstTheme("/theme");
    f = new Form("Welcome entreprise", BoxLayout.y());
      Label l = new Label("Welcome to espace entreprise");
      f.add(l);
      Toolbarentreprise t = new Toolbarentreprise();       
       t.ToolBarInstalle(f, theme);
              }
               public Form getF(){
    return f;
}
public void setF(Form f){
    this.f=f;
}
    
}
