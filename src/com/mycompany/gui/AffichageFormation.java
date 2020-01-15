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
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.FormationService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class AffichageFormation {
    Form f,f2,hi;
    public static final int RIGHT= 1;
    Button Ajouter;
    Button Modifier;
        Button Supprimer;
         Button depasseé ;
     Button encours ;
     Button futur ;
          SpanLabel lb;
          Container c1;
             EncodedImage enc;
                                Resources theme;
                                        Container c10 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

    Image imgs;
    ImageViewer imgv;
     String url = "http://localhost/pidev2/web/images/";
          
public AffichageFormation(){
           f = new Form(BoxLayout.y());

 Container ch = new Container(new BoxLayout(BoxLayout.X_AXIS));

         depasseé = new Button("passé");
       //  depasseé.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
     encours = new Button("en cours");
     futur = new Button("a venir");
     ch.add(depasseé);
     depasseé.setTextPosition(0);
    depasseé.setPreferredH(80);
    depasseé.setPreferredW(380);

    
    encours.setTextPosition(1);
    encours.setPreferredH(80);
    encours.setPreferredW(490);
    
    
    futur.setTextPosition(0);
    futur.setPreferredH(80);
    futur.setPreferredW(450);
  //  futur.setTextPosition(200);
     ch.add(encours);
     ch.add(futur);
     f.add(ch);
         FormationService formaa = new FormationService();
          // ArrayList<Formation> offres = formaa.getList2();

          
             encours.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                         encours.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                         depasseé.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                         futur.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                         c10.removeAll();
      for(Formation i :formaa.getList1()){
            if (i.getEtat() == 1 ){
            
            addItem(i);
               
        }
      }
      f.refreshTheme();
      }
              
            });
         //    f.add(c10);
              depasseé.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                         depasseé.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                         encours.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                         futur.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                         c10.removeAll();
                           for(Formation i :formaa.getList1()){
            if (i.getEtat() == 2 ){
             
            addItem(i);
             
        }
      }
                            f.refreshTheme();
     }
            });
              futur.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                         futur.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                          encours.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                          depasseé.getAllStyles().setBackgroundGradientEndColor(CENTER, true);
                           DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
                                            String today = dateFormat3.format(new Date());

                          c10.removeAll();
                              for(Formation i :formaa.getList1()){
            if ((today.compareTo(i.getDate_debut())<0) ){
             
            addItem(i);
             
        }
      }
                            f.refreshTheme();

               }
            });
  // c1  = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                   //     Ajouter = new Button("Ajouter formation");
                             
                   /*     FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);

                        fab.addActionListener((ActionListener) (ActionEvent evt) -> {
    AjouterFormation h = new AjouterFormation();
               h.getF().show();
       });
                        fab.bindFabToContainer(f.getContentPane());*/
                      //  f.add(fab);
                    //   Ajouter.addActionListener(new ActionListener() {
       //   @Override
        
       //    public void actionPerformed(ActionEvent evt) {
        //       AjouterFormation h = new AjouterFormation();
         //      h.getF().show();

         //   }
         //          }
        //  );

    FormationService forma = new FormationService();
    
    for(Formation i :forma.getList1()){
        addItem(i);
       
    }
      f.getToolbar().setTitleComponent(FlowLayout.encloseCenterMiddle(
                                                new Label("Listes des formations", "Title"),
                                                new Label(""+formaa.getList1().size(), "InboxNumber")
                                        )
        );
    com.mycompany.gui.Toolbarentreprise t = new com.mycompany.gui.Toolbarentreprise();       
       t.ToolBarInstalle(f, theme); 
                   
    f.add(c10);
}
public void addItem(Formation formatio){
            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

             Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         seperator.getAllStyles().setBorder(Border.createEmpty());
            seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
            seperator.getAllStyles().setBgColor(0x000000);
            seperator.getAllStyles().setBgTransparency(40);
            seperator.setPreferredSize(new Dimension(0,5));
  try {
            enc = EncodedImage.create("/ChubbyEmbarrassedEchidna-size_restricted.gif");
        } catch (IOException ex) {
        }

        imgs = URLImage.createToStorage(enc, url+formatio.getImage(), url+formatio.getImage(),URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
    Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    String ref = String.valueOf(formatio.getRef());
                    Label l = new Label("ref:   "+ref);
                    Label nom = new Label(formatio.getNom());
                      nom.getAllStyles().setMargin(1, 0, 1, 0);
            nom.getAllStyles().setPadding(1, 0, 1, 0);
            nom.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", 4));
              //      Label datedebut = new Label("date debut:"+formatio.getDate_debut());
                //    Label datefin = new Label("date fin :"+formatio.getDate_fin());
                    Label domaine = new Label(formatio.getNomdomaine());
                        domaine.getAllStyles().setFgColor(0xE35F5A);
            domaine.getAllStyles().setMargin(1, 0, 1, 0);
            domaine.getAllStyles().setPadding(1, 0, 1, 0);
            domaine.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 2.5));
               //     Label entreprise = new Label("entreprise:"+formatio.getNomentreprise());
               //     Label prix = new Label("prix:"+formatio.getPrix());
                //    Label duree = new Label("duree:"+formatio.getDuree());
                 //   Label adresse = new Label("adresse:"+formatio.getAdresse());
                //    Label description = new Label("description:"+formatio.getDescription());
                //    Label email = new Label("email:"+formatio.getEmail());
                //    Label Nbres = new Label("Nbres:"+formatio.getNbres_inscrits());
                //    Label contact = new Label("tel:"+formatio.getContact()); 
                    nom.addPointerPressedListener(new ActionListener() {
   @Override
        public void actionPerformed(ActionEvent evt) {
                f2 = new Form("             formation "+formatio.getNom(),BoxLayout.y());
              //   String label = ("formation "+formatio.getNom());
 //f2.setTitle(label);
 
Container c4 = new Container(new FlowLayout(CENTER,CENTER));
Container c6 = new Container(new FlowLayout(CENTER,CENTER));

                           Container c5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                        try {
            enc = EncodedImage.create("/Loading-Icon-by-Kanggraphic-2-580x386.jpg");
        } catch (IOException ex) {
        }

        imgs = URLImage.createToStorage(enc, url+formatio.getImage(), url+formatio.getImage(),URLImage.RESIZE_SCALE);
        imgv = new ImageViewer(imgs);
         Label nomm = new Label(formatio.getNom());
                      
                       c5.add(imgv);
                       c5.add("\n");
                         Container cd = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label domaineeee = new Label("domaine: "); 
                domaineeee.getAllStyles().setFgColor(0xE35F5A);
                domaineeee.getAllStyles().setMargin(0, 0, 1, 0);
                domaineeee.getAllStyles().setPadding(0, 0, 1, 0);
                domaineeee.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                Label domainee = new Label(formatio.getNomdomaine());
                cd.add(domaineeee);
                cd.add(domainee);
                
               Container cde = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Label description = new Label("description:");
                description.getAllStyles().setFgColor(0xE35F5A);
                description.getAllStyles().setMargin(0, 0, 1, 0);
                description.getAllStyles().setPadding(0, 0, 1, 0);
                description.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                SpanLabel descriptio = new SpanLabel(formatio.getDescription());
                cde.add(description);
                cde.add(descriptio);

                    Container db = new Container(new BoxLayout(BoxLayout.X_AXIS));
    
                Label datedebut = new Label("date debut: ");
                 datedebut.getAllStyles().setFgColor(0xE35F5A);
                datedebut.getAllStyles().setMargin(0, 0, 1, 0);
                datedebut.getAllStyles().setPadding(0, 0, 1, 0);
                datedebut.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                    Label datedebutt = new Label(formatio.getDate_debut());
                    db.add(datedebut);
                    db.add(datedebutt);
                    
                    
                                                    Container df = new Container(new BoxLayout(BoxLayout.X_AXIS));
                                                    Label datefin = new Label("date fin: ");
                                                     datefin.getAllStyles().setFgColor(0xE35F5A);
                datefin.getAllStyles().setMargin(0, 0, 1, 0);
                datefin.getAllStyles().setPadding(0, 0, 1, 0);
                datefin.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label datefinn = new Label(formatio.getDate_fin());
                                        df.add(datefin);
                                        df.add(datefinn);
                                        
                                          Container p = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label prix = new Label("prix: ");
                       prix.getAllStyles().setFgColor(0xE35F5A);
                prix.getAllStyles().setMargin(0, 0, 1, 0);
                prix.getAllStyles().setPadding(0, 0, 1, 0);
                prix.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label prixx = new Label(formatio.getPrix()+" dt");
                                        p.add(prix);
                                        p.add(prixx);

                                             Container du = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label duree = new Label("duree: ");
                         duree.getAllStyles().setFgColor(0xE35F5A);
                duree.getAllStyles().setMargin(0, 0, 1, 0);
                duree.getAllStyles().setPadding(0, 0, 1, 0);
                duree.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label dureee = new Label(formatio.getDuree()+" heures");
                                        du.add(duree);
                                        du.add(dureee);
                                        
                    Container ad = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label adresse = new Label("adresse: ");
                       adresse.getAllStyles().setFgColor(0xE35F5A);
                adresse.getAllStyles().setMargin(0, 0, 1, 0);
                adresse.getAllStyles().setPadding(0, 0, 1, 0);
                adresse.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        SpanLabel adressee = new SpanLabel(formatio.getAdresse());
                                        ad.add(adresse);
                                        ad.add(adressee);
                                        
                                        
               Container em = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label email = new Label("email: ");
                     email.getAllStyles().setFgColor(0xE35F5A);
                email.getAllStyles().setMargin(0, 0, 1, 0);
                email.getAllStyles().setPadding(0, 0, 1, 0);
                email.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label emaill = new Label(formatio.getEmail());
                                        em.add(email);
                                        em.add(emaill);
                                        
                                        Container lb = new Container(new BoxLayout(BoxLayout.X_AXIS));

                    Label contact = new Label("tel: "); 
                     contact.getAllStyles().setFgColor(0xE35F5A);
                contact.getAllStyles().setMargin(0, 0, 1, 0);
                contact.getAllStyles().setPadding(0, 0, 1, 0);
                contact.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label contactt = new Label(""+formatio.getContact()); 
                                        lb.add(contact);
                                        lb.add(contactt);
                                        
                                                                                Container nb = new Container(new BoxLayout(BoxLayout.X_AXIS));

                                                            Label Nbres = new Label("Nombres :");
                                                            Nbres.getAllStyles().setFgColor(0xE35F5A);
                Nbres.getAllStyles().setMargin(0, 0, 1, 0);
                Nbres.getAllStyles().setPadding(0, 0, 1, 0);
                Nbres.getAllStyles().setFont(Font.createTrueTypeFont("native:MainThin", (float) 4));
                                        Label Nbresss = new Label(""+formatio.getNbres_initiale()); 
                                        nb.add(Nbres);
                                        nb.add(Nbresss);

                     Toolbar te = f2.getToolbar();
                      te.addCommandToLeftBar("<-", null ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f.show();
            }
        });
                        c4.add(c5);
           f2.add(c4);
                                      Container c500 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

             c500.add(cd);
                       c500.add(cde);
                       c500.add(db);
                       c500.add(df);
                       c500.add(p);
                       c500.add(du);
                       c500.add(ad);
                       c500.add(em);
                                              c500.add(lb);
                                                                                            c500.add(nb);
                                                                                            f2.add(c500);
                         f2.getToolbar().addCommandToOverflowMenu("Statistiques", null, eve->{
                                             hi= new Form("            Statistique ",BoxLayout.y());
                                             hi.add("\n");
                                             Label a = new Label("              Statistique formation "+formatio.getNom());
                                             hi.add(a);
                                            

                             
          
 
          hi.add(createPieChartForm((double)(formatio.getNbres_inscrits()),(double)(formatio.getNbres_initiale()-formatio.getNbres_inscrits())));
          
          hi.getToolbar().addCommandToLeftBar("<-", null, evddd->{
                  f2.showBack();
                });
          hi.show();

                                                                                              
                                                                                              
 });
         Container c7 = new Container(new FlowLayout(Component.CENTER));
 Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
    Modifier = new Button("modifier");
                    Supprimer = new Button("Supprimer");
                             
                               
                                 Supprimer.setPreferredH(30);
   // depasseé.setPreferredW(380);
                       Button annuler = new Button("annuler");
                                                        annuler.setPreferredH(30);

                       annuler.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        f2.showBack();
                    }
                });
                     Supprimer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            FormationService h = new FormationService();
            h.SupprimerFormation(formatio.getRef());
            
            AffichageFormation f = new AffichageFormation();
            f.getF().show();
        }
    });
                            
                              Button  avoir = new Button("supprimer");
                       avoir.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
