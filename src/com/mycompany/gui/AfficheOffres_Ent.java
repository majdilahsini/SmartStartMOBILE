/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.mycompany.Entite.OffreEnt;
import com.mycompany.Entite.Interviews;
import com.mycompany.Service.OffreEntService;
import com.mycompany.Service.interviewService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class AfficheOffres_Ent {
        Form f;
                Form hi;

        Button Supprimer;
        Button ajouter;
        Button retour;
                Button retour2;


    public AfficheOffres_Ent() {

           
      f = new Form("List des offres", BoxLayout.y());

       OffreEntService serviceTask=new OffreEntService();
       
        for (OffreEnt i : serviceTask.getList2() ){
                addItem(i);
            }
        
    }
    
       public void addItem(OffreEnt contact){
            Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         seperator.getAllStyles().setBorder(Border.createEmpty());
            seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            seperator.getAllStyles().setBgColor(0x000000);
            seperator.getAllStyles().setBgTransparency(40);
            seperator.setPreferredSize(new Dimension(0,5));
   Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    String ref = String.valueOf(contact.getOffre_id());
            Label refu = new Label("ref:   "+ref);

                         Container cf = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Label fullname = new Label("Condidat:   ");
                           fullname.getAllStyles().setFgColor(0xE35F5A);
             fullname.getAllStyles().setMargin(0, 0, 1, 0);
                fullname.getAllStyles().setPadding(0, 0, 1, 0);
               fullname.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label fullnamee = new Label(contact.getNomCondidat());
cf.add(fullname);
                cf.add(fullnamee);
                        Container cp = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label poste = new Label("poste:   ");
                    poste.getAllStyles().setFgColor(0xE35F5A);
                   poste.getAllStyles().setMargin(0, 0, 1, 0);
                poste.getAllStyles().setPadding(0, 0, 1, 0);
               poste.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                      Label Posteee = new Label(contact.getPoste());
                      cp.add(poste);
                cp.add(Posteee);

            Container cl = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label lettre_motivation = new Label("lettre:   ");
                            lettre_motivation.getAllStyles().setFgColor(0xE35F5A);

            lettre_motivation.getAllStyles().setMargin(0, 0, 1, 0);
              lettre_motivation.getAllStyles().setPadding(0, 0, 1, 0);
              lettre_motivation.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                   Label lettre_motivationn = new Label(contact.getLettreMotivation());
cl.add(lettre_motivation);
                cl.add(lettre_motivationn);
                
            ajouter = new Button("ajouter");
           retour = new Button("retour");
             retour.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               AfficheInterview3 c = new AfficheInterview3();
        c.getF().show();

            }
                     }
          );
             retour2 = new Button("retour");
             retour2.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               AfficheOffres_Ent c = new  AfficheOffres_Ent();
        c.getF().show();

            }
                     }
          );


           
                                
                    Supprimer = new Button("Supprimer");

                    Supprimer.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
                   OffreEntService h = new OffreEntService();

                h.SupprimerOffreEnt(contact.getOffre_id());
                   
               AfficheInterview3 c = new AfficheInterview3();
            c.getF().show();
            }
                     }
          );
                   
                       ajouter.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               AjouterEntretienEnt h = new AjouterEntretienEnt();
               h.getF().show();

            }
                     }
          );
 com.codename1.ui.Toolbar te = f.getToolbar();

                    te.addCommandToRightBar("< Retour", null ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               AfficheInterview3 c = new AfficheInterview3();
        c.getF().show();
            }
        });
           /*  ComponentGroup cmpGroup = ComponentGroup.enclose(fullname,poste,lettre_motivation);*/
           
/*             c1.add(fullname);
                          c1.add(poste);

             c1.add(lettre_motivation);*/
 fullname.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
     Container ccc = new Container(new BoxLayout(BoxLayout.X_AXIS));

     OffreEnt.focusedId=contact.getOffre_id();
      OffreEnt.focusedPoste=contact.getPoste();
OffreEnt.focusedNomEntre=contact.getNomEntreprise();
Dialog d = new Dialog("Option");
ccc.add(Supprimer);
ccc.add(ajouter);
ccc.add(retour2);
d.add(ccc);
/*d.setLayout(new BorderLayout());
d.add(BorderLayout.EAST,ajouter);
d.add(BorderLayout.WEST,Supprimer);
d.add(BorderLayout.NORTH,retour2);*/


d.show(2000, 0,0, 0);
d.setDisposeWhenPointerOutOfBounds(true);
            }
            });
 

  fullnamee.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                     Container cccc = new Container(new BoxLayout(BoxLayout.X_AXIS));

       OffreEnt.focusedId=contact.getOffre_id();
 OffreEnt.focusedPoste=contact.getPoste();
OffreEnt.focusedNomEntre=contact.getNomEntreprise();
Dialog d = new Dialog("Option");
cccc.add(Supprimer);
cccc.add(ajouter);
cccc.add(retour2);
d.add(cccc);

d.show(2000, 0,0, 0);
//d.show(100 / 1, 0, 0, 0);
d.setDisposeWhenPointerOutOfBounds(true);
            }
            });
            /* c3.add(ajouter);
             c3.add(Supprimer);*/
                          c2.add(cf);
                          c2.add(cp);
                          c2.add(cl);

                                                    c2.add(seperator);

                         /* c2.add(c3);*/


           /* c2.add(refu);
            c2.add(fullname);
            c2.add(poste);
            c2.add(lettre_motivation);
            c2.add("\n");
            c3.add(Supprimer);
            c3.add(ajouter);
             c1.add(c2);
            c1.add(c3);*/
           /* f.add(c1);*/
                          f.add(c2);


            

    
       }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
