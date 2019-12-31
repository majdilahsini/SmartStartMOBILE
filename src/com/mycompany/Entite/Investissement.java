/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Investissement {
    private int idInvestissement ;
     private long montant ;
      private long  numcartebancaire;
       private String  dateInvesstissement;
        private int  idInvesstisseur;
         private String  idProjet;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Investissement other = (Investissement) obj;
        if (this.idInvestissement != other.idInvestissement) {
            return false;
        }
        if (this.montant != other.montant) {
            return false;
        }
        if (this.numcartebancaire != other.numcartebancaire) {
            return false;
        }
        if (this.idInvesstisseur != other.idInvesstisseur) {
            return false;
        }
        if (this.idProjet != other.idProjet) {
            return false;
        }
        if (!Objects.equals(this.dateInvesstissement, other.dateInvesstissement)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Investissement{" + "idInvestissement=" + idInvestissement + ", montant=" + montant + ", numcartebancaire=" + numcartebancaire + ", dateInvesstissement=" + dateInvesstissement + ", idInvesstisseur=" + idInvesstisseur + ", idProjet=" + idProjet + '}';
    }

    public Investissement(int idInvestissement, long montant, long numcartebancaire, String dateInvesstissement, int idInvesstisseur, String idProjet) {
        this.idInvestissement = idInvestissement;
        this.montant = montant;
        this.numcartebancaire = numcartebancaire;
        this.dateInvesstissement = dateInvesstissement;
        this.idInvesstisseur = idInvesstisseur;
        this.idProjet = idProjet;
    }

    public Investissement() {
    }

    public void setIdInvestissement(int idInvestissement) {
        this.idInvestissement = idInvestissement;
    }

    public void setMontant(long montant) {
        this.montant = montant;
    }

    public void setNumcartebancaire(long numcartebancaire) {
        this.numcartebancaire = numcartebancaire;
    }

    public void setDateInvesstissement(String dateInvesstissement) {
        this.dateInvesstissement = dateInvesstissement;
    }

    public void setIdInvesstisseur(int idInvesstisseur) {
        this.idInvesstisseur = idInvesstisseur;
    }

   
    public int getIdInvestissement() {
        return idInvestissement;
    }

    public long getMontant() {
        return montant;
    }

    public long getNumcartebancaire() {
        return numcartebancaire;
    }

    public String getDateInvesstissement() {
        return dateInvesstissement;
    }

    public int getIdInvesstisseur() {
        return idInvesstisseur;
    }

    public String getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(String idProjet) {
        this.idProjet = idProjet;
    }

    
    
}
