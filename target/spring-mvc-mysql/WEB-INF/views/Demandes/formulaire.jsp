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

    <form action="/demandes/insert" method="post">
        <p>Information presonnelle</p>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom">

        <label for="prenom">Prenom:</label>
        <input type="prenom" id="prenom" name="prenom">

        <br>

        <p>Information sur le lieu de fourage</p>
        <label for="region">Region:</label>
        <input type="text" id="region" name="region">

        <label for="district">District:</label>
        <input type="text" id="district" name="district">

        <label for="commune">Commune:</label>
        <input type="text" id="commune" name="commune">

        <label for="fokotany">Fokotany:</label>
        <input type="text" id="fokotany" name="fokotany">

        <input type="submit" value="Envoyer la demande">
    </form>

</body>
</html>