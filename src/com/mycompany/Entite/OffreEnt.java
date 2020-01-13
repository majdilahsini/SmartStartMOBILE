/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author User
 */
public class OffreEnt {
    private int offre_id;
    private String poste;
     private String nomCondidat;
          private String nomEntreprise;
    private String lettreMotivation;
        public static int focusedId;
        public static String focusedPoste;
                public static String focusedNomEntre;

    

    
    public OffreEnt() {
    }
    public OffreEnt(int offre_id, String poste, String nomCondidat, String lettreMotivation) {
        this.offre_id = offre_id;
        this.poste = poste;
        this.nomCondidat = nomCondidat;
        this.lettreMotivation = lettreMotivation;
       
    }
     public OffreEnt(int offre_id, String poste, String nomCondidat,String nomEntreprise, String lettreMotivation) {
        this.offre_id = offre_id;
        this.poste = poste;
        this.nomCondidat = nomCondidat;
        this.nomEntreprise = nomEntreprise;
        this.lettreMotivation = lettreMotivation;
       
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setOffre_id(int offre_id) {
        this.offre_id = offre_id;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setNomCondidat(String nomCondidat) {
        this.nomCondidat = nomCondidat;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }

    public String getPoste() {
        return poste;
    }

    public int getOffre_id() {
        return offre_id;
    }

    public String getNomCondidat() {
        return nomCondidat;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }


}
