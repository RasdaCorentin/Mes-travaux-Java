/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.controllers;
import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.dao.imp.UtilisateurDaoImp;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author 33767
 */

@Path("/utilisateur") 
public class UtilisateurController {

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
    
    @Path("admin/deleteU/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUtilisateur(@PathParam(value = "id")int id){
    DaoFactory daoFactory = new DaoFactory();
       
    UtilisateurDaoInterface ingredientDaoInterface = daoFactory.getUtilisateurDaoInterface();
       
    ingredientDaoInterface.deleteUtilisateur(id);
    daoFactory.closeEntityManagerFactory();
    
    Response response = Response
                .status(Response.Status.CREATED)
                .entity("Utilisateur id :" + id + " Supprimé")
                .build();
      return response;  
    }

//    Crée un nouvel utilisateur si aucun enregistré
    
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
//    
//    @Path("/update/{id}")
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateUtilisateur(Utilisateur newUtilisateur, @PathParam(value = "id")int id){
//
//        
//        //Filtrer la liste utilisateur pour obtenir utilisateur avec id passé en parametre
//        
//        List<Utilisateur> listeFiltree = utilisateurs.stream().filter(e -> e.getId()== id).collect(Collectors.toList());
//        
//        if(listeFiltree.isEmpty()){
//
//            return Response
//                    .status(Response.Status.NOT_FOUND)
//                    .entity("ID utilisateur non trouve")
//                    .build();
//
//        }
////        
//        Utilisateur utilisateurTrouve = listeFiltree.get(0);
//
//        //Trouver l'emplacement de l'utilisateur dans la liste
//        int indexOfUtilisateur = utilisateurs.indexOf(utilisateurTrouve);
//
//        utilisateurTrouve.setNom(newUtilisateur.getNom());
//        utilisateurTrouve.setPrenom(newUtilisateur.getPrenom());
//
//        utilisateurs.set(indexOfUtilisateur, utilisateurTrouve);
//        
//        //Creation d'une réponse
//        Response response = Response
//                .status(Response.Status.CREATED)
//                .entity(utilisateurs)
//                .build();
//        
//        return response;
//    }
//    
//    @Path("admin/delete/{id}")
//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteUtilisateur(@PathParam(value = "id")int id){
//        //Création des Utilisateur pour la liste
//        Utilisateur utilisateur1 = new Utilisateur (1, "Chuck", "Norris");
//        Utilisateur utilisateur2 = new Utilisateur (2, "John", "Lenon");
//        
//        //Création et ajout d'Utilisateur à la liste
//        List<Utilisateur> utilisateurs = new ArrayList<>();
//        utilisateurs.add(utilisateur2);
//        utilisateurs.add(utilisateur1);
//        
//        //Filtrer la liste utilisateur pour obtenir utilisateur avec id passé en parametre
//        
//        List<Utilisateur> listeFiltree = utilisateurs.stream().filter(e -> e.getId()== id).collect(Collectors.toList());
//        
//        if(listeFiltree.isEmpty()){
//            return Response
//                    .status(Response.Status.NOT_FOUND)
//                    .entity("ID utilisateur non trouve")
//                    .build();
//
//        }
//        
//        Utilisateur utilisateurTrouve = listeFiltree.get(0);
//        //Trouver l'emplacement de l'utilisateur dans la liste
////        int indexOfUtilisateur = Utilisateurs.indexOf(UtilisateurTrouve);
//        utilisateurs.remove(utilisateurTrouve);
//        
//        //Creation d'une réponse
//        Response response = Response
//                .status(Response.Status.CREATED)
//                .entity(utilisateurs)
//                .build();
//        
//        return response;
//    }
}

