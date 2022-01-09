/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Wills Corp SARL
 */
@Entity
public class Specialite implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titre;

    private String description;
    
    @OneToMany(mappedBy = "specialite")
    private List<Etudiant> listeEtudiants = new ArrayList<>();

    public Specialite() {

    }

    public Specialite(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Specialite(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
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
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
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
    
    @Override
    public String toString(){
          return "\n Id: " + this.id + "\n Nom: " + this.titre + "\n Prenom: " + this.description;
    }

    /**
     * @return the listeEtudiants
     */
    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    /**
     * @param listeEtudiants the listeEtudiants to set
     */
    public void setListeEtudiants(List<Etudiant> listeEtudiants) {
        this.listeEtudiants = listeEtudiants;
    }

}
