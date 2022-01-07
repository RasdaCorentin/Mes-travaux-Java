<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>La Recette</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <br><hr><br>

        <div class="container bg-success text-light mt-3 mb-3">

            <h1 class="mb-3 mt-3">Bienvenue ${nom}</h1>

            <h2>Type de recette : ${typeRecette}</h2>

            <h4>Voici les informations que vous avez saisi :</h4> 
            <ol>
                <li>Votre recette : ${nomR}</li>
                <br>
                <li>Sa description : ${descR}</li>
            </ol>
            <br>
            Cela sera enregistré prochainement
            <br>
            <a href="/ExamenRecette/index.html">Entrer une autre recette?</a>
        </div>
        <br><hr><br>
    </body>
</html>
