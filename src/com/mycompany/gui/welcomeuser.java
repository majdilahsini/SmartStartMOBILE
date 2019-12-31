/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.Toolbar;
import com.mycompany.gui.Toolbar;

/**
 *
 * @author lenovo
 */
public class welcomeuser {
      Form f;
  
          SpanLabel lb;
          Container c1;
               Resources theme;
               public welcomeuser(){
     theme = UIManager.initFirstTheme("/theme");
    f = new Form("Welcome user", BoxLayout.y());
      Label l = new Label("Welcome to espace user");
      f.add(l);
      Toolbar t = new Toolbar();       
       t.ToolBarInstall(f, theme);
              }
               public Form getF(){
    return f;
}
public void setF(Form f){
    this.f=f;
}
}
