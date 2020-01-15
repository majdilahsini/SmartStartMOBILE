/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Investissement;
import com.mycompany.Service.ServiceInvestissement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public class afficheInvestment {
Form hi;
    public afficheInvestment() throws ParseException {
        hi=new Form("        Mes investment        ",BoxLayout.y());
        Container cnt = new Container(BoxLayout.y());
        ServiceInvestissement ser=new ServiceInvestissement();
        Style s = UIManager.getInstance().getComponentStyle("Button"); FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
       EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 4), false);
        ArrayList<Map<String, Object>> affich = new ArrayList<>();
        ArrayList<Investissement> data=ser.getInvest(19);/////////////////////////////////////////////////////////////////////////////////////////////////////

Button back=new Button("back");

for(int i=0;i<data.size();i++)
hi.add(createListEntry(data.get(i).getIdProjet(),data.get(i).getMontant(),data.get(i).getDateInvesstissement()));


 
                Style si = UIManager.getInstance().getComponentStyle("Button"); 
FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, si);

         hi.getToolbar(). addCommandToLeftBar("", searchIcon, (ev)->{ // HomeForm h=new HomeForm();
            
        try {
                            toutprojet a;
                            
                            a = new toutprojet();
                            a.getF().show();
                        } catch (IOException ex) {
                           
                        }
          });
        
       hi.show();   
    }

   

    private Container createListEntry(String idProjet, long montant, String date) throws ParseException {
       
          Container cnt = new Container(BoxLayout.y());
          Container cn1 = new Container(BoxLayout.x());
Label nom = new Label("Nom Projet : "); 
                nom.getAllStyles().setFgColor(0xE35F5A);
                nom.getAllStyles().setMargin(0, 0, 1, 0);
                nom.getAllStyles().setPadding(0, 0, 1, 0);
                nom.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label nom1 = new Label(""); 

                nom1.setText(""+idProjet );
                cn1.add(nom);
                 cn1.add(nom1);
                Container cn2 = new Container(BoxLayout.x());
    Label mont = new Label("Montant : "); 
                mont.getAllStyles().setFgColor(0xE35F5A);
                mont.getAllStyles().setMargin(0, 0, 1, 0);
                mont.getAllStyles().setPadding(0, 0, 1, 0);
                mont.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label mont1 = new Label(""); 

                mont1.setText(""+montant );            
                cn2.add(mont);
                 cn2.add(mont1);
  Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            String newstr2 = new SimpleDateFormat("MM/dd/yyyy").format(date2);
            Container cn3 = new Container(BoxLayout.x());
  Label dte = new Label("date : "); 
                dte.getAllStyles().setFgColor(0xE35F5A);
                dte.getAllStyles().setMargin(0, 0, 1, 0);
                dte.getAllStyles().setPadding(0, 0, 1, 0);
                dte.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label dte1 = new Label(""); 
                dte1.setText(newstr2 );    
                 cn3.add(dte);
                  cn3.add(dte1);
                   Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         seperator.getAllStyles().setBorder(Border.createEmpty());
            seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            seperator.getAllStyles().setBgColor(0x000000);
            seperator.getAllStyles().setBgTransparency(40);
            seperator.setPreferredSize(new Dimension(0,5));
   cnt.add(cn1);
      cnt.add(cn2);
         cnt.add(cn3);
         cnt.add(seperator);
 return cnt;
        
        
        
    }
    
    
    
    
    
}
