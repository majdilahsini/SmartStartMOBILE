/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.FACE_PROPORTIONAL;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
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
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.Offre;
import com.mycompany.Service.FormationService;
import com.mycompany.Service.OffreService;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class AffichageOffre extends Form{
    
     Button b;
     Resources theme;
      
     public AffichageOffre(){

       Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

       theme = UIManager.initFirstTheme("/theme");
       this.setLayout(BoxLayout.y());

       OffreService os = new OffreService();
       
       for(Offre o :os.getList2()){
           
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
       
       this.getToolbar().setTitleComponent(FlowLayout.encloseCenterMiddle(
                                                new Label("Listes des offres", "Title"),
                                                new Label(""+os.getList2().size(), "InboxNumber")
                                        )
        );
       
       Toolbar t = new Toolbar();       
       t.ToolBarInstall(this, theme);       
     }
 }
