/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class welcomeentreprise { 
           Form f;
  EncodedImage enc ;
          SpanLabel lb;
          Container c1;
               Resources theme;
               public welcomeentreprise(){
    theme = UIManager.initFirstTheme("/theme");
    f = new Form("Welcome entreprise" ,new FlowLayout(CENTER, CENTER));
                          Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

      try {
                enc = EncodedImage.create("/logo.png");
            } catch (IOException ex) {
                
            }
                   ImageViewer img = new ImageViewer(enc);
      c2.add(enc);
      Label a = new Label("Bienvenue a notre application");
      c2.add(a);
      f.add(c2);
     
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
