<%-- 
    Document   : bienvenue
    Created on : 1 déc. 2021, 11:32:50
    Author     : 33767
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue</title>
    </head>
    <body>
        <h1>Bienvenue ${nom} voici vos informations:</h1>
        Nom: ${nom} <br>
        Prenom: ${prenom} <br>
        Age: ${age} <br>
        Le resultat de votre calcul est ${result}
        <br>
        Pays: ${pays}
    </body>
</html>
