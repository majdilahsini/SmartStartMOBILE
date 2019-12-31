/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
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
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class AffichageFormationuser {
      Form f;
      Form f2;
      Button b;
       EncodedImage enc;
    Image imgs;
                   Resources theme;

    ImageViewer imgv;
     String url = "http://localhost/pidev2/web/images/";
     // String url ="/a.png";
      public AffichageFormationuser(){
       f = new Form(BoxLayout.y());
     //  f.getStyle().setBgColor(0xEFEFF4);


         FormationService forma = new FormationService();
    
    for(Formation i :forma.getList2()){
        addItem(i);
        
    }
     f.getToolbar().setTitleComponent(FlowLayout.encloseCenterMiddle(
                                                new Label("Listes des formations", "Title"),
                                                new Label(""+forma.getList2().size(), "InboxNumber")
                                        )
        );
    com.mycompany.gui.Toolbar t = new com.mycompany.gui.Toolbar();       
       t.ToolBarInstall(f, theme); 
    }
public void addItem(Formation formatio){
    //ImageViewer img = null;
        Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                 Container c10 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

         Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         seperator.getAllStyles().setBorder(Border.createEmpty());
            seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            seperator.getAllStyles().setBgColor(0x000000);
            seperator.getAllStyles().setBgTransparency(40);
            seperator.setPreferredSize(new Dimension(0,5));
     //    try {
       //     img = new ImageViewer(Image.createImage("/a.png"));
       // }
      //  catch (IOException ex){
        
   // }
    try {
            enc = EncodedImage.create("/ChubbyEmbarrassedEchidna-size_restricted.gif");
        } catch (IOException ex) {
        }

        imgs = URLImage.createToStorage(enc, url+formatio.getImage(), url+formatio.getImage(),URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
    Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     c1.getAllStyles().setMargin(5,5,0,0);
    String ref = String.valueOf(formatio.getRef());
                    
                    Label l = new Label("ref:   "+ref);
                    Label nom = new Label(formatio.getNom());
                     nom.getAllStyles().setMargin(1, 0, 1, 0);
            nom.getAllStyles().setPadding(1, 0, 1, 0);
            nom.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", 4));
                    
                    Label domaine = new Label(formatio.getNomdomaine()); 
                        domaine.getAllStyles().setFgColor(0xE35F5A);
            domaine.getAllStyles().setMargin(1, 0, 1, 0);
            domaine.getAllStyles().setPadding(1, 0, 1, 0);
            domaine.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 2.5));
            
           
                    Label entreprise = new Label(formatio.getNomentreprise());
                      entreprise.getAllStyles().setMargin(0, 0, 1, 0);
            entreprise.getAllStyles().setPadding(2, 0, 1, 0);
            entreprise.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 3));
                                        
                     nom.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
                   f2 = new Form(BoxLayout.y());
                   String label = ("formation "+formatio.getNom());
f2.setTitle(label);
                //Form f2=(Form)new Form("detail formation",new BoxLayout(BoxLayout.Y_AXIS));
