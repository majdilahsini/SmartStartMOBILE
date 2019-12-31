/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 *
 * @author lenovo
 */
public class Formation {
    private int ref ;
      private int entreprise_id;
    private int domaine_id ;
     public static int focusedId ;
          public static String focusedIdd ;
          public static int focusedIddd ;
                    public static int focusedIduser ;


    private String Nom ; 
  
    private String description ;
    private int duree ; 
    private String date_debut ;
    private String date_fin;
    private String adresse ;
    private double prix ;
    private int Contact ;
    private String email ;
    private String image ;
  private int Nbres_inscrits ;
        private String nomentreprise ;
       private String nomdomaine ;

    public Formation() {
    }

    public Formation(int ref, String Nom, String description, int duree, String date_debut, String date_fin, String adresse, double prix, int Contact, String email) {
        this.ref = ref;
        this.Nom = Nom;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
    }

    public Formation(int ref, String Nom, String description, String adresse) {
        this.ref = ref;
        this.Nom = Nom;
        this.description = description;
        this.adresse = adresse;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getEntreprise_id() {
        return entreprise_id;
    }

    public void setEntreprise_id(int entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public int getDomaine_id() {
        return domaine_id;
    }

    public void setDomaine_id(int domaine_id) {
        this.domaine_id = domaine_id;
    }

    public static int getFocusedId() {
        return focusedId;
    }

    public static void setFocusedId(int focusedId) {
        Formation.focusedId = focusedId;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNbres_inscrits() {
        return Nbres_inscrits;
    }

    public void setNbres_inscrits(int Nbres_inscrits) {
        this.Nbres_inscrits = Nbres_inscrits;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public String getNomdomaine() {
        return nomdomaine;
    }

    public void setNomdomaine(String nomdomaine) {
        this.nomdomaine = nomdomaine;
    }

    

    
    
    

       @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
   }
    

    

}
