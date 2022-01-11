/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.controllers;
import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.RoleUtilisateur;
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



/**
 *
 * @author 33767
 */

@Path("/utilisateur") 
public class UtilisateurController {
    
    
//---------------------------------------------ADMIN COMMAND-------------------------------------------------
/*
--------------------------------------------------------------------------------------------------------------------------
                                                 Liste Utilisateur avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Path("/admin/liste")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListeUtilisateur(){

        DaoFactory daoFactory = new DaoFactory();
        
        UtilisateurDaoInterface utilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();

        //Creation d'une réponse
        Response response = Response
                .status(Response.Status.CREATED)
                .entity(utilisateurDaoInterface.getListeUtilisateurs())
                .build();
        
        daoFactory.closeEntityManagerFactory();
        
        return response;
 }
    
    
/*
--------------------------------------------------------------------------------------------------------------------------
                                                 Delete Utilisateur avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Path("/admin/deleteU/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUtilisateur(@PathParam(value = "id")int id){
    DaoFactory daoFactory = new DaoFactory();
       
    UtilisateurDaoInterface UtilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();
       
    UtilisateurDaoInterface.deleteUtilisateur(id);
    daoFactory.closeEntityManagerFactory();
    
    Response response = Response
                .status(Response.Status.CREATED)
                .entity("Utilisateur id :" + id + " Supprimé")
                .build();
      return response;  
    }
    
    
//---------------------------------------------ADMIN / NEW USER COMMAND-------------------------------------------------
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Création Utilisateur avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Path("/enregistrez")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response createUtilisateur(Utilisateur utilisateur){
       DaoFactory daoFactory = new DaoFactory();
//Je récupère ces infos depuis postman et le sutilise pour créer un nouvel utilisateur

       Utilisateur Nutilisateur = new Utilisateur(utilisateur.getNom(), utilisateur.getPassword(), RoleUtilisateur.USER, utilisateur.getEmail()); 
       UtilisateurDaoInterface utilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();
       Nutilisateur = utilisateurDaoInterface.createUtilisateur(Nutilisateur);
       
         
        //Creation daoFactory.closeEntityManagerFactory();d'une réponse
        Response response = Response
                .status(Response.Status.CREATED)
                .entity(utilisateurDaoInterface.getListeUtilisateurs())
                .build();
        
        daoFactory.closeEntityManagerFactory();
        
        return response;
    }
    
    
//---------------------------------------------ADMIN / USER COMMAND-------------------------------------------------
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Update Utilisateur avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/    
    @Path("/user/update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUtilisateur(Utilisateur utilisateur, @PathParam(value = "id")int id){


       DaoFactory daoFactory = new DaoFactory();
       
       utilisateur = new Utilisateur(utilisateur.getNom(), utilisateur.getPassword(), RoleUtilisateur.USER, utilisateur.getEmail());
       UtilisateurDaoInterface utilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();  
       utilisateurDaoInterface.updateUtilisateur(utilisateur, id);       
    
        //Creation d'une réponse
        Response response = Response
                .status(Response.Status.CREATED)
                .entity(utilisateurDaoInterface.getListeUtilisateurs())
                .build();
        
        daoFactory.closeEntityManagerFactory();
        return response;
    }
}

