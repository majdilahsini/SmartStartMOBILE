/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author p
 */
public class Application {
    
    private int id;
    private int offre_id;
    private int user_id;
    private double match;
    private int etat;
    

    public double getMatch() {
        return match;
    }

    public void setMatch(double match) {
        this.match = match;
    }
    
    
    

    public Application() {
      
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getOffre_id() {
        return offre_id;
    }

    public void setOffre_id(int offre_id) {
        this.offre_id = offre_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Application(int user_id, int offre_id, double match, int etat) {
        this.user_id = user_id;
        this.offre_id = offre_id;
        this.match = match;
        this.etat = etat;
    }

    
   
}
