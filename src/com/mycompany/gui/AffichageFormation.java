/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class AffichageFormation {
    Form f;
    Button Ajouter;
    Button Modifier;
        Button Supprimer;
          SpanLabel lb;
          Container c1;
             EncodedImage enc;
    Image imgs;
    ImageViewer imgv;
     String url = "http://localhost/pidev2/web/images/";
          
public AffichageFormation(){
  // c1  = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    f = new Form("List Formations", BoxLayout.y());
                        Ajouter = new Button("Ajouter formation");
                        f.add(Ajouter);       
                       Ajouter.addActionListener(new ActionListener() {
          @Override
        
           public void actionPerformed(ActionEvent evt) {
               AjouterFormation h = new AjouterFormation();
               h.getF().show();

            }
                   }
          );

    FormationService forma = new FormationService();
    
    for(Formation i :forma.getList2()){
        addItem(i);
        
    }
}
public void addItem(Formation formatio){
            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                             Container c10 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

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
                    String ref = String.valueOf(formatio.getRef());
                    Label l = new Label("ref:   "+ref);
                    Label nom = new Label(formatio.getNom());
                      nom.getAllStyles().setMargin(1, 0, 1, 0);
            nom.getAllStyles().setPadding(1, 0, 1, 0);
            nom.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", 4));
              //      Label datedebut = new Label("date debut:"+formatio.getDate_debut());
                //    Label datefin = new Label("date fin :"+formatio.getDate_fin());
                    Label domaine = new Label(formatio.getNomdomaine());
                        domaine.getAllStyles().setFgColor(0xE35F5A);
            domaine.getAllStyles().setMargin(1, 0, 1, 0);
            domaine.getAllStyles().setPadding(1, 0, 1, 0);
            domaine.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 2.5));
               //     Label entreprise = new Label("entreprise:"+formatio.getNomentreprise());
               //     Label prix = new Label("prix:"+formatio.getPrix());
                //    Label duree = new Label("duree:"+formatio.getDuree());
                 //   Label adresse = new Label("adresse:"+formatio.getAdresse());
                //    Label description = new Label("description:"+formatio.getDescription());
                //    Label email = new Label("email:"+formatio.getEmail());
                //    Label Nbres = new Label("Nbres:"+formatio.getNbres_inscrits());
                //    Label contact = new Label("tel:"+formatio.getContact()); 
                    nom.addPointerPressedListener(new ActionListener() {
   @Override
        public void actionPerformed(ActionEvent evt) {
                Form f2=(Form)new Form("detail formation",new BoxLayout(BoxLayout.Y_AXIS));
Container c4 = new Container(new FlowLayout(CENTER,CENTER));
Container c6 = new Container(new FlowLayout(CENTER,CENTER));

                           Container c5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                        try {
            enc = EncodedImage.create("/ChubbyEmbarrassedEchidna-size_restricted.gif");
        } catch (IOException ex) {
        }

        imgs = URLImage.createToStorage(enc, url+formatio.getImage(), url+formatio.getImage(),URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
         Label nomm = new Label(formatio.getNom());
                       c6.add(nomm);
                       c5.add(c6);
                       c5.add(imgv);
                        Label domainee = new Label("domaine:   "+formatio.getNomdomaine()); 
                    Label entreprisee = new Label("entreprise:   "+formatio.getNomentreprise());
                    Label description = new Label("description:  ");
                                        Label descriptio = new Label(formatio.getDescription());

                    Label datedebut = new Label("date debut:    "+formatio.getDate_debut());
                    Label datefin = new Label("date fin :    "+formatio.getDate_fin());
                    Label prix = new Label("prix:     "+formatio.getPrix()+" dt");
                    Label duree = new Label("duree:    "+formatio.getDuree()+" heures");
                    Label adresse = new Label("adresse:    "+formatio.getAdresse());

                    Label email = new Label("email:   "+formatio.getEmail());
                    Label Nbres = new Label("Nbres:   "+formatio.getNbres_inscrits());
                    Label contact = new Label("tel:   "+formatio.getContact()); 
                     Toolbar te = f2.getToolbar();
                      te.addCommandToRightBar("< Back", null ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f.show();
            }
        });
                        c4.add(c5);
           f2.add(c4);
            f2.add(description);
                        f2.add(descriptio);

            f2.add(duree);
            f2.add(datedebut);
            f2.add(datefin);
            f2.add(prix);
            f2.add(adresse);
            f2.add(email);
            f2.add(contact);
         Container c7 = new Container(new FlowLayout(Component.CENTER));
 Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
    Modifier = new Button("modifier");
                    Supprimer = new Button("Supprimer");
                     Supprimer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            FormationService h = new FormationService();
            h.SupprimerFormation(formatio.getRef());
            
            AffichageFormation f = new AffichageFormation();
            f.getF().show();
        }
    });
                       Modifier.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               Formation.focusedId=formatio.getRef();
               modifierFormation h = new modifierFormation();
               h.getF().show();
            }
             }
             );
                       c3.add(Modifier);
c3.add(Supprimer);
c7.add(c3);
f2.add(c7);
            f2.show();
                        
                        
                        
        }            
                         });  
                        
                        
                        /*     @Override
        public void actionPerformed(ActionEvent evt) {
            Dialog.show("Formation",nom.getText()+"\n"+description.getText()+"\n"+duree.getText()+"\n"+datedebut.getText()+"\n"+datefin.getText()+"\n"+prix.getText()+"\n"+adresse.getText()+"\n"+email.getText()+"\n"
                    +contact.getText(),"retour",null);
        }
    });*/
           //         Container c4 = new Container(new FlowLayout(Component.CENTER));
             //       Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
              //      Modifier = new Button("modifier");
                //    Supprimer = new Button("Supprimer");
                 /*   Supprimer.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Dialog.show("suppression","etes vous sur de supprimer cette formation ?","oui","non");
        }
    }
                    );*/
            //        Supprimer.addActionListener(new ActionListener() {
     //   @Override
     //   public void actionPerformed(ActionEvent evt) {
       //     FormationService h = new FormationService();
       //     h.SupprimerFormation(formatio.getRef());
            
        //    AffichageFormation f = new AffichageFormation();
         //   f.getF().show();
       // }
   // });
     //        Modifier.addActionListener(new ActionListener() {
       //     @Override
        
         //   public void actionPerformed(ActionEvent evt) {
             //  Formation.focusedId=formatio.getRef();
           //    modifierFormation h = new modifierFormation();
            //   h.getF().show();
         //   }
           //  }
           //  );

c2.add(nom);
c2.add(domaine);
c1.add(imgv);
c1.add(c2);
c10.add(c1);
c10.add(seperator);
//c2.add(entreprise);
//c3.add(Modifier);
//c3.add(Supprimer);
//c4.add(c3);
//c2.add(c4);
//c2.setLeadComponent(nom);
f.add(c10);
//f.add("\n");
}
                    
                            
public Form getF(){
    return f;
}
public void setF(Form f){
    this.f=f;
}
}