Container c4 = new Container(new FlowLayout(CENTER,CENTER));
Container c6 = new Container(new FlowLayout(CENTER,CENTER));

                           Container c5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                        try {
            enc = EncodedImage.create("/Loading-Icon-by-Kanggraphic-2-580x386.jpg");
        } catch (IOException ex) {
        }

        imgs = URLImage.createToStorage(enc, url+formatio.getImage(), url+formatio.getImage(),URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
        // Label nomm = new Label(formatio.getNom());
                       
                       c5.add(c6);
                       c5.add(imgv);
                       c5.add("\n");

                Button inscrire = new Button("inscrire");
                Container cd = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label domaineeee = new Label("domaine: "); 
                domaineeee.getAllStyles().setFgColor(0xE35F5A);
                domaineeee.getAllStyles().setMargin(0, 0, 1, 0);
                domaineeee.getAllStyles().setPadding(0, 0, 1, 0);
                domaineeee.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label domainee = new Label(formatio.getNomdomaine());
                cd.add(domaineeee);
                cd.add(domainee);
                
                
                Container ce = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label entreprisee = new Label("entreprise: ");
                entreprisee.getAllStyles().setFgColor(0xE35F5A);
                entreprisee.getAllStyles().setMargin(0, 0, 1, 0);
                entreprisee.getAllStyles().setPadding(0, 0, 1, 0);
                entreprisee.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label entrepriseee = new Label(formatio.getNomentreprise());
                ce.add(entreprisee);
                ce.add(entrepriseee);

                Container cde = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Label description = new Label("description:");
                description.getAllStyles().setFgColor(0xE35F5A);
                description.getAllStyles().setMargin(0, 0, 1, 0);
                description.getAllStyles().setPadding(0, 0, 1, 0);
                description.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label descriptio = new Label(formatio.getDescription());
                cde.add(description);
                cde.add(descriptio);

                                Container db = new Container(new BoxLayout(BoxLayout.X_AXIS));
    
                Label datedebut = new Label("date debut: ");
                 datedebut.getAllStyles().setFgColor(0xE35F5A);
                datedebut.getAllStyles().setMargin(0, 0, 1, 0);
                datedebut.getAllStyles().setPadding(0, 0, 1, 0);
                datedebut.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                    Label datedebutt = new Label(formatio.getDate_debut());
                    db.add(datedebut);
                    db.add(datedebutt);
                    
                                                    Container df = new Container(new BoxLayout(BoxLayout.X_AXIS));
                                                    Label datefin = new Label("date fin: ");
                                                     datefin.getAllStyles().setFgColor(0xE35F5A);
                datefin.getAllStyles().setMargin(0, 0, 1, 0);
                datefin.getAllStyles().setPadding(0, 0, 1, 0);
                datefin.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label datefinn = new Label(formatio.getDate_fin());
                                        df.add(datefin);
                                        df.add(datefinn);

                                                                        Container p = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label prix = new Label("prix: ");
                       prix.getAllStyles().setFgColor(0xE35F5A);
                prix.getAllStyles().setMargin(0, 0, 1, 0);
                prix.getAllStyles().setPadding(0, 0, 1, 0);
                prix.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label prixx = new Label(formatio.getPrix()+" dt");
                                        p.add(prix);
                                        p.add(prixx);

                                                                        Container du = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label duree = new Label("duree: ");
                         duree.getAllStyles().setFgColor(0xE35F5A);
                duree.getAllStyles().setMargin(0, 0, 1, 0);
                duree.getAllStyles().setPadding(0, 0, 1, 0);
                duree.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label dureee = new Label(formatio.getDuree()+" heures");
                                        du.add(duree);
                                        du.add(dureee);

                                                                        Container ad = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label adresse = new Label("adresse: ");
                       adresse.getAllStyles().setFgColor(0xE35F5A);
                adresse.getAllStyles().setMargin(0, 0, 1, 0);
                adresse.getAllStyles().setPadding(0, 0, 1, 0);
                adresse.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label adressee = new Label(formatio.getAdresse());
                                        ad.add(adresse);
                                        ad.add(adressee);
                                        
                                        
               Container em = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label email = new Label("email: ");
                     email.getAllStyles().setFgColor(0xE35F5A);
                email.getAllStyles().setMargin(0, 0, 1, 0);
                email.getAllStyles().setPadding(0, 0, 1, 0);
                email.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label emaill = new Label(formatio.getEmail());
                                        em.add(email);
                                        em.add(emaill);

                    Label Nbres = new Label("Nbres:");
                    
                    
                                                    Container lb = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label contact = new Label("tel: "); 
                     contact.getAllStyles().setFgColor(0xE35F5A);
                contact.getAllStyles().setMargin(0, 0, 1, 0);
                contact.getAllStyles().setPadding(0, 0, 1, 0);
                contact.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label contactt = new Label(""+formatio.getContact()); 
                                        lb.add(contact);
                                        lb.add(contactt);

                    
                     

                   
               
                    
                    
                     Toolbar te = f2.getToolbar();
                     inscrire.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               
               Formation.focusedId=formatio.getRef();
                              Formation.focusedIdd=formatio.getNom();
          int k= Formation.focusedIddd=formatio.getNbres_inscrits();
if (k == 0){
Dialog.show("Formation pleine","le nombres d'inscrits a cette formation  est atteint","ok",null);
}
else{
              AjouterInscription h = new AjouterInscription();
              h.getF().show();
            };
            }}
                     );
         te.addCommandToRightBar("< Back", null ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f.show();
            }
        });

            
        
           c4.add(c5);
           f2.add(c4);
           f2.add(cd);
            f2.add(ce);
                       f2.add(cde);
                       f2.add(db);
                       f2.add(df);
                       f2.add(p);
                       f2.add(du);
                       f2.add(ad);
                       f2.add(em);
                                              f2.add(lb);

            
            f2.add(inscrire);
            f2.show();
        }
             
    });        
c2.add(nom);
c2.add(domaine);
c2.add(entreprise);
c2.setLeadComponent(nom);
c1.add(imgv);
c1.add(c2);
c10.add(c1);
c10.add(seperator);
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