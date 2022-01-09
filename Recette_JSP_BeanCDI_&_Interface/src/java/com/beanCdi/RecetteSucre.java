/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beanCdi;

import com.iinterface.RecetteQualif;
import com.iinterface.RecetteRemote;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;

/**
 *
 * @author 33767
 */

@ApplicationScoped
public class RecetteSucre implements RecetteRemote{
    private String nomR, descR;
    @Override
    public String typeRecette(){
        return "sucré";
    }
    @Override
    public String getNomR() {
        return nomR;
    }

    @Override
    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    @Override
    public String getDescR() {
        return descR;
    }

    @Override
    public void setDescR(String descR) {
        this.descR = descR;
    }
    @Override
    public String recetteToString() {
        return "Recette : " + this.nomR 
             + "\n Description de la recette : " + this.descR 
             + "\n Type de recette : Ceci est une recette " + typeRecette();
    }
    private String nom;
    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
}