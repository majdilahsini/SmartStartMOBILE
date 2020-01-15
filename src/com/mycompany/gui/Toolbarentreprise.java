/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class Toolbarentreprise {
        public void ToolBarInstalle(Form f, Resources res) {
            f.getToolbar().addCommandToSideMenu("Home", null, (ActionListener) (ActionEvent evt) -> {
            new welcomeentreprise().getF().show();
        });
        f.getToolbar().addCommandToSideMenu("CrowFunding", null, (ActionListener) (ActionEvent evt) -> {
            try {
                
                Toolbar.id=2;
                toutprojet p=new toutprojet();
                 p.getF().show();
            } catch (IOException ex) {
              
            }
            
        });
        f.getToolbar().addCommandToSideMenu("Mes Offres", null, (ActionListener) (ActionEvent evt) -> {
         //   new AffichageOffre().show();
        });
        f.getToolbar().addCommandToSideMenu("Mes Formations", null,(ActionListener) (ActionEvent evt) -> {
            new AffichageFormation().getF().show();
        });
        f.getToolbar().addCommandToSideMenu("Mes Entretiens", null, null);
              f.getToolbar().addCommandToSideMenu("Mes Projets", null, null);

        f.getToolbar().addCommandToSideMenu("Forum", null, null);
    
}
}
