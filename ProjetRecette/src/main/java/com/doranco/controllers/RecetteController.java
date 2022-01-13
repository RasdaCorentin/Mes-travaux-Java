/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.controllers;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.RecetteDaoInterface;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.Ingredient;
import com.doranco.entities.Recette;
import com.doranco.entities.Utilisateur;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;


/**
 *
 * @author 33767
 */
@Path("/utilisateur/recette")
public class RecetteController {
    

/*
--------------------------------------------------------------------------------------------------------------------------
                                                 Liste Recette
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
                                                Création Recette
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
       
       
       recette.setListeIngredients(recette.getListeIngredients());
       Utilisateur utilisateur = utilisateurDaoInterface.findUtilisateurById(id);
       recette.setUtilisateur(utilisateur);
       recette = recetteDaoInterface.createRecette(recette);
       
         
//Creation d'une réponse
        Response response = Response
                .status(Response.Status.CREATED)
                .entity(recette)
                .build();
        
        daoFactory.closeEntityManagerFactory();
        
        return response;
    }
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Update Recette 
--------------------------------------------------------------------------------------------------------------------------
*/    
    @Path("/admin/update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecette(Recette recette, @PathParam(value = "id")int id){


       DaoFactory daoFactory = new DaoFactory();
       RecetteDaoInterface recetteDaoInterface = daoFactory.getRecetteDaoInterface();  
       recetteDaoInterface.updateRecette(recette, id);       
    
        //Creation d'une réponse
        Response response = Response
                .status(Response.Status.CREATED)
                .entity(recette)
                .build();
        
        daoFactory.closeEntityManagerFactory();
        return response;
    }
    /*
--------------------------------------------------------------------------------------------------------------------------
                                                 Delete Recette avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Path("/admin/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRecette(@PathParam(value = "id")int id){
    DaoFactory daoFactory = new DaoFactory();
       
    RecetteDaoInterface RecetteDaoInterface = daoFactory.getRecetteDaoInterface();
       
    RecetteDaoInterface.deleteRecette(id);
    daoFactory.closeEntityManagerFactory();
    
    Response response = Response
                .status(Response.Status.CREATED)
                .entity("Recette id :" + id + " Supprimé")
                .build();
      return response;  
    }
}
