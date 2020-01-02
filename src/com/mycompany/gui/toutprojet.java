/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Projet;
import com.mycompany.Service.ServiceProjet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public class toutprojet {
Form f;
    SpanLabel lb;
    public toutprojet() throws IOException {
        
        //toutprojet af=new toutprojet();
        ServiceProjet serviceProjet=new ServiceProjet();
        Style s = UIManager.getInstance().getComponentStyle("Button"); 
        //FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
       //EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 4), false);
        f = new Form("TOUT PROJETS", new BorderLayout());
        Container content = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         ArrayList<Projet> data = serviceProjet.getList2();
         ArrayList<Projet> dataSearch=new ArrayList();
        for(int j=0;j<data.size();j++)
        {
            if(data.get(j).getIdEtat()==3)
            {
                data.remove(j);
                
                
            }
            else
                dataSearch.add(data.get(j));
        }
        //------------------------combobox

Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
ComboBox<String> combo = new ComboBox<> ();
HashSet<String> set=new  HashSet<String>();

for(int i=0;i<data.size();i++)
{
    set.add(data.get(i).getIdCategorie());
}
 Iterator<String> it = set.iterator();
 combo.addItem("none");
      while(it.hasNext()){
          
          combo.addItem(it.next());
           
      }

combo.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));


c2.add(combo);
//------------------------------------------------------

ArrayList<Map<String, Object>> d = new ArrayList<>();
        //-------------------------search
        TextField searchField = new TextField("", "Recherche Projet"); 
searchField.getHintLabel().setUIID("Title");
searchField.setUIID("Title");
searchField.getAllStyles().setAlignment(Component.LEFT);
f.getToolbar().setTitleComponent(searchField);
FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
searchField.addDataChangeListener((i1, i2) -> { 
     EncodedImage enc ;
                Image pictures;
    String t = searchField.getText();
     String c=combo.getSelectedItem();
     if("none".equals(c))
     {
         dataSearch.clear();
         dataSearch.addAll(data);
     }
      else
     {
     dataSearch.clear();
     int l=0;
     for(int j=0;j<data.size();j++)
        {
            if(data.get(j).getIdEtat()==3)
            {
                data.remove(j);
                
                
            }
            else if(data.get(j).getIdCategorie().equals(c))
                
                dataSearch.add(data.get(l));
            l++;
        }
    
    for(int k=0;k<dataSearch.size();k++)
    {
        if(!dataSearch.get(k).getIdCategorie().equals(c))
            dataSearch.remove(k);
            
    }
             }
    if(t.length() < 1) {
         content.removeAll();
                        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        cont.setScrollableY(true);
                        for (int i = 0; i < dataSearch.size(); i++) {
                            if(dataSearch.get(i).getNomprojet().contains(t)){
                                // Logger.getLogger(toutprojet.class.getName()).log(Level.SEVERE, null, ex);
                                
                                String url = "http://localhost:82/piedv/web/imgs/"+dataSearch.get(i).getImage();
                                enc = EncodedImage.createFromImage(Image.createImage(f.getWidth()/3, f.getWidth() / 3, 0xffff0000), true);
                                pictures = URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
                                final MultiButton mb = new MultiButton(dataSearch.get(i).getNomprojet());
                                mb.setIcon(pictures);
                                mb.setTextLine2( dataSearch.get(i).getIdCategorie());
                                final Projet a=dataSearch.get(i);
                                mb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        
                                        try {
                                            showProjet(a);
                                        } catch (IOException ex) {
                                            // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    
                                    
                                });
                                content.addComponent(mb);
                            }
                            
                        }
                        
                        content.getParent().removeComponent(content);
                        f.add(BorderLayout.CENTER, content);
            
        
        
        
        
    } else {
        t = t.toLowerCase();
        //----------------------------------------------
          content.removeAll();
                        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        cont.setScrollableY(true);
                        for (int i = 0; i < dataSearch.size(); i++) {
                            if(dataSearch.get(i).getNomprojet().contains(t)){
                                //Logger.getLogger(toutprojet.class.getName()).log(Level.SEVERE, null, ex);
                                
                                String url = "http://localhost:82/piedv/web/imgs/"+dataSearch.get(i).getImage();
                                enc = EncodedImage.createFromImage(Image.createImage(f.getWidth()/3, f.getWidth() / 3, 0xffff0000), true);
                                ;
                                pictures = URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
                                final MultiButton mb = new MultiButton(dataSearch.get(i).getNomprojet());
                                mb.setIcon(pictures);
                                mb.setTextLine2( dataSearch.get(i).getIdCategorie());
                                final Projet a=dataSearch.get(i);
                                mb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        try {
                                            showProjet(a);
                                        } catch (IOException ex) {
                                            // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    
                                    
                                });
                                content.addComponent(mb);
                            }
                            
                        }
                        
                        content.getParent().removeComponent(content);
                        f.add(BorderLayout.CENTER, content);
            
        //--------------------------------------------
        
    }
    f.getContentPane().animateLayout(250);
});
f.getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
    searchField.startEditingAsync(); 
});
//----------------------------------------------------------
Button back=new Button("back");
 
