<%@ page contentType="text/html;charset=UTF-8" %>
<!-- <%@ page import="java.util.List" %> -->
<!-- <%@ page import="com.fourage.model.Cheque" %> -->

<!DOCTYPE html>
<html>
<head>
    <title>Forage - Formulaire de demande</title>
</head>
<body>
    <h1>Faite votre demande de forage</h1>

    <form action="/demandes/ajouter" method="post">
        <fieldset>
            <legend>Information personnelle</legend>

            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" placeholder="Entrez votre nom">
    
            <label for="prenom">Prenom:</label>
            <input type="text" id="prenom" name="prenom" placeholder="Entrez votre prénom">

        </fieldset>

        <fieldset>
            <legend>Information sur le lieu de fourage</legend>

            <label for="commune">Commune:</label>
            <select name="commune" id="commune">
                <option value="">- Sélectionnez une commune -</option>
            </select>

            <label for="lieu">Lieu:</label>
            <input type="text" id="lieu" name="lieu" placeholder="Entrez le lieu de fourage">
            
        </fieldset>

        <input type="submit" value="Envoyer la demande">
    </form>

</body>
</html>