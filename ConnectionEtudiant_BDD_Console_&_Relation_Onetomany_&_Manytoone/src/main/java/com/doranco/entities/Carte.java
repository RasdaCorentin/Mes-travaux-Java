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
import javax.persistence.OneToOne;

/**
 *
 * @author Wills Corp SARL
 */

@Entity
public class Carte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    
    private int code;
    
    @OneToOne()
    private Etudiant etudiant;
    
    public Carte(){
        this.code = (int) Math.floor(Math.random()*(5000 - 1000000 +1)+5000) *-1;
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
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the etudiant
     */
    public Etudiant getEtudiant() {
        return etudiant;
    }

    /**
     * @param etudiant the etudiant to set
     */
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
}
