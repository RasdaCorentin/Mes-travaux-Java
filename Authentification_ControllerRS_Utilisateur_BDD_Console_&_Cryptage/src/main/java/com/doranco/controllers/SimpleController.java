/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.controllers;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.RoleUtilisateur;
import com.doranco.entities.Utilisateur;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Admin
 */
@Path("/simple")
public class SimpleController {
    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(){
        Response response = Response.status(Response.Status.OK).entity("bonjour").build();
        
//        System.out.println("Execution de la function hello. Deuxieme");
      
        return response;
    }
    @Path("/admin/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloAdmin(){
        Response response = Response.status(Response.Status.OK).entity("bonjour Admin").build();
        
      
        return response;
    }
    @Path("/create-user")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUserBD() {
        
        DaoFactory daoFactory = new DaoFactory();
        UtilisateurDaoInterface utilisateurInterface = daoFactory.getUtilisateurDaoInterface();
        Utilisateur user1 = new Utilisateur("william", "123", RoleUtilisateur.ADMIN);
        Utilisateur user2 = new Utilisateur("wills", "123", RoleUtilisateur.USER);
        
        utilisateurInterface.createUtilisateur(user1);
        utilisateurInterface.createUtilisateur(user2);
        
        Response response = Response.status(Response.Status.OK).entity("bonjour").build();
        return response;
    }


}
