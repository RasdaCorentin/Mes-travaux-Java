/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nom_etudiant")
    private String nom;
    
    @Column(name = "prenom_etudiant")
    private String prenom;
    
    @ManyToOne()
    private Specialite specialite;

    @OneToOne()
    private Carte carte;
    
    
    // Constructeur vide sans parametres
    public Etudiant() {

    }

    // Constructeur sans id
    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    //Constructeur complet
    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        if (this.specialite != null && this.carte != null) {
        return "\n Id: " 
                + this.id 
                + "\n Nom: " 
                + this.nom 
                + "\n Prenom: " 
                + this.prenom
                + "\n";
    } else {
            return "\n Id: " 
                + this.id 
                + "\n Nom: " 
                + this.nom 
                + "\n Prenom: " 
                + this.prenom
                + "\n Specialite: "
                + this.specialite.getTitre()
                + "\n Carte : " 
                + this.carte.getCode();
        }
    }
    /**
     * @return the specialite
     */
    public Specialite getSpecialite() {
        return specialite;
    }

    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    /**
     * @return the carte
     */
    public Carte getCarte() {
        return carte;
    }

    /**
     * @param carte the carte to set
     */
    public void setCarte(Carte carte) {
        this.carte = carte;
    }

}
