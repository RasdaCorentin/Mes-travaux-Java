/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 33767
 */
@Entity
public class Ingredient {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nom;
private int quantite;

    // Constructeur vide sans parametres
    public Ingredient() {
        
    }
    //Constructeur avec id
    public Ingredient(int id) {
        this.id = id;
    }
    // Constructeur sans id
    public Ingredient(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }
    //Constructeur complet
    public Ingredient(int id, String nom, int quantite) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
    }


    @Override
    public String toString() {
            return "\n Id: "
                    + this.getId()
                    + "\n Nom: "
                    + this.getNom()
                    + "\n Quantite: "
                    + this.getQuantite();
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
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
