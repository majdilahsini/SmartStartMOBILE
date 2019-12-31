/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Inscription;
import com.mycompany.Service.FormationService;

/**
 *
 * @author lenovo
 */
public class AjouterInscription {
    Form f;
    Button confirmer;
    Button Annuler ;
    public AjouterInscription(){
                 f = new Form(BoxLayout.y());
                   String label = ("inscription: "+Formation.focusedIdd);
f.setTitle(label);
                                Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                Label user = new Label("user");
                                TextField userentry=new TextField();
                                c.add(user);
                                 c.add(userentry);
                                Label specialité = new Label("specialité/service");
                                TextField specialitéentry=new TextField();
                                 c.add(specialité);
                                 c.add(specialitéentry);
                                  Label ecole = new Label("ecole/entreprise");
                                TextField ecolenetry=new TextField();
                                 c.add(ecole);
                                 c.add(ecolenetry);
                                  Label lettre = new Label("lettre de motivation");
                                TextField lettreentry=new TextField();
                                 c.add(lettre);
                                 c.add(lettreentry);
                                 c.add("\n");
                                  Container c4 = new Container(new FlowLayout(Component.CENTER));
                      Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                      Annuler = new Button("Annuler");
                      confirmer = new Button("Confirmer");
                         c1.add(Annuler);
                         
        Annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         AffichageFormationuser c = new AffichageFormationuser();
         c.getF().show();
            }
        
}
        );
                         
                         c1.add(confirmer);
                         confirmer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Inscription i = new Inscription(Integer.parseInt(userentry.getText()),Formation.focusedId,lettreentry.getText(),specialitéentry.getText(),ecolenetry.getText());
                        FormationService is = new FormationService();
                        is.AjouterInscription(i);
                        
                        AffichageFormationuser c = new AffichageFormationuser();
                        c.getF().show();
                    }
                });
                         c4.add(c1);
                         
                      c.add(c4);
 f.add(c);
        

    }
      public Form getF(){ 
         return f;
     }  
  public void setF(Form f){
    this.f=f;
    }
    
}
