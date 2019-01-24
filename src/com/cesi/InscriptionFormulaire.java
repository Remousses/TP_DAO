package com.cesi;

import com.cesi.beans.Utilisateur;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class InscriptionFormulaire {
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_PRENOM= "prenom";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<>();

    public Utilisateur inscrireUtilisateur(HttpServletRequest request) {
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String nom = getValeurChamp(request, CHAMP_NOM);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);

        Utilisateur utilisateur = new Utilisateur();

        try {
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
        utilisateur.setEmail(email);

        try {
            validationNom(nom);
        } catch (Exception e) {
            setErreur(CHAMP_NOM, e.getMessage());
        }
        utilisateur.setNom(nom);

        try {
            validationPrenom(prenom);
        } catch (Exception e) {
            setErreur(CHAMP_PRENOM, e.getMessage());
        }
        utilisateur.setPrenom(prenom);

        if (erreurs.isEmpty()) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Echec de l'inscription.";
        }

        return utilisateur;
    }

    private void validationEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    private void validationNom(String nom) throws Exception {
        if (nom != null && nom.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    private void validationPrenom(String prenom) throws Exception {
        if (prenom != null && prenom.length() < 3) {
            throw new Exception("Le prénom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
