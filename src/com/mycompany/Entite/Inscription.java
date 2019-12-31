/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author lenovo
 */
public class Inscription {
      private int id  ;
    private int user_id ;
    private int formation_ref ;
    private String lettre_motivation ;
    private String specialite;
    private String ecole;

    public Inscription() {
    }

    public Inscription(int id, int user_id, int formation_ref, String lettre_motivation, String specialite, String ecole) {
        this.id = id;
        this.user_id = user_id;
        this.formation_ref = formation_ref;
        this.lettre_motivation = lettre_motivation;
        this.specialite = specialite;
        this.ecole = ecole;
    }

    public Inscription(int user_id, int formation_ref, String lettre_motivation, String specialite, String ecole) {
        this.user_id = user_id;
        this.formation_ref = formation_ref;
        this.lettre_motivation = lettre_motivation;
        this.specialite = specialite;
        this.ecole = ecole;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFormation_ref() {
        return formation_ref;
    }

    public void setFormation_ref(int formation_ref) {
        this.formation_ref = formation_ref;
    }

    public String getLettre_motivation() {
        return lettre_motivation;
    }

    public void setLettre_motivation(String lettre_motivation) {
        this.lettre_motivation = lettre_motivation;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }
    
}
