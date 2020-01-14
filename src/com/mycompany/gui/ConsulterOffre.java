/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.progress.ArcProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Offre;
import com.mycompany.Service.OffreService;

/**
 *
 * @author Sadbo
 */
public class ConsulterOffre extends Form {
    
        public ConsulterOffre (Offre offre, Resources res) {
            
        this.getToolbar().setTitleComponent(FlowLayout.encloseCenterMiddle(
                                                new Label(""+ offre.getTitre(), "Title")));
        
        this.getToolbar().addCommandToRightBar("Back", null, (ActionListener) (ActionEvent evt) -> {
                new AffichageOffre().show();
        });
        
        this.setLayout(BoxLayout.y());
        
        Container main = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container att = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container off = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        Label titre = new Label(": "+ offre.getTitre());
        Label domaine = new Label(": "+ offre.getDomaine());
        Label date_pub = new Label(": "+ offre.getDate_publication());
        Label salaire = new Label(": "+ offre.getSalaire()+"TND");
        Label niveau = new Label(": Bac +"+ offre.getNiveau_etude());
        Label skill1 = new Label(": "+ offre.getSkill1());
        Label skill2 = new Label(": "+ offre.getSkill2());
        Label skill3 = new Label(": "+ offre.getSkill3());
        Label langue = new Label(": "+ offre.getLangue());
        Label poste = new Label(": "+ offre.getType_post());
        
        off.add(titre);
        off.add(domaine);
        off.add(date_pub);
        off.add(salaire);
        off.add(skill1);
        off.add(skill2);
        off.add(skill3);
        off.add(langue);
        off.add(poste);
        
        att.add(new Label("Titre "));
        att.add(new Label("Domaine "));
        att.add(new Label("Date de publication "));
        att.add(new Label("Salaire "));
        att.add(new Label("Compétence 1 "));
        att.add(new Label("Compétence 2  "));
        att.add(new Label("Compétence 3  "));
        att.add(new Label("Langue "));
        att.add(new Label("Type de Poste "));
        
        Container seperator = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
        seperator.getAllStyles().setBorder(Border.createEmpty());
        seperator.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        seperator.getAllStyles().setBgColor(0x000000);
        seperator.getAllStyles().setBgTransparency(40);
        seperator.setPreferredSize(new Dimension(0,5));
        seperator.getAllStyles().setMargin(20, 50 , 0, 0);
        
        main.add(att);
        main.add(off);
        
        OffreService os  = new OffreService();
        Label score_text = new Label("Score", "HugeDarkLabel");
        Label score = new Label(""+os.getscore(offre.getId(), 14), "HugeDarkLabel");
        score.getAllStyles().setFgColor(0xE87A67);
        Label per = new Label("%", "HugeDarkLabel");
        
        Label darkRect = new Label(res.getImage("dark-rect.png"), "StatsLabel");
        Label active = new Label("ACTIVE", "StatsLabel");
        ArcProgress ap = new ArcProgress();
        ap.setProgress(Integer.parseInt(os.getscore(offre.getId(), 14)));
        ap.setRenderPercentageOnTop(false);
        
        Container box = BoxLayout.encloseY(
                        score_text,
                        FlowLayout.encloseCenter(score, per),
                        FlowLayout.encloseCenter(darkRect),
                        active
                    );
        
        box.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_DIPS);
        box.getUnselectedStyle().setPadding(4, 4, 4, 4);
        
        Container scroll = BoxLayout.encloseY(LayeredLayout.encloseIn(
                    ap,
                    box
                ));
        
        this.add(main);
        this.add(seperator);
        this.add(scroll);
        
        this.add(new Button("Postuler!"));
        
        Toolbar toolbar = new Toolbar();
        toolbar.ToolBarInstall(this, null);
    }
}
