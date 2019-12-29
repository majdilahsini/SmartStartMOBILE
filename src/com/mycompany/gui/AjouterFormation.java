/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author lenovo
 */
public class AjouterFormation {
    Form f;
        Button btnretour;

    public AjouterFormation(){
                f = new Form("Ajout Formation",BoxLayout.y());

                UIBuilder.registerCustomComponent("Picker", Picker.class);
                Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        TextField nom=new TextField("", "nom");
        c.add(nom);
        //ComboBox t = new ComboBox();
        //c.add(t);
        String[] characters = { "Tyrion Lannister", "Jaime Lannister", "Cersei Lannister", "Daenerys Targaryen",
    "Jon Snow" /* cropped */
};
Picker p = new Picker();
p.setStrings(characters);
p.setSelectedString("Domaine");
p.addActionListener(e -> ToastBar.showMessage("You picked " + p.getSelectedString(), FontImage.MATERIAL_INFO));
c.add(p);
        TextField description=new TextField("", "description");
        c.add(description);
        TextField duree=new TextField("", "duree");
        c.add(duree);
        Label l1 = new Label("Date Debut:");
         Picker datedeb= new Picker();
         c.add(l1);
        c.add(datedeb);
        Label l2 = new Label("Date Fin:");
        Picker datefin= new Picker();
        c.add(l2);
        c.add(datefin);
        TextField prix=new TextField("", "prix");
        c.add(prix);
         TextField adresse=new TextField("", "adresse");
        c.add(adresse);
        TextField email=new TextField("", "email");
        c.add(email);
        TextField contact=new TextField("", "contact");
        c.add(contact);
        TextField nombres=new TextField("", "nombres");
        c.add(nombres);
        Button insertion= new Button("Ajouter");
       
        c.add(insertion);
         btnretour = new Button("Annuler");
        
        
        c.add(btnretour);
        btnretour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         AffichageFormation c = new AffichageFormation();
         c.getF().show();
            }
        
}
        );
        f.add(c);
        

    }
      public Form getF(){ 
         return f;
     }  
  public void setF(Form f){
    this.f=f;
    }
}
