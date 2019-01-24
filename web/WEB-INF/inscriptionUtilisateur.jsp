<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription utilisateur</title>
    <link type="text/css" rel="stylesheet" href="resources/form.css" />
</head>
<body>
<form method="post" action="inscriptionUtilisateur">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire mode MVC.</p>

        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['email']}</span>
        <br />

        <label for="nom">Nom d'utilisateur</label>
        <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['nom']}</span>
        <br />

        <label for="prenom">Prénom d'utilisateur</label>
        <input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['prenom']}</span>
        <br />

        <input type="submit" value="Inscription" class="sansLabel" />
        <br />

        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
    </fieldset>
</form>
</body>
</html>