EncodedImage enc ;
  enc = EncodedImage.createFromImage(Image.createImage(f.getWidth()/3, f.getWidth() / 3, 0xffff0000), true);;
  Image imgs;
content.setScrollableY(true);
for (int i = 0; i < data.size(); i++) {
      
    String url = "http://localhost:82/piedv/web/imgs/"+data.get(i).getImage();
        imgs = URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
          
//EncodedImage place = EncodedImage.createFromImage(Image.createImage(size, size, 0xffcccccc), true);
//Image pic =URLImage.createToStorage(place,"--------",url);
       
        final MultiButton mb = new MultiButton(data.get(i).getNomprojet());
                   
mb.setIcon(imgs);

//mb.setEmblemName(url);
mb.setTextLine2( data.get(i).getIdCategorie());
final Projet a=data.get(i);
        mb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    showProjet(a);
                } catch (IOException ex) {
                   // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
        });
       
        content.addComponent(mb);
}
//content.revalidate();
f.add(BorderLayout.NORTH, c2);
f.add(BorderLayout.CENTER, content);
      
       
         combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print(combo.getSelectedItem());
                String c=combo.getSelectedItem();
                EncodedImage enc ;
                Image pictures;
                        content.removeAll();
                        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        cont.setScrollableY(true);
                        for (int i = 0; i < data.size(); i++) {
                            if(c.equals(data.get(i).getIdCategorie())){
                                //  Logger.getLogger(toutprojet.class.getName()).log(Level.SEVERE, null, ex);

                                String url = "http://localhost:82/piedv/web/imgs/"+data.get(i).getImage();
                                enc = EncodedImage.createFromImage(Image.createImage(f.getWidth()/3, f.getWidth() / 3, 0xffff0000), true);
                                pictures = URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
                                final MultiButton mb = new MultiButton(data.get(i).getNomprojet());
                                mb.setIcon(pictures);
                                mb.setTextLine2( data.get(i).getIdCategorie());
                                final Projet a=data.get(i);
                                mb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        try {
                                            showProjet(a);
                                        } catch (IOException ex) {
                                            // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    
                                    
                                });
                                content.addComponent(mb);
                            }
                            else if(c.equals("none"))
                            {
                                //Logger.getLogger(toutprojet.class.getName()).log(Level.SEVERE, null, ex);

                                String url = "http://localhost:82/piedv/web/imgs/"+data.get(i).getImage();
                                enc = EncodedImage.createFromImage(Image.createImage(f.getWidth()/3, f.getWidth() / 3, 0xffff0000), true);
                                pictures = URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
                                final MultiButton mb = new MultiButton(data.get(i).getNomprojet());
                                mb.setIcon(pictures);
                                mb.setTextLine2( data.get(i).getIdCategorie());
                                final Projet a=data.get(i);
                                mb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        try {
                                            showProjet(a);
                                        } catch (IOException ex) {
                                            // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    
                                    
                                });
                                content.addComponent(mb);
                            }
                            
                        }
                        
                        content.getParent().removeComponent(content);
                        f.add(BorderLayout.CENTER, content);
            }
        });
          
        
        
        
        //f = new Form();
       // lb = new SpanLabel("");
        //f.add(lb);
        //ServiceProjet serviceProjet=new ServiceProjet();
        //lb.setText(serviceProjet.getList2().toString());
        
         f.getToolbar().addCommandToOverflowMenu("my projet", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AffichageProjet a;
             try {
                a = new AffichageProjet();
                  a.getF().show();
            } catch (IOException ex) {
                
            }
            }
        });
          f.getToolbar().addCommandToOverflowMenu("investment", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
               afficheInvestment ai;
            
            try {  
                ai = new afficheInvestment();
            } catch (ParseException ex) {
            }
            }
        });
          Style si = UIManager.getInstance().getComponentStyle("Button"); 
