/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;

/**
 *
 * @author lenovo
 */
public class AffichageFormation {
    Form f;
    Button Ajouter;
    Button Modifier;
        Button Supprimer;
          SpanLabel lb;
          Container c1;
          
public AffichageFormation(){
  // c1  = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    f = new Form("List Formations", BoxLayout.y());
                        Ajouter = new Button("Ajouter formation");
                        f.add(Ajouter);       
                       Ajouter.addActionListener(new ActionListener() {
          @Override
        
           public void actionPerformed(ActionEvent evt) {
               AjouterFormation h = new AjouterFormation();
               h.getF().show();

            }
                   }
          );

    FormationService forma = new FormationService();
    
    for(Formation i :forma.getList2()){
        addItem(i);
        
    }
}
public void addItem(Formation formatio){
    Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    String ref = String.valueOf(formatio.getRef());
                    Label l = new Label("ref:   "+ref);
                    Label nom = new Label("nom:"+formatio.getNom());
                    Label datedebut = new Label("date debut:"+formatio.getDate_debut());
                    Label datefin = new Label("date fin :"+formatio.getDate_fin());
                    Label domaine = new Label("domaine:"+formatio.getNomdomaine()); 
                    Label entreprise = new Label("entreprise:"+formatio.getNomentreprise());
                    Label prix = new Label("prix:"+formatio.getPrix());
                    Label duree = new Label("duree:"+formatio.getDuree());
                    Label adresse = new Label("adresse:"+formatio.getAdresse());
                    Label description = new Label("description:"+formatio.getDescription());
                    Label email = new Label("email:"+formatio.getEmail());
                    Label Nbres = new Label("Nbres:"+formatio.getNbres_inscrits());
                    Label contact = new Label("tel:"+formatio.getContact()); 
                    nom.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Dialog.show("Formation",nom.getText()+"\n"+description.getText()+"\n"+duree.getText()+"\n"+datedebut.getText()+"\n"+datefin.getText()+"\n"+prix.getText()+"\n"+adresse.getText()+"\n"+email.getText()+"\n"
                    +contact.getText(),"retour",null);
        }
    });
                    Container c4 = new Container(new FlowLayout(Component.CENTER));
                    Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Modifier = new Button("modifier");
                    Supprimer = new Button("Supprimer");
                 /*   Supprimer.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Dialog.show("suppression","etes vous sur de supprimer cette formation ?","oui","non");
        }
    }
                    );*/
                    Supprimer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            FormationService h = new FormationService();
            h.SupprimerFormation(formatio.getRef());
            
            AffichageFormation f = new AffichageFormation();
            f.getF().show();
        }
    });
             Modifier.addActionListener(new ActionListener() {
            @Override
        
            public void actionPerformed(ActionEvent evt) {
               Formation.focusedId=formatio.getRef();
               modifierFormation h = new modifierFormation();
               h.getF().show();
            }
             }
             );
c2.add(nom);
c2.add(domaine);
//c2.add(entreprise);
c3.add(Modifier);
c3.add(Supprimer);
c4.add(c3);
c2.add(c4);
 // c2.setLeadComponent(nom);
f.add(c2);
}
public Form getF(){
    return f;
}
public void setF(Form f){
    this.f=f;
}
}
