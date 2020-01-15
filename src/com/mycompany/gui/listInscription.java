/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Inscription;
import com.mycompany.Service.InscriptionService;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class listInscription {
    Form f;
         Container c1;
             EncodedImage enc;
                                Resources theme;
                                        Container c10 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

    Image imgs;
    ImageViewer imgv;
     String url = "http://localhost/pidev2/web/images/";
    public listInscription(){
       f = new Form("     Mes inscriptions",BoxLayout.y());
                InscriptionService formaa = new InscriptionService();
                
                for(Inscription i :formaa.getList2()){
        addItem(i);
       
}
    
 f.add(c10);
       
       
       
       
       
       f.getToolbar().addCommandToLeftBar("<-", null, evddd->{
                  AffichageFormationuser a = new AffichageFormationuser();
                  a.getF().showBack();
                });
    }
    public void addItem(Inscription formatio){
                    Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                     Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         seperator.getAllStyles().setBorder(Border.createEmpty());
            seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            seperator.getAllStyles().setBgColor(0x000000);
            seperator.getAllStyles().setBgTransparency(40);
            seperator.setPreferredSize(new Dimension(0,5));
  try {
            enc = EncodedImage.create("/ChubbyEmbarrassedEchidna-size_restricted.gif");
        } catch (IOException ex) {
        }

        imgs = URLImage.createToStorage(enc, url+formatio.getImage(), url+formatio.getImage(),URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
        Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label nom = new Label(formatio.getNomformation());
                      nom.getAllStyles().setMargin(1, 0, 1, 0);
            nom.getAllStyles().setPadding(1, 0, 1, 0);
            nom.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", 4));
            
             Label entreprise = new Label(formatio.getNomentreprise());
                      entreprise.getAllStyles().setMargin(0, 0, 1, 0);
            entreprise.getAllStyles().setPadding(2, 0, 1, 0);
            entreprise.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 3));
            
            
            Label datecreation = new Label(formatio.getDate_creation());
                        datecreation.getAllStyles().setFgColor(0xE35F5A);
            datecreation.getAllStyles().setMargin(1, 0, 1, 0);
            datecreation.getAllStyles().setPadding(1, 0, 1, 0);
            datecreation.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 2.5));
            
            c2.add(nom);
c2.add(entreprise);
c2.add(datecreation);

c1.add(imgv);
c1.add(c2);
c10.add(c1);
c10.add(seperator);
    }
     public Form getF(){ 
         return f;
     }  
  public void setF(Form f){
    this.f=f;
    }
}
