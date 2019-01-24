package com.cesi.dao;

import com.cesi.dao.exceptions.DAOConfigurationException;
import com.cesi.dao.implementations.UtilisateurDAOImpl;
import com.cesi.dao.interfaces.UtilisateurDAO;

import java.sql.*;

public class DAOFactory {
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/utilisateur";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public DAOFactory() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new DAOConfigurationException("Le driver est introuvable dans le classpath.", e);
        }
    }

    /* Méthode chargée de fournir une connexion à la base de données */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    /* Fermeture silencieuse du resultset */
    public void fermetureSilencieuse(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Échec de la fermeture du ResultSet : " + e.getMessage());
            }
        }
    }

    /* Fermeture silencieuse du statement */
    public void fermetureSilencieuse(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Échec de la fermeture du Statement : " + e.getMessage());
            }
        }
    }

    /* Fermeture silencieuse de la connexion */
    public void fermetureSilencieuse(Connection connexion) {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                System.out.println("Échec de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }

    /* Fermetures silencieuses du statement et de la connexion */
    public void fermeturesSilencieuses(Statement statement, Connection connexion) {
        fermetureSilencieuse(statement);
        fermetureSilencieuse(connexion);
    }

    /* Fermetures silencieuses du resultset, du statement et de la connexion */
    public void fermeturesSilencieuses(ResultSet resultSet, Statement statement, Connection connexion) {
        fermetureSilencieuse(resultSet);
        fermetureSilencieuse(statement);
        fermetureSilencieuse(connexion);
    }

    /*
     * Méthodes de récupération de l'implémentation des différents DAO (un seul
     * pour le moment)
     */
    public UtilisateurDAO getUtilisateurDao() {
        return new UtilisateurDAOImpl(this);
    }
}