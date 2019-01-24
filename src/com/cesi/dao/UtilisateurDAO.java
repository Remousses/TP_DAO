package com.cesi.dao;

import com.cesi.beans.Utilisateur;
import com.cesi.dao.DAOFactory;
import com.cesi.dao.interfaces.UtilisateurInterfaceDAO;
import com.cesi.dao.exceptions.DAOException;

import java.sql.*;

public class UtilisateurDAO implements UtilisateurInterfaceDAO {
    private DAOFactory daoFactory;

    public UtilisateurDAO() {
        this.daoFactory = new DAOFactory();
    }

    /* Implémentation de la méthode create() définie dans l'interface UtilisateurDAO */
    @Override
    public void create(Utilisateur utilisateur) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        final String query = "INSERT INTO users (Email, Nom, Prenom) VALUES (?, ?, ?)";

        try {
            /* Récupération d'une connexion depuis la Factory */
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString (1, utilisateur.getEmail());
            preparedStatement.setString (2, utilisateur.getNom());
            preparedStatement.setString (3, utilisateur.getPrenom());

            int status = preparedStatement.executeUpdate();
    
            /* Analyse du statut retourné par la requête d'insertion */
            if (status == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally{
            daoFactory.fermeturesSilencieuses(preparedStatement, connection);
        }
    }

    /* Implémentation de la méthode edit() définie dans l'interface UtilisateurDAO */
    @Override
    public void edit(Utilisateur utilisateur) throws DAOException {

    }
}