/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.entities;


/**
 *
 * @author 33767
 */

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true, nullable = false)
    private String nom;
    
    @Column(name = "password")
    private String password;
    
    private String salt;
    
    @Enumerated(EnumType.STRING)
    private RoleUtilisateur role;
    
    // Constructeur vide sans parametres
    public Utilisateur() {
        
    }
    //Constructeur avec id
    public Utilisateur(int id) {
        this.id = id;
    }
    // Constructeur sans id
    public Utilisateur(String nom, String password, RoleUtilisateur role) {
        this.nom = nom;
        this.password = password;
        this.role = role;
    }
    //Constructeur complet
    public Utilisateur(int id, String nom, String password) {
        this.id = id;
        this.nom = nom;
        this.password = password;
    }

    public Utilisateur(String nom, String password) {
      this.nom = nom;
      this.password = password;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
        @Override
    public String toString() {
            return "\n Id: "
                    + this.id
                    + "\n Nom: "
                    + this.nom
                    + "\n Password: "
                    + this.password
                    + "\n Role: "
                    + this.role;

        }

    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return the role
     */
    public RoleUtilisateur getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(RoleUtilisateur role) {
        this.role = role;
    }
    
    public boolean isAdmin(){
        return this.role.equals(RoleUtilisateur.ADMIN);
    }
    
}
