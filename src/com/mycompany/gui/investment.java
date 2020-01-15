/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entite.Projet;
import com.mycompany.Entite.TwilioSMS;
import com.mycompany.Service.ServiceProjet;
import java.io.IOException;


/**
 *
 * @author ASUS
 */
public class investment {

    public investment(int idp,Projet a) {
        final int i=idp;
        Form f1 = new Form(new BoxLayout(BoxLayout.Y_AXIS));
         Button back=new Button("back");
        Button invest=new Button("invest");
        //TextField montant=new TextField();
       // montant.setHint("Montant");
        //TextField carte=new TextField();
       // carte.setHint("carte bancaire");
        Validator val = new Validator();
        TextComponent montant=new TextComponent().label("montant"); 
        TextComponent carte=new TextComponent ().label("Carte Bancaire"); 

val.addConstraint(montant, new NumericConstraint(true));
val.addConstraint(carte, new NumericConstraint(true));
        f1.add(montant);
        f1.add(carte);
        f1.add(invest);
      
        f1.show();
        invest.addActionListener(e->{
            if(!montant.getText().equals("") && isNumber(montant.getText())&&  isNumber(carte.getText())&&!carte.getText().equals("")  ){
                        if( Dialog.show("invest"," accepter votre invest ","yes","no")){

            ServiceProjet s=new ServiceProjet();
            int i1=  Integer.parseInt(montant.getText());
            long i2=  Long.parseLong(carte.getText());
            s.ajoutinvest(i1,i2,i,19);
            a.setMontant(a.getMontant()+i1);
            TwilioSMS sms=new TwilioSMS("ACaa1a4f312d916842b47cd283604a4b74","1392160125d5296e5eac8e2704fae690","+12054303463");
            sms.sendSmsAsync("+21652003948"," NomProjet = "+a.getNomprojet()+" Montant ="+montant.getText()+"DT  montant actuelle =" +a.getMontant()+" DT");
            
             toutprojet p;
            try {
                p = new toutprojet();
                  p.showProjet(a);
            } catch (IOException ex) {
                //Logger.getLogger(investment.class.getName()).log(Level.SEVERE, null, ex);
            } } }
        });
        Style si = UIManager.getInstance().getComponentStyle("Button"); 
FontImage backimg = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, si);
         f1.getToolbar().addCommandToLeftBar("", backimg, (ev)->{  toutprojet l;
            try {
                l = new toutprojet();
                 l.showProjet(a);
            } catch (IOException ex) {
               
            }
        
          });
        
        f1.show(); 
        
    }
    
  public boolean isNumber(String ch) {
       String v = (String)ch;
    for(int i = 0 ; i < v.length() ; i++) {
      char c = v.charAt(i);
      if(c >= '0' && c <= '9' || c == '+' || c == '-') {
        continue;
      }
      return false;
    }
    return true;
  }  
    
    
}
