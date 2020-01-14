/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;



/**
 *
 * @author Sadbo
 */
public class Toolbar {
    
    public void ToolBarInstall(Form f, Resources res) {

            
        f.getToolbar().addCommandToSideMenu("Home", null, (ActionListener) (ActionEvent evt) -> {
          //  new welcomeuser().getF().show();
        });
            f.getToolbar().addCommandToSideMenu("Profil", null, null);
        f.getToolbar().addCommandToSideMenu("Les Offres", null, (ActionListener) (ActionEvent evt) -> {
        
                new AffichageOffre().show();
      
               
            
        });
        f.getToolbar().addCommandToSideMenu("CrowFunding", null, (ActionListener) (ActionEvent evt) -> {
            try {
                toutprojet p=new toutprojet();
                 p.getF().show();
            } catch (IOException ex) {
              
            }
            
        });
        f.getToolbar().addCommandToSideMenu("Les Formations", null,(ActionListener) (ActionEvent evt) -> {
            new AffichageFormationuser().getF().show();
        });
        f.getToolbar().addCommandToSideMenu("Les Entretiens", null, null);
        f.getToolbar().addCommandToSideMenu("Les Projets", null, null);

        f.getToolbar().addCommandToSideMenu("Forum", null, null);
        
        /*Button inboxButton = new Button("Inbox", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
        new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        //inboxButton.addActionListener(e -> new InboxForm().show());
        f.getToolbar().addComponentToSideMenu(inbox);
        
        //f.getToolbar().addCommandToSideMenu("Stats", statsImage, e -> new StatsForm(res).show());
        //f.getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new CalendarForm(res).show());
        f.getToolbar().addCommandToSideMenu("Map", null, e -> {});
        //ef.getToolbar().addCommandToSideMenu("Trending", trendingImage, e -> new TrendingForm(res).show());
        f.getToolbar().addCommandToSideMenu("Settings", null, e -> {});*/
        
        // spacer
        /*getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        getToolbar().addComponentToSideMenu(new Label(res.getImage("profile_image.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label("Detra Mcmunn", "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label("Long Beach, CA", "SideCommandSmall"));*/
    }
    
}
