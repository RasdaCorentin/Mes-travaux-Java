/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author Admin
 */
@Entity
public class Recette implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String nom;

    
    private String description;

    // Constructeur vide sans parametres
    public Recette() {
        
    }
    //Constructeur avec id
    public Recette(int id) {
        this.id = id;
    }
    // Constructeur sans id
    public Recette(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    //Constructeur complet
    public Recette(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }


    @Override
    public String toString() {
            return "\n Id: "
                    + this.getId()
                    + "\n Nom: "
                    + this.getNom()
                    + "\n Description: "
                    + this.getDescription();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
