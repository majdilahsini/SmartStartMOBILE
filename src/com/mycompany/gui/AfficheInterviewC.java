/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Interviews;
import com.mycompany.Service.interviewService;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class AfficheInterviewC {
    Form f;
        Form f3;
                            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                           

        Form f2;

        Button Supprimer;
                Button ajouter;
                Button retour;
Resources theme;
Button Modifier;
Button passé;
Button encours;
Button futur;
    SpanLabel lb;

    public AfficheInterviewC() {

           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                         String today = dateFormat.format(new Date());
     f = new Form(BoxLayout.y());
       interviewService serviceTask=new interviewService();
              ArrayList<Interviews> ent = serviceTask.getList4();

      
        f.getToolbar().setTitleComponent(FlowLayout.encloseCenterMiddle(
                                                new Label("Listes des Entretien", "Title"),
                                                new Label(""+serviceTask.getList4().size(), "InboxNumber")
                                        ));
            com.mycompany.gui.Toolbar t = new com.mycompany.gui.Toolbar();       
       t.ToolBarInstall(f, theme); 
                                             Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

            passé = new Button("Passé");
            encours = new Button("jour j");
            futur = new Button("A venir");
            c1.add(passé); 
            c1.add(encours); 
            c1.add(futur); 
            f.add(c1);
       interviewService es=new interviewService();
       passé.setTextPosition(0);
       passé.setPreferredH(90);
              passé.setPreferredW(380);
               encours.setPreferredH(80);
                      encours.setTextPosition(0);

              encours.setPreferredW(450);
              futur.setPreferredH(80);
              futur.setPreferredW(450);


passé.addPointerPressedListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             passé.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
             encours.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
             futur.getAllStyles().setBackgroundGradientEndColor(CENTER, true);

             c2.removeAll();
               for (Interviews i : es.getList4() ){
                   if (i.getEtat() == 2){
                addItem(i);
            }}
               f.refreshTheme();
         }
     });

futur.addPointerPressedListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             passé.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
             encours.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
             futur.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
             c2.removeAll();
               for (Interviews i : es.getList4() ){
                   if (i.getEtat() == 1){
                addItem(i);
            }}
               f.refreshTheme();
         }
     });
encours.addPointerPressedListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
             passé.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
             encours.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
             futur.getAllStyles().setBackgroundGradientEndColor(CENTER, true);

             c2.removeAll();
               for (Interviews i : es.getList3() ){
                   if (i.getDate().equals(today)){
                addItem(i);
            }}
               f.refreshTheme();
         }
     });

        for (Interviews i : serviceTask.getList4() ){
                addItem(i);
            }

                         //////////////////////////////////////////////
              f.getToolbar().addSearchCommand(new ActionListener () {
           @Override
           public void actionPerformed(ActionEvent e) {
           //   interviewService serviceTask=new interviewService();
                String text = (String) e.getSource();
                if (text.length() != 0 && text != null){
                    for (int i=0; i<ent.size()*2 ;i+=2) {

                        Container container = (Container) c2.getComponentAt(i);
              
                      /*  Container container1 = (Container) f.getComponentAt(i);*/
                      Label titre = (Label) container.getComponentAt(0);
                       /* String titre = (String) es.getFullname();*/
                        if (titre.getText().toUpperCase().contains(text.toUpperCase())) {
                            container.setHidden(false);
                            container.setVisible(true);

                        } else {
                            container.setHidden(true);
                            container.setVisible(false);

                        }
                                } 
                } else {

                        for (int i=0; i<ent.size()*2 ; i+=2) {
                            Container container = (Container) c2.getComponentAt(i);
                            container.setHidden(false);
                            container.setVisible(true);

                        }
                }
                                                           f.refreshTheme();

           }             
       });
                  f.add(c2);

              ////////////////////////
    }
        
       public void addItem(Interviews contact){
            Container cpassé = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            Container cfutur = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                  /*  Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));*/
                          Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         seperator.getAllStyles().setBorder(Border.createEmpty());
            seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            seperator.getAllStyles().setBgColor(0x000000);
            seperator.getAllStyles().setBgTransparency(40);
            seperator.setPreferredSize(new Dimension(0,5));
            
                    String ref = String.valueOf(contact.getRef_ent());

            Label l = new Label("ref:   "+ref);
                        Label date = new Label("date:   "+contact.getDate());

            Label fullname = new Label(contact.getFullname());
            fullname.getAllStyles().setMargin(0, 0, 1, 0);
                fullname.getAllStyles().setPadding(0, 0, 1, 0);
               fullname.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
            Label heure = new Label("heure:   "+contact.getHeure_ent());
                        Label poste = new Label(contact.getPoste());
                   poste.getAllStyles().setMargin(0, 0, 1, 0);
                poste.getAllStyles().setPadding(0, 0, 1, 0);
               poste.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                
                       
          
  
             
         
            heure.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
Dialog.show("Contact :",""+fullname.getText()  + "\n"+heure.getText(),null,"ok");
            }});
            
            Supprimer = new Button("Annuler Entretien");
            Modifier = new Button("Modifier");
            retour = new Button("retour");

         /*   Supprimer.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                           interviewService h = new interviewService();

                h.SupprimerEntretien(contact.getRef_ent());
                   
                AfficheInterview c = new AfficheInterview();
        c.getF().show();
        
            }
                     }
          );
            retour.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                          
                   
                AfficheInterview c = new AfficheInterview();
        c.getF().show();
            }
                     }
          );*/
            
        /*    Modifier.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               Interviews.focusedId=contact.getRef_ent();
               ModifierInterview h = new ModifierInterview();
h.getF().show();
            }
                     }
          );*/
 
            fullname.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f2 = new Form(BoxLayout.y());
                   String label = ("Condidat "+contact.getFullname());
