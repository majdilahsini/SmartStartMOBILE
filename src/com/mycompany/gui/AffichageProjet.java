/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Projet;
import com.mycompany.Entite.TwilioSMS;
import com.mycompany.Service.ServiceProjet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;





/**
 *
 * @author bhk
 */
public class AffichageProjet {

    Form f;
    SpanLabel lb;
  ComboBox<String> combo;
  Container content;
  
    public AffichageProjet() throws IOException {
        ServiceProjet serviceProjet=new ServiceProjet();
        Style s = UIManager.getInstance().getComponentStyle("Button"); 
        //FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
       //EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 4), false);
        f = new Form("MES PROJETS", new BorderLayout());
         content = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         ArrayList<Projet> data = serviceProjet.getList2();
ArrayList<Map<String, Object>> d = new ArrayList<>();
for(int j=0;j<data.size();j++)
{
    if(data.get(j).getId_enterprise() !=19)//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    {
        data.remove(j);
    }
}

        //-------------------------search
        TextField searchField = new TextField("", "Toolbar Search"); 
searchField.getHintLabel().setUIID("Title");
searchField.setUIID("Title");
searchField.getAllStyles().setAlignment(Component.LEFT);
f.getToolbar().setTitleComponent(searchField);
FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
searchField.addDataChangeListener((i1, i2) -> { 
    String t = searchField.getText();
    
    EncodedImage enc ;
                Image pictures;
    
    
    if(t.length() < 1) {
        
        
        
         content.removeAll();
                        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        cont.setScrollableY(true);
                        for (int i = 0; i < data.size(); i++) {
                            if(data.get(i).getNomprojet().contains(t)){
                                // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                
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
            
        
        
        
        
    } else {
        t = t.toLowerCase();
        //----------------------------------------------
          content.removeAll();
                        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        cont.setScrollableY(true);
                        for (int i = 0; i < data.size(); i++) {
                            if(data.get(i).getNomprojet().contains(t)){
                                // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                
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
            
        //--------------------------------------------
        
    }
    f.getContentPane().animateLayout(250);
});
f.getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
    searchField.startEditingAsync(); 
});
//----------------------------------------------------------
Button back=new Button("back");
 //ServiceProjet serviceProjet=new ServiceProjet();
      //  lb.setText(serviceProjet.getList2().toString());
//-----------------------------------------list-------------------------

/*for(int i=0;i<data.size();i++)
d.add(createListEntry(data.get(i).getNomprojet(), data.get(i).getIdCategorie(), data.get(i).getImage()));

DefaultListModel<Map<String, Object>> model; 
        model = new DefaultListModel<>(d);
MultiList ml = new MultiList(model); 
ml.getUnselectedButton().setIconName("icon_URLImage"); 
ml.getSelectedButton().setIconName("icon_URLImage"); 
ml.getUnselectedButton().setIcon(placeholder); 
ml.getSelectedButton().setIcon(placeholder); 
       */

/*Container list=new InfiniteContainer(){
            @Override
            public Component[] fetchComponents(int index, int amount) {
                Component[] more=new Component[data.size()];
for(int i=0;i<data.size();i++){
    
MultiButton twoLinesIconEmblem = new MultiButton(data.get(i).getNomprojet());
            
twoLinesIconEmblem.setIcon(placeholder); 
            
twoLinesIconEmblem.setEmblem(placeholder);
twoLinesIconEmblem.setTextLine2( data.get(i).getIdCategorie());
more[i]=twoLinesIconEmblem;
//Container c=new Container();
//lb.setText("hhhhhhhhhhhhhh");
//c.add(lb);
final Projet a=data.get(i);
twoLinesIconEmblem.addActionListener(e->{
  showProjet( a);

});

}
return more;
            }


};
       
f.add(BorderLayout.CENTER, list);*/


 Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
ComboBox<String> combo = new ComboBox<> ("none","att","active","term"
 



);
combo.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));
combo.addActionListener(e->{


});

c2.add(combo);
 EncodedImage enc ;
                Image pictures;

content.setScrollableY(true);
for (int i = 0; i < data.size(); i++) {
      
    String url = "http://localhost:82/piedv/web/imgs/"+data.get(i).getImage();
     
       
        final MultiButton mb = new MultiButton(data.get(i).getNomprojet());
                EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(f.getWidth()/3, f.getWidth() / 2, 0xffff0000), true);

