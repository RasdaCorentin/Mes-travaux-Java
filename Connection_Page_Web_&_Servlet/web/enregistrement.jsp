<%-- 
    Document   : enregistrement
    Created on : 1 déc. 2021, 10:37:38
    Author     : 33767
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="EnregistrementServlet" method="post">
            Nom :--<input type="text" name="nom">
            <br>
            Prenom:-- <input type="text" name="prenom">
            <br>
            Age:-- <input type="text" name="age">
            <br>
            Nombre 1:-- <input type="text" name="nombre1">
            <br>
            Nombre 2:-- <input type="text" name="nombre2">
            <br>
            Pays : <select name = "pays">  
                        <option value = "France">France</option> 
                        <option value = "Italie">Italie</option> 
                   </select> 
            <br>
            <input type="submit" value="Envoyer le formulaire">
        </form>
    </body>
</html>
