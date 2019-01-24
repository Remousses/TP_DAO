package com.cesi.dao.implementations;

import com.cesi.beans.Utilisateur;
import com.cesi.dao.DAOFactory;
import com.cesi.dao.interfaces.UtilisateurDAO;
import com.cesi.dao.exceptions.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilisateurDAOImpl implements UtilisateurDAO {
    private DAOFactory daoFactory;

    public UtilisateurDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /* Implémentation de la méthode create() définie dans l'interface UtilisateurDAO */
    @Override
    public void create(Utilisateur utilisateur) throws DAOException {
        Connection connection = null;
        Statement statement = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            int state = statement.executeUpdate("INSERT INTO users (Email, Nom, Prenom) VALUES (utilisateur.getEmail(), utilisateur.getNom(), utilisateur.getPrenom());");
            /* Analyse du statut retourné par la requête d'insertion */
            if (state == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally{
            daoFactory.fermeturesSilencieuses(statement, connection);
        }
    }

    /* Implémentation de la méthode edit() définie dans l'interface UtilisateurDAO */
    @Override
    public void edit(Utilisateur utilisateur) throws DAOException {

    }
}