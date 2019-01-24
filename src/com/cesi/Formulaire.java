package com.cesi;

import java.util.HashMap;
import java.util.Map;

public class Formulaire {
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_CODE_POSTAL = "codePostal";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<>();
}
