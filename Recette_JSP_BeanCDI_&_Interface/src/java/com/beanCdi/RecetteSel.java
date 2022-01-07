package com.beanCdi;

import com.iinterface.RecetteQualif;
import com.iinterface.RecetteRemote;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;

@RecetteQualif
@ApplicationScoped
public class RecetteSel implements RecetteRemote{
    private String nomR, descR;
    @Override
    public String typeRecette(){
        return "salé";
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
