/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;

/**
 *
 * @author lenovo
 */
public class AffichageFormationuser {
      Form f;
      Button b;
      public AffichageFormationuser(){
       f = new Form("List Formations", BoxLayout.y());
        

         FormationService forma = new FormationService();
    
    for(Formation i :forma.getList2()){
        addItem(i);
        
    }
    }
public void addItem(Formation formatio){
    Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    String ref = String.valueOf(formatio.getRef());
                    
                    Label l = new Label("ref:   "+ref);
                    Label nom = new Label("nom:    "+formatio.getNom());
                    Label datedebut = new Label("date debut:    "+formatio.getDate_debut());
                    Label datefin = new Label("date fin :    "+formatio.getDate_fin());
                    Label domaine = new Label("domaine:     "+formatio.getNomdomaine()); 
                    Label entreprise = new Label("entreprise:    "+formatio.getNomentreprise());
                    Label prix = new Label("prix:     "+formatio.getPrix());
                    Label duree = new Label("duree:    "+formatio.getDuree());
                    Label adresse = new Label("adresse:    "+formatio.getAdresse());
                    Label description = new Label("description:   "+formatio.getDescription());
                    Label email = new Label("email:   "+formatio.getEmail());
                    Label Nbres = new Label("Nbres:   "+formatio.getNbres_inscrits());
                    Label contact = new Label("tel:   "+formatio.getContact()); 
                     nom.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
                Form f2=(Form)new Form("detail formation",new BoxLayout(BoxLayout.Y_AXIS));
                                    Label nomm = new Label("nom:"+formatio.getNom());
                                                        Label domainee = new Label("domaine:"+formatio.getNomdomaine()); 
                    Label entreprisee = new Label("entreprise:"+formatio.getNomentreprise());


            f2.add(nomm);
            f2.add(domainee);
            f2.add(entreprisee);
            f2.add(description);
            f2.add(duree);
            f2.add(datedebut);
            f2.add(datefin);
            f2.add(prix);
            f2.add(adresse);
            f2.add(email);
            f2.add(contact);
            f2.show();
        }
             
    });        
c2.add(nom);
c2.add(domaine);
c2.add(entreprise);
f.add(c2);
}
public Form getF(){
    return f;
}
public void setF(Form f){
    this.f=f;
}
    
}