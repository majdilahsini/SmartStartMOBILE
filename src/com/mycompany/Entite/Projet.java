package com.mycompany.Entite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Projet {
     private   int idProjet;
    private String nomprojet;
    private float votreFinance;
    private long montant;
    private long compteBancaire;
    private String dateDebutProjet;
     private String dateFinProjet;
    private String adresseProjet;
    private int telProjet;
    private int nbreTeam;
    private String descriptionProjet;
    private String emailProjet;
    private String image;
    
    private String idCategorie;
   
    private int idEtat;
 
     private int id_enterprise;

    public Projet() {
    }

    public Projet(int idProjet, String nomprojet, int votreFinance, long montant, long compteBancaire, String dateDebutProjet, String dateFinProjet, String adresseProjet, int telProjet, int nbreTeam, String descriptionProjet, String emailProjet, String image, String idCategorie, int idEtat, int id_enterprise) {
        this.idProjet = idProjet;
        this.nomprojet = nomprojet;
        this.votreFinance = votreFinance;
        this.montant = montant;
        this.compteBancaire = compteBancaire;
        this.dateDebutProjet = dateDebutProjet;
        this.dateFinProjet = dateFinProjet;
        this.adresseProjet = adresseProjet;
        this.telProjet = telProjet;
        this.nbreTeam = nbreTeam;
        this.descriptionProjet = descriptionProjet;
        this.emailProjet = emailProjet;
        this.image = image;
        this.idCategorie = idCategorie;
        this.idEtat = idEtat;
        this.id_enterprise = id_enterprise;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public String getNomprojet() {
        return nomprojet;
    }

    public float getVotreFinance() {
        return votreFinance;
    }

    public long getMontant() {
        return montant;
    }

    public long getCompteBancaire() {
        return compteBancaire;
    }

    public String getDateDebutProjet() {
        return dateDebutProjet;
    }

    public String getDateFinProjet() {
        return dateFinProjet;
    }

    public String getAdresseProjet() {
        return adresseProjet;
    }

    public int getTelProjet() {
        return telProjet;
    }

    public int getNbreTeam() {
        return nbreTeam;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public String getEmailProjet() {
        return emailProjet;
    }

    public String getImage() {
        return image;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public int getIdEtat() {
        return idEtat;
    }

    public int getId_enterprise() {
        return id_enterprise;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setNomprojet(String nomprojet) {
        this.nomprojet = nomprojet;
    }

    public void setVotreFinance(float votreFinance) {
        this.votreFinance = votreFinance;
    }

    public void setMontant(long montant) {
        this.montant = montant;
    }

    public void setCompteBancaire(long compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public void setDateDebutProjet(String dateDebutProjet) {
        this.dateDebutProjet = dateDebutProjet;
    }

    public void setDateFinProjet(String dateFinProjet) {
        this.dateFinProjet = dateFinProjet;
    }

    public void setAdresseProjet(String adresseProjet) {
        this.adresseProjet = adresseProjet;
    }

    public void setTelProjet(int telProjet) {
        this.telProjet = telProjet;
    }

    public void setNbreTeam(int nbreTeam) {
        this.nbreTeam = nbreTeam;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public void setEmailProjet(String emailProjet) {
        this.emailProjet = emailProjet;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setIdEtat(int idEtat) {
        this.idEtat = idEtat;
    }

    public void setId_enterprise(int id_enterprise) {
        this.id_enterprise = id_enterprise;
    }

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
        final Projet other = (Projet) obj;
        if (this.idProjet != other.idProjet) {
            return false;
        }
        if (this.votreFinance != other.votreFinance) {
            return false;
        }
        if (this.montant != other.montant) {
            return false;
        }
        if (this.compteBancaire != other.compteBancaire) {
            return false;
        }
        if (this.telProjet != other.telProjet) {
            return false;
        }
        if (this.nbreTeam != other.nbreTeam) {
            return false;
        }
        if (this.idEtat != other.idEtat) {
            return false;
        }
        if (this.id_enterprise != other.id_enterprise) {
            return false;
        }
        if (!Objects.equals(this.nomprojet, other.nomprojet)) {
            return false;
        }
        if (!Objects.equals(this.dateDebutProjet, other.dateDebutProjet)) {
            return false;
        }
        if (!Objects.equals(this.dateFinProjet, other.dateFinProjet)) {
            return false;
        }
        if (!Objects.equals(this.adresseProjet, other.adresseProjet)) {
            return false;
        }
        if (!Objects.equals(this.descriptionProjet, other.descriptionProjet)) {
            return false;
        }
        if (!Objects.equals(this.emailProjet, other.emailProjet)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.idCategorie, other.idCategorie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Projet{" + "idProjet=" + idProjet + ", nomprojet=" + nomprojet + ", votreFinance=" + votreFinance + ", montant=" + montant + ", compteBancaire=" + compteBancaire + ", dateDebutProjet=" + dateDebutProjet + ", dateFinProjet=" + dateFinProjet + ", adresseProjet=" + adresseProjet + ", telProjet=" + telProjet + ", nbreTeam=" + nbreTeam + ", descriptionProjet=" + descriptionProjet + ", emailProjet=" + emailProjet + ", image=" + image + ", idCategorie=" + idCategorie + ", idEtat=" + idEtat + ", id_enterprise=" + id_enterprise + '}';
    }

   
    
}
