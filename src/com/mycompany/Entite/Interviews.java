/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author User
 */
public class Interviews {
   private int ref_ent;
   private int offre_id;
   private String heure_ent;
       private String date;
              private String poste;
    public static int focusedId;
    

       private int etat;


   private String fullname;
  /* private String etat;*/

    public Interviews() {
    }
    public Interviews(int ref_ent, String heure_ent) {
        this.ref_ent = ref_ent;
        this.heure_ent = heure_ent;
       
    }
    public Interviews(int ref_ent, String date, String heure_ent) {
        this.ref_ent = ref_ent;
        this.date = date;
        this.heure_ent=heure_ent;
       
    }
        public Interviews(int ref_ent, String date, String heure_ent,int etat) {
        this.ref_ent = ref_ent;
        this.date = date;
        this.heure_ent=heure_ent;
        this.etat=etat;

    }

    public String getHeure_ent() {
        return heure_ent;
    }

    public int getRef_ent() {
        return ref_ent;
    }

    public void setHeure_ent(String heure_ent) {
        this.heure_ent = heure_ent;
    }

    public void setRef_ent(int ref_ent) {
        this.ref_ent = ref_ent;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getPoste() {
        return poste;
    }

    public int getOffre_id() {
        return offre_id;
    }

    public void setOffre_id(int offre_id) {
        this.offre_id = offre_id;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    @Override
    public String toString() {
        return "Entretien{" + "ref_ent=" + ref_ent + ", heure_ent=" + heure_ent  + ", fullname=" + fullname  + '}';
    }
    
}
