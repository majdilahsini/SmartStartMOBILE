/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.ParseException;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.DomaineFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class HomeForm extends Form  {
      Form f;
   
private Resources theme;
    public HomeForm() {
        f = new Form("home");
       
                theme = UIManager.initFirstTheme("/theme");

        
       
        
         //Form home = new Form("Sidebar Menu");

        com.codename1.ui.Toolbar tb = f.getToolbar();
        //Image icon = theme.getImage("load.png");
        Container topBar = BorderLayout.east(new Label());
        topBar.add(BorderLayout.SOUTH, new Label("Application Name"));
        tb.addComponentToSideMenu(topBar);

        tb.addMaterialCommandToSideMenu("projet", FontImage.MATERIAL_WEB, e -> {
 toutprojet a;
            try {
                a = new toutprojet();
                  a.getF().show();
            } catch (IOException ex) {
                
            }
                 
        });
        tb.addMaterialCommandToSideMenu("my projet", FontImage.MATERIAL_SETTINGS, e -> {
            AffichageProjet a;
             try {
                a = new AffichageProjet();
                  a.getF().show();
            } catch (IOException ex) {
                
            }
            
        });
        tb.addMaterialCommandToSideMenu("investment ", FontImage.MATERIAL_INFO, e -> {
            afficheInvestment ai;
            
            try {  
                ai = new afficheInvestment();
            } catch (ParseException ex) {
            }
        });
        
        /*f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                f.showBack();

            }
        });*/
        
        
        
        
        
        
        f.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Resources getTheme() {
        return theme;
    }

    public void setTheme(Resources theme) {
        this.theme = theme;
    }

    public boolean isFocusScrolling() {
        return focusScrolling;
    }

    public void setFocusScrolling(boolean focusScrolling) {
        this.focusScrolling = focusScrolling;
    }
    
    
    
}