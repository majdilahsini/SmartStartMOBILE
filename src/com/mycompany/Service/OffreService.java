/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Offre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sadbo
 */
public class OffreService {
    
    public ArrayList<Offre> parseListTaskJson(String json) {

        ArrayList<Offre> listOffres = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> offres = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) offres.get("root");
            
            for (Map<String, Object> obj : list) {
                           
                
                Offre o = new Offre();
                Map<String, Object> domaine = (Map<String, Object>) obj.get("domaine");
                Map<String, Object> timestamp = (Map<String, Object>) obj.get("datePublication");
                
                double timestpam_date = (double) timestamp.get("timestamp");
                Date dt = new Date((long) (timestpam_date * 1000));
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                
                o.setId((int) Float.parseFloat(obj.get("id").toString()));
                o.setTitre(obj.get("titre").toString());
                o.setDomaine(domaine.get("nom").toString());
                o.setDate_publication(df.format(dt));
                
                //o.setDate_publication(obj.get("date_publication").toString());
                /*o.setDomaine_id((int) Float.parseFloat(obj.get("domaine_id").toString()));
                o.setDomaine_id((int) Float.parseFloat(obj.get("entreprise_id").toString()));
                o.setDomaine_id((int) Float.parseFloat(obj.get("niveau_etude").toString()));
                o.setDomaine_id((int) Float.parseFloat(obj.get("langue_ref").toString()));
                o.setDomaine_id((int) Float.parseFloat(obj.get("domaine_id").toString()));*/

                listOffres.add(o);
            }

        } catch (IOException ex) {
        }
        return listOffres;
    }
    
    ArrayList<Offre> listOffres = new ArrayList<>();
    
    public ArrayList<Offre> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/offre/api/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OffreService os = new OffreService();
                listOffres = os.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffres;
    }
}