f2.setTitle(label);
                 Supprimer = new Button("Annuler Entretien");
            
             Container cp = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label Postee = new Label("Poste: "); 
                Postee.getAllStyles().setFgColor(0xE35F5A);
                Postee.getAllStyles().setMargin(0, 0, 1, 0);
                Postee.getAllStyles().setPadding(0, 0, 1, 0);
               Postee.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label Posteee = new Label(contact.getPoste());
                cp.add(Postee);
                cp.add(Posteee);
                
             Container cd = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label datee = new Label("Date: "); 
                datee.getAllStyles().setFgColor(0xE35F5A);
                datee.getAllStyles().setMargin(0, 0, 1, 0);
                datee.getAllStyles().setPadding(0, 0, 1, 0);
               datee.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label dateee = new Label(contact.getDate());
                cd.add(datee);
                cd.add(dateee);
             
              Container ch = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label heuree = new Label("Heure: "); 
                heuree.getAllStyles().setFgColor(0xE35F5A);
                heuree.getAllStyles().setMargin(0, 0, 1, 0);
                heuree.getAllStyles().setPadding(0, 0, 1, 0);
               heuree.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label heureee = new Label(contact.getHeure_ent());
                ch.add(heuree);
                ch.add(heureee);
                
              com.codename1.ui.Toolbar te = f2.getToolbar();
              
             
               
               te.addCommandToRightBar("< Retour", null ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
AfficheInterviewC c = new AfficheInterviewC();
                       f2.add("\n");
 c.getF().show();            }
        });
                f2.add(ch);
                                f2.add("\n");

                f2.add(cd);
                                f2.add("\n");

                f2.add(cp);
               
                f2.add("\n");
                f2.add("\n");

                f2.add(Supprimer);
                              
                Supprimer.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                           interviewService h = new interviewService();

                h.SupprimerEntretien(contact.getRef_ent());
                   
                AfficheInterviewC c = new AfficheInterviewC();
        c.getF().show();
        
            }
                     }
          );
                f2.show();
                
                
                
                
                
/*Dialog.show("Contact :",""+fullname.getText()+"\n"+date.getText() + "\n"+heure.getText() ,null,"ok"

);*/
               /* ComponentGroup cmpGroup = ComponentGroup.enclose(fullname,poste,Modifier,Supprimer);
                          if (contact.getEtat() == 1) {
                cmpGroup.getComponentAt(0).getAllStyles().setFgColor(0x008000);
                cmpGroup.getComponentAt(1).getAllStyles().setFgColor(0x008000);
                          }
                               if (contact.getEtat() == 2) {
                cmpGroup.getComponentAt(0).getAllStyles().setFgColor(0x00FF0000);
                cmpGroup.getComponentAt(1).getAllStyles().setFgColor(0x00FF0000);
                          }*/
          /*     Dialog d = new Dialog("Details");
d.setLayout(new BorderLayout());
d.add(BorderLayout.NORTH,retour);
d.add(BorderLayout.EAST, new SpanLabel(""+fullname.getText()+"\n"+date.getText() + "\n"+heure.getText(), ""+fullname.getText()+"\n"+date.getText() + "\n"+heure.getText()));
d.show(f.getHeight() / 2, 0, 0, 0);
d.setDisposeWhenPointerOutOfBounds(true);*/

            }
        });
                /*fullname.getAllStyles().setFgColor(0x008000);
                poste.getAllStyles().setFgColor(0x008000);*/
                            

               fullname.getAllStyles().setMargin(1, 0, 1, 0);
            fullname.getAllStyles().setPadding(1, 0, 1, 0);
            fullname.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", 5));
            
            poste.getAllStyles().setMargin(1, 0, 1, 0);
            poste.getAllStyles().setPadding(1, 0, 1, 0);
            poste.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4.5));
            poste.getAllStyles().setFgColor(0xE35F5A);
               // c3.add("\n");
               c3.add(fullname);
                c3.add(poste);
               // c2.add("\n");
              c2.add(c3);
               c2.add(seperator);
//                f.removeComponent(c2);
 
           }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
