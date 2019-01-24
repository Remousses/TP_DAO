package com.cesi.dao.interfaces;

import com.cesi.beans.Utilisateur;
import com.cesi.dao.exceptions.DAOException;

public interface UtilisateurDAO {

    void create( Utilisateur utilisateur ) throws DAOException;

    void edit( Utilisateur utilisateur ) throws DAOException;
}