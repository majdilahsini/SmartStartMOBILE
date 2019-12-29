/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.DomaineFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class HomeForm extends Form  {
     static Formation film = new Formation();
    static ArrayList<Formation> listProduits;
        public  HomeForm(com.codename1.ui.util.Resources resourceObjectInstance) {
       initGuiBuilderComponents(resourceObjectInstance);
            FormationService ss = new FormationService();
                    ArrayList<Formation> list=ss.getList2();
                    for(Formation s: list){
                                 Container seance = new Container(new BoxLayout(BoxLayout.X_AXIS)); 
                                          Container lblSeance = new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
                                                   Container detailSeance = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                                            Container btns = new Container(new BoxLayout(BoxLayout.X_AXIS));
                                                            
                                                            Label lblnomProd = new Label("Nom: ");
                                                                        Label lbprix = new Label("Domaine : ");
                                                                       Label lbentreprise = new Label("entreprise : ");

                                                                           lblSeance.add(lblnomProd);
            lblSeance.add(lbprix);
                        lblSeance.add(lbentreprise);

            Label nom =new Label();
            Label prix = new Label();
            Label entreprise = new Label();
            
            nom.setText(String.valueOf(s.getNom()));
            prix.setText(String.valueOf(s.getNomdomaine()));
            entreprise.setText(String.valueOf(s.getNomentreprise()));
          //prix.setText(String.valueOf(s.getDomaine_id()));
            detailSeance.add(nom);
            detailSeance.add(prix);
                        detailSeance.add(entreprise);

            seance.add(lblSeance);
            seance.add(detailSeance);
            
            seance.add(btns);
            
             gui_Box_Layout_Y.add(seance);
 
                  
                                                                        

                                                            
                                                            
                    }
                        
                    }
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("list des formations");
        setName("test");
        gui_Box_Layout_Y.setPreferredSizeStr("111.37566mm 56.613758mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "23.003801% auto auto 16.480448%").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

}
