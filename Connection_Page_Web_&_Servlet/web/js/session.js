/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {
    $("#valider").click(function () {
        $.post("SessionServlet", 
        {nom: $("#nom").val()}, function (data, status){
            $("#ajaxReponse").text(data);
        });
        });
    });
 

