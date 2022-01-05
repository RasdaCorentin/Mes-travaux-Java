/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.principal;

import java.security.Principal;

/**
 *
 * @author 33767
 */
public class TPPrincipal implements Principal {
    private String nom;
    
    public TPPrincipal (String nom){
        this.nom = nom;
    }
    
    @Override
    public String getName() {
       return this.nom;
    }
    
}
