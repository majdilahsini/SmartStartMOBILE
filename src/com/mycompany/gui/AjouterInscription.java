/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
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
import com.codename1.util.Base64;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Inscription;
import com.mycompany.Service.FormationService;
import java.util.Map;

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
                             //   Label user = new Label("user");
                            //    TextField userentry=new TextField();
                            //    c.add(user);
                             //    c.add(userentry);
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
                        Inscription i = new Inscription(2,Formation.focusedId,lettreentry.getText(),specialitéentry.getText(),ecolenetry.getText());
                        FormationService is = new FormationService();
                        is.AjouterInscription(i);
                        String accountSID = "ACfbd723c923bc8c7419bd29bbdb1ee1b1";
String authToken = "d31e18abb4d712599f4eca725b3233b8";
String fromPhone = "+12482366312";
                 Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
        queryParam("To","+21644341990").
        queryParam("From", fromPhone).
        queryParam("Body", "Félicitation,vous étes inscrit au formation "+Formation.focusedIdd+"\n"+"Description:"+"\n"+Formation.focusedIdde+"\n"+"Date Debut:"+Formation.focusedIdded+"\n"+"Date Fin:"+"\n"+Formation.focusedIddfd+"\n"+"Adresse:"+"\n"+Formation.focusedIddad+"\n"+
        "Prix:"+Formation.focusedIddp+" dt"+"\n"+"Duree: "+Formation.focusedIdu+" heures"+"\n"+"email:"+Formation.focusedIddem+"\n"+"tel: "+Formation.focusedIddc).
        header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
        getAsJsonMap();
                        
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
