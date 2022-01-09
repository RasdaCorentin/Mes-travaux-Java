/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.controllers;

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

}
