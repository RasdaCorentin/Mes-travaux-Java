/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {
   window.setTimeout(function(){
        $.get("AjaxServlet", function(data){
        $("#nomUtilisateur").text(data);
    });
},5000);
        $("#valider").click(function () {
        $.post("AjaxServlet", 
        
        {nom: $("#nom").val(),
        prenom: $("#prenom").val()},
        
        function (data, status){
            $("#ajaxReponse").text(data);               
        })
    })
});

$(document).ready(function () {
    $("#recupID").click(function () {
        $.post("SessionServlet", 
        {nom: $("#nom").val()}, function (data, status){
            $("#ajaxReponse2").text(data);
        })
    })
});

