<%-- 
    Document   : newjsp
    Created on : 30 nov. 2021, 16:09:36
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
        <h1>Hello World!</h1>
        <%= new java.util.Date() %>
                <form action="test" method="post">
            <input type="number" id="nombre1" name="nombre1">
            <input type="number" id="nombre2" name="nombre2">
            <input type="submit" value="Envoyer le formulaire">
        </form>
    </body>
</html>
