package com.cesi.servlets;

import com.cesi.InscriptionFormulaire;
import com.cesi.beans.Utilisateur;
import com.cesi.dao.UtilisateurDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InscriptionUtilisateurServlet", urlPatterns = "/inscriptionUtilisateur")
public class InscriptionUtilisateurServlet extends HttpServlet {
    private static final String ATT_UTILISATEUR = "utilisateur";
    private static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/inscriptionUtilisateur.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        InscriptionFormulaire form = new InscriptionFormulaire();

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Utilisateur utilisateur = form.inscrireUtilisateur(request);

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        utilisateurDAO.create(utilisateur);

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_UTILISATEUR, utilisateur);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