          // enc = EncodedImage.create("/load.png");
           pictures = URLImage.createToStorage(placeholder, url, url,URLImage.RESIZE_SCALE);    
mb.setIcon(pictures);

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
                int idEtat;
                if("att".equals(c))
                    idEtat=1;
                else if("active"==c)
                     idEtat=2;
                else if("term"==c)
                    idEtat=3;
                else
                    idEtat=0;
                
                        content.removeAll();
                        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        cont.setScrollableY(true);
                         EncodedImage enc ;
                Image pictures;
                        for (int i = 0; i < data.size(); i++) {
                            if(data.get(i).getIdEtat()==idEtat){
                                // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                
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
                            else if(0==idEtat)
                            {
                                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                                
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
         Style si = UIManager.getInstance().getComponentStyle("Button"); 
FontImage backimg = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, si);
        
          f.getToolbar().addCommandToLeftBar("", backimg, (ev)->{//HomeForm h=new HomeForm();
         try {
                            toutprojet a;
                            
                            a = new toutprojet();
                            a.getF().show();
                        } catch (IOException ex) {
                           
                        }
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
 private Map<String, Object> createListEntry(String name, String date) {
 Map<String, Object> entry = new HashMap<>(); 
  entry.put("Line1", name); 
  entry.put("Line2", date); 
  entry.put("icon_URLImageName", name); 
 
 
 return entry;
    }
 
 public void showProjet(Projet a) throws IOException
 { 
     
     Container c1 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Form f2=(Form)new Form("   PROJET :"+a.getNomprojet(),new BoxLayout(BoxLayout.Y_AXIS));
        //---------------------------------------------------------------
        Resources theme;
    EncodedImage enc ;
    Image imgs;
    ImageViewer imgv;
    String url = "http://localhost:82/piedv/web/imgs/"+a.getImage();
       
            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(f2.getWidth(), f2.getWidth() / 2, 0xffff0000), true);
       
        imgs = URLImage.createToStorage(placeholder, url, url,URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
       
        f2.add(imgv);
        //---------------------------------------------------------------
        Button back=new Button("back");
        Button invest=new Button("supprimer");
        Button modifier=new Button("modifier");
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
        
         Label montant= new Label();
        c1.add(montant);
        if(a.getVotreFinance()-a.getMontant()>0)
          c1.add(createPieChartForm((double)(a.getVotreFinance()-a.getMontant()),(double)(a.getMontant())));
        else
           c1.add(createPieChartForm((double)(0),(double)(a.getMontant())));

        //c1.add(invest);
        // c1.add(modifier);
          
      
        
        f2.add(c1);
       
        final int id=a.getIdProjet();
        
        
        f2.getToolbar().addCommandToOverflowMenu("supprimer",null,e->{
            
        ServiceProjet s=new ServiceProjet();
        TwilioSMS sms=new TwilioSMS("ACaa1a4f312d916842b47cd283604a4b74","1392160125d5296e5eac8e2704fae690","+12054303463");
            sms.sendSmsAsync("+21652003948"," Supprission de NomProjet = "+a.getNomprojet());
               
        s.supprimerProjet(id);
            
        });
        
        
         f2.getToolbar().addCommandToOverflowMenu("modifier",null,e->{
            
        modifierProjet(a);
            
        });
        
        
         Nom.setText("Nom :  "+a.getNomprojet());
        adresse.setText("Montant actuelle :  "+a.getMontant()+" DT");
        email.setText("Num team : "+a.getNbreTeam());
        Description.setText("Description : "+a.getDescriptionProjet());
        categorie.setText("categorie : "+a.getIdCategorie());
        montant.setText("montant  a attendre : "+a.getVotreFinance()+" DT");
        Style si = UIManager.getInstance().getComponentStyle("Button"); 
FontImage backimg = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, si);
         f2.getToolbar().addCommandToLeftBar("", backimg, (ev)->{  AffichageProjet l;
         
         try {
             l = new AffichageProjet();
             l.getF().showBack();
         } catch (IOException ex) {
            
         }
         
         
          });
        f2.show();
        
     
 }
 public void modifierProjet(Projet a)
 {
     Form f1 = new Form("           Projet :    "+a.getNomprojet(),new BoxLayout(BoxLayout.Y_AXIS));
         Button back=new Button("back");
        Button modifier=new Button("modifier");
        //------------------------------------------
        TextField montant=new TextField();
        montant.setHint("Montant");
        TextField carte=new TextField();
        carte.setHint("carte bancaire");
        TextArea desc=new TextField();
        desc.setHint("Description");
        TextField vf=new TextField();
        vf.setHint("montant a attendre");
        TextField NT=new TextField();
        NT.setHint("Nbre de groupe");
        //TextField carte=new TextField();
        //carte.setHint("carte bancaire");
        //-----------------------------
         Label montantl= new Label();
        
        Label cartel= new Label();
       
        SpanLabel descl= new SpanLabel();
       
       Label vfl= new Label();
       
        Label NTl= new Label();
        
        Label datedl= new Label();
        
        Label datefl= new Label();
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
       Picker datePicker1 = new Picker();
       Picker datePicker2 = new Picker();
datePicker1.setType(Display.PICKER_TYPE_DATE);
        datePicker1.setFormatter(simpleDateFormat);
        datePicker2.setType(Display.PICKER_TYPE_DATE);
        datePicker2.setFormatter(simpleDateFormat);
        f1.add(montantl);
        
        f1.add(montant);
        
         f1.add(cartel);
        f1.add(carte);
        
         f1.add(descl);
         f1.add(desc);
         
          f1.add(vfl);
          f1.add(vf);
          
           f1.add(NTl);
           f1.add(NT);
           f1.add(datedl);
           f1.add(datePicker1);
           f1.add(datefl);
           f1.add(datePicker2);
           
            montantl.setText("Montant :");
        cartel.setText("Carte bancaire :");
        descl.setText("Description :");
        vfl.setText("Montant a attendre :");
        datedl.setText("date debut :");
        NTl.setText("nbre de team :");
        datefl.setText("date fin :");
           
         montant.setText(""+a.getMontant());
        carte.setText(""+a.getCompteBancaire());
        desc.setText(a.getDescriptionProjet());
        vf.setText(""+a.getVotreFinance());
        NT.setText(""+a.getNbreTeam());
        String originalString1 = a.getDateDebutProjet();
        String originalString2=a.getDateFinProjet();
     //int a= originalString.indexOf("T");koussa
     
      Date date;
      Date date2;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(originalString1);
            String newstr = new SimpleDateFormat("dd-MM-yyyy").format(date);
             datePicker1.setText(newstr);
        } catch (ParseException ex) {
            //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
        }
      try {
            date2 = new SimpleDateFormat("dd-MM-yyyy").parse(originalString2);
            String newstr2 = new SimpleDateFormat("dd-MM-yyyy").format(date2);
             datePicker2.setText(newstr2);
        } catch (ParseException ex) {
            //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        f1.add(modifier);
        f1.add(back);
        f1.show(); 
        modifier.addActionListener(e->{
            String erreur="";
            int i=0;
            ServiceProjet s=new ServiceProjet();
           if(!montant.getText().equals("")&& isNumber(montant.getText())){
            int i1=  Integer.parseInt(montant.getText());
            a.setMontant(i1);
            i++;
           }else{
              erreur=erreur+" | le montant erreur | "; 
           }
           if(!NT.getText().equals("")&&isNumber(NT.getText())){
              int i3=  Integer.parseInt(NT.getText());
               a.setNbreTeam(i3);
              i++;
           }
           else{
                erreur=erreur+" | le nbre team erreur | "; 
           }
            if(!vf.getText().equals("") ){
              float i4=  Float.parseFloat(vf.getText());
               a.setVotreFinance(i4);
               i++;
            }
            else{
                 erreur=erreur+" | le montant actuelle erreur | "; 
            }
               //int i5=  Integer.parseInt(NT.getText());
                if(!carte.getText().equals("")){
            long i2=  Long.parseLong(carte.getText());
             a.setCompteBancaire(i2);
             i++;
                }
          
            
            if(!carte.getText().equals("")&&isNumber(carte.getText())){
           
            a.setDescriptionProjet(desc.getText());
            i++;
            }else{
                 erreur=erreur+" | le Rib  erreur | "; 
            }
    
            
      Date date3;
      Date date4;
        Date currExpiry = new Date(); 
       
      if(vaideDate(datePicker1.getDate())) {
      a.setDateDebutProjet(datePicker1.getText());
      i++;
      }
      else{
           erreur=erreur+" | le date  erreur | "; 
      
      }
      
      if(vaideDateF(datePicker1.getDate(),datePicker2.getDate())) {
      a.setDateFinProjet(datePicker2.getText());
      i++;
      }
      else
      {
           erreur=erreur+" | le date Fin doit etre sup de date debut  erreur | ";
      }
       
            
            System.out.println(i);
             System.out.println(i);
             if(i>=7){
           if(Dialog.show("Click Yes Or No", "modifier projet ", "Yes", "No")){
            s.modifierProjet(a);
            
         try {
             showProjet(a);
         } catch (IOException ex) {
           
         }}
           }
           else
               Dialog.show("ERREUR  DE SAISIR ", "erreur : "+erreur, "Yes", "No");
         
               
         
         
        });
        
         back.addActionListener(ev->{  
             
         try {
             showProjet(a);
         } catch (IOException ex) {
            
         }
        
          });
        
       
        
    }
 
 
 
 
 
 
 
 private Container showProjetEtat(int idEtat)
 {
     
 ServiceProjet serviceProjet=new ServiceProjet();
    ArrayList<Projet> data1 = serviceProjet.getList2();
        Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
cont.setScrollableY(true);
        for (int i = 0; i < data1.size(); i++) {
            
        if(data1.get(i).getIdEtat()==idEtat){
             String url = "http://localhost:82/piedv/web/imgs/"+data1.get(i).getImage();
       int size = Display.getInstance().convertToPixels(8);
EncodedImage placeholde = EncodedImage.createFromImage(Image.createImage(size, size, 0xffcccccc), true);
Image pictures =URLImage.createToStorage(placeholde,"--------",url);
        final MultiButton mb = new MultiButton(data1.get(i).getNomprojet());
                   
mb.setIcon(pictures);

//mb.setEmblem(pictures[0]);
mb.setTextLine2( data1.get(i).getIdCategorie());
final Projet a=data1.get(i);
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
        cont.addComponent(mb);
        }

        }   
      return cont;  
       
 }
  /**
     * Creates a renderer for the specified colors.
     */
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            series.add("Project " + ++k, value);
        }

        return series;
    }

    public Container createPieChartForm(double i1,double i2) {

        // Generate the values
        double[] values = new double[]{i1, i2};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.GREEN, ColorUtil.GREEN, ColorUtil.GREEN, ColorUtil.GREEN, ColorUtil.GREEN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.rgb(252, 3, 2));
        r.setGradientStop(0, ColorUtil.rgb(252, 3, 2));
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Container f = new Container();
        f.setLayout(new BorderLayout());
        f.addComponent(BorderLayout.CENTER, c);
        return f;
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
  
    
    public boolean vaideDate(Date datep)
    {
        Date date =datep;
                   //System.err.println(date);Wed Jan 01 14:31:57 WAT 2020
               DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               String strDate = dateFormat.format(date);
                         String today = dateFormat.format(new Date());

               
              
              if  (today.compareTo(strDate)>=0){
                  return false;
              }
              else
                  return true;
    }
    
    
    public boolean vaideDateF(Date datepD,Date datepF)
    {
        Date dated =datepD;
         Date datef =datepF;
                   //System.err.println(date);Wed Jan 01 14:31:57 WAT 2020
               DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               String strDate1 = dateFormat.format(dated);
                String strDate2 = dateFormat.format(datef);
                         String today = dateFormat.format(new Date());
                        
               
              
              if  (strDate1.compareTo(strDate2)>=0){
                  return false;
              }
              else
                  return true;
    }
    
    
    
    
    
    
    
    
    
 
}
