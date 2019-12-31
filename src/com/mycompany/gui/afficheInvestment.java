/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
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

    public afficheInvestment() throws ParseException {
        ServiceInvestissement ser=new ServiceInvestissement();
        Style s = UIManager.getInstance().getComponentStyle("Button"); FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
       EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 4), false);
        ArrayList<Map<String, Object>> affich = new ArrayList<>();
        ArrayList<Investissement> data=ser.getInvest(19);/////////////////////////////////////////////////////////////////////////////////////////////////////
Form hi = new Form("list PROJET", new BorderLayout());
Button back=new Button("back");

for(int i=0;i<data.size();i++)
affich.add(createListEntry(data.get(i).getIdProjet(),data.get(i).getMontant(),data.get(i).getDateInvesstissement()));

DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(affich); 
MultiList ml = new MultiList(model);
//ml.getUnselectedButton().setIconName("icon_URLImage"); 
//ml.getSelectedButton().setIconName("icon_URLImage"); 
ml.getUnselectedButton().setIcon(placeholder); 
ml.getSelectedButton().setIcon(placeholder); 
hi.add(BorderLayout.CENTER, ml);
        
   hi.show();
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
        
        
    }

   

    private Map<String, Object> createListEntry(String idProjet, long montant, String date) throws ParseException {
         Map<String, Object> entry = new HashMap<>(); 
  entry.put("Line1", "Nom Projet :"+idProjet); 
  entry.put("Line2", "Montant :"+montant); 
  
  Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            String newstr2 = new SimpleDateFormat("MM/dd/yyyy").format(date2);
  entry.put("Line3", "date :"+newstr2);
   
 return entry;
        
        
        
    }
    
    
    
    
    
}
