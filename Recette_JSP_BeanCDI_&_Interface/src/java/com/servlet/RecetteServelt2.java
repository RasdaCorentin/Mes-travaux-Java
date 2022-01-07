/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.beanCdi.RecetteSucre;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 33767
 */
public class RecetteServelt2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Inject 
    private RecetteSucre Recette;
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nom = request.getParameter("nom");
            String nomR = request.getParameter("nomR");
            String descR = request.getParameter("descR");
            
            Recette.setNom(nom);
            Recette.setNomR(nomR);
            Recette.setDescR(descR);
            
            request.setAttribute("nom", nom);
            request.setAttribute("nomR", nomR);
            request.setAttribute("descR", descR);
            request.setAttribute("typeRecette", Recette.typeRecette());
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("larecette.jsp");
            requestDispatcher.forward(request, response);
//            response.getWriter().println(Recette.recetteToString());
    }
}