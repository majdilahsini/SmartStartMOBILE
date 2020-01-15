/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class modifierFormation {
    Form f;
    Button btnmodif;
    Button btnretour;
    public modifierFormation(){
        f = new Form("modifier Formation",BoxLayout.y());
        Label l1 = new Label("Nom:");
        TextField t1 = new TextField();
        Label l2 = new Label("Description:");
        TextField t2 = new TextField();
        Label l3 = new Label("Duree:");
        TextField t3 = new TextField();
        Label l4 = new Label("Date debut:");
        TextField t4 = new TextField();
        Picker datePicker1 = new Picker();
        datePicker1.setType(Display.PICKER_TYPE_DATE);
        
        Picker datePicker2 = new Picker();
        datePicker2.setType(Display.PICKER_TYPE_DATE);
        
       
        Label l5 = new Label("Date Fin:");
        TextField t5 = new TextField();
        Label l6 = new Label("Prix:");
        TextField t6 = new TextField();
        Label l7 = new Label("Adresse:");
        TextField t7 = new TextField();
        Label l8 = new Label("Contact:");
        TextField t8 = new TextField();
        Label l9 = new Label("Email:");
        TextField t9 = new TextField();
        f.add(l1);f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3);f.add(t3);
        f.add(l4);f.add(datePicker1);
        f.add(l5);f.add(datePicker2);
        f.add(l6);f.add(t6);
        f.add(l7);f.add(t7);
        f.add(l9);f.add(t9);
        f.add(l8);f.add(t8);
        
        
        FormationService iss=new FormationService();
        Formation s1=iss.getFormationById(Formation.focusedId);
        t1.setText(s1.getNom());
        t2.setText(s1.getDescription());
        t3.setText(String.valueOf(s1.getDuree()));
        datePicker1.setText(s1.getDate_debut());
                datePicker2.setText(s1.getDate_fin());
       // t4.setText(s1.getDate_debut());
       // t5.setText(s1.getDate_fin());
        t6.setText(String.valueOf(s1.getPrix()));
        t7.setText(s1.getAdresse());
        t8.setText(String.valueOf(s1.getContact()));
        t9.setText(s1.getEmail());
        
       
        btnmodif = new Button("modifier");
        f.add(btnmodif);
        btnmodif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 Label testdate = new Label("entrer une date valide");
        testdate.getAllStyles().setFgColor(0xE35F5A);
                testdate.getAllStyles().setMargin(0, 0, 1, 0);
                testdate.getAllStyles().setPadding(0, 0, 1, 0);
                testdate.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Date date1 = datePicker1.getDate();
                Date date2 = datePicker2.getDate();
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                                DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                                                                DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");

                String strDate1 = dateFormat1.format(date1);
                 String today = dateFormat3.format(new Date());

                                String strDate2 = dateFormat1.format(date2);
               
                Formation i = new Formation(Formation.focusedId,t1.getText(),t2.getText(),Integer.parseInt(t3.getText()),strDate1
                ,strDate2,t7.getText(),Double.parseDouble(t6.getText()),Integer.parseInt(t8.getText()),t9.getText());
                FormationService is = new FormationService();
                 if ((strDate2.compareTo(strDate1)>0)){
                is.ModifierFormation(i);
                
                AffichageFormation c = new AffichageFormation();
                c.getF().show();
            }
                else{f.add(testdate);}
            }
            }
        );
         btnretour = new Button("Annuler");
        
        
        f.add(btnretour);
        btnretour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         AffichageFormation c = new AffichageFormation();
         c.getF().show();
            }
        
}
        );
        
        
        
    }
    
 public void affichermodif(int ref){
     
 }
     public Form getF(){ 
         return f;
     }  
  public void setF(Form f){
    this.f=f;
    }
}