FontImage backimg = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, si);
          f.getToolbar().addCommandToLeftBar("", backimg, (ev)->{//HomeForm h=new HomeForm();
        //  h.getF().show();
        
          });   
    }

    public Form getF() {
        return f;
    }

    public SpanLabel getLb() {
        return lb;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public void setLb(SpanLabel lb) {
        this.lb = lb;
    }
    public void showProjet(Projet a) throws IOException
 { 
     
     Container c1 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Form f2=(Form)new Form("PROJET",new BoxLayout(BoxLayout.Y_AXIS));
        //---------------------------------------------------------------
        Resources theme;
    EncodedImage enc ;
    Image imgs;
    ImageViewer imgv;
    String url = "http://localhost:82/piedv/web/imgs/"+a.getImage();
       
            enc =  EncodedImage.createFromImage(Image.createImage(f2.getWidth(), f2.getWidth() / 2, 0xffff0000), true);;
       
        imgs = URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
       
        f2.add(imgv);
        //---------------------------------------------------------------
        Button back=new Button("back");
        Button invest=new Button("invest");
      Label Nom= new Label();
        c1.add(Nom);
        Label adresse= new Label();
        c1.add(adresse);
        Label email= new Label();
        c1.add(email);
       Label Description= new Label();
        c1.add(Description);
        Label categorie= new Label();
        c1.add(categorie);
        Label investl= new Label();
       investl.getAllStyles().setFgColor(0xE35F5A);
         Label montant= new Label();
        c1.add(montant);
        if(a.getVotreFinance()>=a.getMontant())
        c1.add(invest);
       else
           c1.add(investl);
        investl.setText("merci la projet a attend son montant");
        final int id=a.getIdProjet();
        invest.addActionListener(e->{
            
        investment i=new investment(id,a);
        
            
        });
        
         f2.add(c1);
        Nom.setText("Nom :  "+a.getNomprojet());
        adresse.setText("Montant actuelle :  "+a.getMontant()+" DT");
        email.setText("Num team : "+a.getNbreTeam());
        Description.setText("Description : "+a.getDescriptionProjet());
        categorie.setText("categorie : "+a.getIdCategorie());
        montant.setText("montant  a attendre : "+a.getVotreFinance()+" DT");
        
        
         Style si = UIManager.getInstance().getComponentStyle("Button"); 
FontImage backimg = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, si);
         f2.getToolbar().addCommandToLeftBar("", backimg, (ev)->{   toutprojet l;
         
         try {
             l = new  toutprojet();
             l.getF().showBack();
         } catch (IOException ex) {
            
         }
         
         
          });
        f2.show();
        
     
 }
}
