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
public class DomaineFormation {
    
    int id ;
    int entreprise_id;
    String nom_domaine;

    public DomaineFormation() {
    }

    public DomaineFormation(int id, int entreprise_id, String nom_domaine) {
        this.id = id;
        this.entreprise_id = entreprise_id;
        this.nom_domaine = nom_domaine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntreprise_id() {
        return entreprise_id;
    }

    public void setEntreprise_id(int entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public String getNom_domaine() {
        return nom_domaine;
    }

    public void setNom_domaine(String nom_domaine) {
        this.nom_domaine = nom_domaine;
    }

    @Override
    public String toString() {
        return "DomaineFormation{" + "id=" + id + ", entreprise_id=" + entreprise_id + ", nom_domaine=" + nom_domaine + '}';
    }
    
}
