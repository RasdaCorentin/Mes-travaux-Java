/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.controllers;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.RecetteDaoInterface;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.Recette;
import com.doranco.entities.Utilisateur;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


/**
 *
 * @author 33767
 */
@Path("/utilisateur/recette")
public class RecetteController {
    

/*
--------------------------------------------------------------------------------------------------------------------------
                                                 Liste Recette avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Path("/admin/liste")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListeRecette(){

        DaoFactory daoFactory = new DaoFactory();
        
        RecetteDaoInterface recetteDaoInterface = daoFactory.getRecetteDaoInterface();

        //Creation d'une réponse
        Response response = Response
                .status(Response.Status.CREATED)
                .entity(recetteDaoInterface.getListeRecettes())
                .build();
        
        daoFactory.closeEntityManagerFactory();
        
        return response;
 }
    
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Création Recette avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Path("/admin/create/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response createRecette(Recette recette, @PathParam(value = "id")int id){
        
        
       DaoFactory daoFactory = new DaoFactory();
       RecetteDaoInterface recetteDaoInterface = daoFactory.getRecetteDaoInterface();
       UtilisateurDaoInterface utilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();
        
       Utilisateur utilisateur = utilisateurDaoInterface.findUtilisateurById(id);
       Recette nRecette = new Recette(recette.getLibelle(), recette.getDescription()); 
       recette.setUtilisateur(utilisateur);
       
       nRecette = recetteDaoInterface.createRecette(nRecette);  
//Creation d'une réponse
        Response response = Response
                .status(Response.Status.CREATED)
                .entity(utilisateur)
                .build();
        
        daoFactory.closeEntityManagerFactory();
        
        return response;
    }
}
