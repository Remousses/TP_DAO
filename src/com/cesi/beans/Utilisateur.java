package com.cesi.beans;

public class Utilisateur {
    private String email;
    private String nom;
    private String prenom;

    /**
     * Contructeur par defaut
     */
    public Utilisateur(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
