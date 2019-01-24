package com.cesi.servlets;

import com.cesi.beans.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UtilisateurServlet", urlPatterns = "/utilisateur")
public class UtilisateurServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("WEB-INF/utilisateur").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Utilisateur utilisateur = new Utilisateur();
    }
}