Dialog d = new Dialog("Supprimer formation");
d.setLayout(new BorderLayout());
//Container c111 = new Container(new BoxLayout(BoxLayout.X_AXIS));
  //                          c111.add(Supprimer);
    //                        c111.add(annuler);
d.add(BorderLayout.EAST,Supprimer);
d.add(BorderLayout.WEST,annuler);


d.show(f.getHeight() / 2 , 2, 2, 2);
d.setDisposeWhenPointerOutOfBounds(true);
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
                       c3.add(Modifier);
                     int  k = Formation.focusedIddd = formatio.getNbres_inscrits();
                     int  j = Formation.focusedIddc = formatio.getNbres_initiale();
if (k == j){
c3.add(avoir);}
c7.add(c3);
f2.add(c7);
            f2.show();
                        
                        
                        
        }            
                         });  
                        
                        
                        /*     @Override
        public void actionPerformed(ActionEvent evt) {
            Dialog.show("Formation",nom.getText()+"\n"+description.getText()+"\n"+duree.getText()+"\n"+datedebut.getText()+"\n"+datefin.getText()+"\n"+prix.getText()+"\n"+adresse.getText()+"\n"+email.getText()+"\n"
                    +contact.getText(),"retour",null);
        }
    });*/
           //         Container c4 = new Container(new FlowLayout(Component.CENTER));
             //       Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
              //      Modifier = new Button("modifier");
                //    Supprimer = new Button("Supprimer");
                 /*   Supprimer.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Dialog.show("suppression","etes vous sur de supprimer cette formation ?","oui","non");
        }
    }
                    );*/
            //        Supprimer.addActionListener(new ActionListener() {
     //   @Override
     //   public void actionPerformed(ActionEvent evt) {
       //     FormationService h = new FormationService();
       //     h.SupprimerFormation(formatio.getRef());
            
        //    AffichageFormation f = new AffichageFormation();
         //   f.getF().show();
       // }
   // });
     //        Modifier.addActionListener(new ActionListener() {
       //     @Override
        
         //   public void actionPerformed(ActionEvent evt) {
             //  Formation.focusedId=formatio.getRef();
           //    modifierFormation h = new modifierFormation();
            //   h.getF().show();
         //   }
           //  }
           //  );

c2.add(nom);
c2.add(domaine);
c1.add(imgv);
c1.add(c2);
c10.add(c1);
c10.add(seperator);
//c2.add(entreprise);
//c3.add(Modifier);
//c3.add(Supprimer);
//c4.add(c3);
//c2.add(c4);
//c2.setLeadComponent(nom);

//f.add("\n");
}
                    
                            
public Form getF(){
    return f;
}
public void setF(Form f){
    this.f=f;
}
  private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
      renderer.setLabelsTextSize(50);
       renderer.setLegendTextSize(50);
       renderer.setMargins(new int[]{5, 5, 5, 0});
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
        
        series.add("Restants", values[0]);
        series.add("Inscrits ", values[1]);
        return series;
    }
public Component createPieChartForm(double nbr1,double nbr2) {

        // Generate the values
        double[] values = new double[]{nbr1, nbr2};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
       renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
       // Container f11 = new Container();
     //  f11.setLayout(new BorderLayout());
      //  f11.addComponent(BorderLayout.CENTER, c);
        return c;
    }
}
