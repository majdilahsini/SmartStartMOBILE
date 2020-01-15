/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Offre;
import com.mycompany.Entite.Session;
import com.mycompany.Service.OffreService;
import java.util.ArrayList;

/**
 *
 * @author Sadbo
 */
public class mescandidateures extends Form{
 
    public mescandidateures() {
        
       Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
       Resources theme = UIManager.initFirstTheme("/theme");
       
       this.setLayout(BoxLayout.y());
       
       OffreService os = new OffreService();
       ArrayList<Offre> offres = os.mescandidatures(Session.getId());
       
       for(Offre o : offres){
           
            Label titre = new Label(o.getTitre());
            Label date_pub = new Label(o.getDate_publication());
            Label domaine = new Label(o.getDomaine());
            Label sep = new Label(" ");

            titre.getAllStyles().setMargin(1, 0, 1, 0);
            titre.getAllStyles().setPadding(1, 0, 1, 0);
            titre.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", 5));
                      
            date_pub.getAllStyles().setFgColor(0xE35F5A);
            date_pub.getAllStyles().setMargin(0, 0, 1, 0);
            date_pub.getAllStyles().setPadding(0, 0, 1, 0);
            date_pub.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 2.5));
            
            domaine.getAllStyles().setMargin(0, 0, 1, 0);
            domaine.getAllStyles().setPadding(2, 0, 1, 0);
            domaine.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 3));
            
            Container offre = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
            ActionListener consulter = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new ConsulterOffre(o, theme).show();
                }
            };
            
            titre.addPointerPressedListener(consulter);
            date_pub.addPointerPressedListener(consulter);
            domaine.addPointerPressedListener(consulter);
                     
            offre.add(titre);
            offre.add(date_pub);
            offre.add(domaine);
            
            Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            offre.getAllStyles().setMargin(5,5,0,0);
            
            seperator.getAllStyles().setBorder(Border.createEmpty());
            seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            seperator.getAllStyles().setBgColor(0x000000);
            seperator.getAllStyles().setBgTransparency(40);
            seperator.setPreferredSize(new Dimension(0,5));
            
            c.add(offre);
            c.add(seperator);
       }
 
       this.add(c);
       
       
       this.getToolbar().addSearchCommand(new ActionListener () {
           @Override
           public void actionPerformed(ActionEvent evt) {
                String text = (String) evt.getSource();
                if (text.length() != 0 && text != null){
                    for (int i=0; i<offres.size()*2 ; i+=2) {
                        Container container = (Container) c.getComponentAt(i);
                        Label titre = (Label) container.getComponentAt(0);
                        if (titre.getText().toLowerCase().contains(text.toLowerCase())) {
                            container.setHidden(false);
                            container.setVisible(true);
                        } else {
                            container.setHidden(true);
                            container.setVisible(false);
                        }
                        refreshTheme();
                    } 
                } else {
                        for (int i=0; i<offres.size()*2 ; i+=2) {
                            Container container = (Container) c.getComponentAt(i);
                            container.setHidden(false);
                            container.setVisible(true);
                        }
                        refreshTheme();
                }
           }             
       });
       
       this.getToolbar().setTitleComponent(FlowLayout.encloseCenterMiddle(
                                                new Label("Mes Candidatures", "Title"),
                                                new Label(""+offres.size(), "InboxNumber")
                                        )
        );
       
    
       Toolbar t = new Toolbar();       
       t.ToolBarInstall(this, theme);       
     }
        
        
    }
    

    

