/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Interviews;
import com.mycompany.Service.ServiceTask;
import com.mycompany.Service.interviewService;
import java.util.ArrayList;
import com.codename1.ui.Toolbar;
import java.util.Date;

/**
 *
 * @author User
 */
public class AfficheInterview {
    Form f;
        Form f3;

        Form f2;

        Button Supprimer;
                Button ajouter;
                Button retour;
Resources theme;
Button Modifier;
    SpanLabel lb;
Button passé;
Button encours;
Button futur;

    
    public AfficheInterview() {

           
     f = new Form(BoxLayout.y());
       interviewService serviceTask=new interviewService();
       FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
fab.addActionListener((ActionListener) (ActionEvent evt) -> {
    AfficheOffres_Ent h = new AfficheOffres_Ent();
   /* h.getF().show();*/
   h.getF().show();
       });fab.bindFabToContainer(f.getContentPane());
        f.getToolbar().setTitleComponent(FlowLayout.encloseCenterMiddle(
                                                new Label("Listes des Entretien", "Title"),
                                                new Label(""+serviceTask.getList2().size(), "InboxNumber")
                                        ));
            com.mycompany.gui.Toolbar t = new com.mycompany.gui.Toolbar();       
       t.ToolBarInstall(f, theme); 
                       Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                              Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));


        for (Interviews contact : serviceTask.getList2() ){
                        Container details = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

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
                        Label poste = new Label("Poste:   "+contact.getPoste());
                   poste.getAllStyles().setMargin(0, 0, 1, 0);
                poste.getAllStyles().setPadding(0, 0, 1, 0);
               poste.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                
                       
          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               String strDate = dateFormat.format(date);
                         String today = dateFormat.format(new Date());
            passé = new Button("Passé");
            encours = new Button("Ajourd'hui");
            futur = new Button("A venir");
            c1.add(passé); 
            c1.add(encours); 
            c1.add(futur); 

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
            Modifier = new Button("Modifier");
            
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
                
              Toolbar te = f2.getToolbar();
              
             
               Supprimer.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                           interviewService h = new interviewService();

                h.SupprimerEntretien(contact.getRef_ent());
                   
                AfficheInterview c = new AfficheInterview();
        c.getF().show();
        
            }
                     }
          );
               
               Modifier.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               Interviews.focusedId=contact.getRef_ent();
               ModifierInterview h = new ModifierInterview();
h.getF().show();
            }
                     }
          );
               
               te.addCommandToRightBar("< Retour", null ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f.show();
            }
        });
                f2.add("\n");
                f2.add(ch);
                                f2.add("\n");

                f2.add(cd);
                                f2.add("\n");

                f2.add(cp);
               
                f2.add("\n");
                f2.add("\n");

                f2.add(Supprimer);
                f2.add(Modifier);
                
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
   
              if (contact.getEtat() == 1) {
         c2.getAllStyles().setFgColor(0x9b870c);      }
                if (contact.getEtat() == 1) {
                fullname.getAllStyles().setFgColor(0x008000);
                poste.getAllStyles().setFgColor(0x008000);
                          }
                               if (contact.getEtat() == 2) {
                fullname.getAllStyles().setFgColor(0x00FF0000);
                poste.getAllStyles().setFgColor(0x00FF0000);
                               }
                details.add("\n");
               details.add(fullname);
                details.add(poste);
                details.add("\n");
                                c2.add(details);
                c2.add(seperator);
                
                

       }            
                        f.add(c1);
                        f.add(c2);

                         //////////////////////////////////////////////
             f.getToolbar().addSearchCommand(new ActionListener () {
           @Override
           public void actionPerformed(ActionEvent evt) {
                String text = (String) evt.getSource();
                if (text.length() != 0 && text != null){
                    for (int i=0; i<serviceTask.getList2().size()*2 ; i+=2) {
                        Container container = (Container) c2.getComponentAt(i);
                        Label titre = (Label) container.getComponentAt(1);
                        if (titre.getText().contains(text)) {
                            container.setHidden(false);
                            container.setVisible(true);
                        } else {
                            container.setHidden(true);
                            container.setVisible(false);
                        }
                    } 
                } else {
                        for (int i=0; i<serviceTask.getList2().size()*2 ; i+=2) {
                            Container container = (Container) c2.getComponentAt(i);
                            container.setHidden(false);
                            container.setVisible(true);
                        }
                }
           }             
       });
              ////////////////////////
    }
        
     /*  public void addItem(Interviews contact){*/

       

    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
