/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author p
 */
public class Offre {
    
    private int id;
    private String titre;
    private String domaine;
    private String entreprise;
    private int niveau_etude;
    private String langue;
    private String type_post;
    private String skill1;
    private String skill2;
    private String skill3;
    private int salaire;
    private String date_publication;
    private String photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public int getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(int niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getType_post() {
        return type_post;
    }

    public void setType_post(String type_post) {
        this.type_post = type_post;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(String date_publication) {
        this.date_publication = date_publication;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Offre(int id, String titre, String domaine, String entreprise, int niveau_etude, String langue, String type_post, String skill1, String skill2, String skill3, int salaire, String date_publication, String photo) {
        this.id = id;
        this.titre = titre;
        this.domaine = domaine;
        this.entreprise = entreprise;
        this.niveau_etude = niveau_etude;
        this.langue = langue;
        this.type_post = type_post;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.salaire = salaire;
        this.date_publication = date_publication;
        this.photo = photo;
    }

    public Offre(String titre, String domaine, String entreprise, int niveau_etude, String langue, String type_post, String skill1, String skill2, String skill3, int salaire, String date_publication, String photo) {
        this.titre = titre;
        this.domaine = domaine;
        this.entreprise = entreprise;
        this.niveau_etude = niveau_etude;
        this.langue = langue;
        this.type_post = type_post;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.salaire = salaire;
        this.date_publication = date_publication;
        this.photo = photo;
    }
    
    public Offre() {
    }
    
       
    
    
    
      
    
    
}
