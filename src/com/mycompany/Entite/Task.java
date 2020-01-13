/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author bhk
 */
public class Task {
   private int id;
   private String nom;
   private String etat;

    public Task() {
    }

    public Task(int id, String nom, String etat) {
        this.id = id;
        this.nom = nom;
        this.etat = etat;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", nom=" + nom + ", etat=" + etat + '}';
    }
           
}
