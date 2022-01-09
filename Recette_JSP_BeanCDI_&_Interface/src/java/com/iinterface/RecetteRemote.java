/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iinterface;

import jakarta.ejb.Remote;

/**
 *
 * @author 33767
 */
@Remote
public interface RecetteRemote {
    String typeRecette();
    String getNomR();
    void setNomR(String nomR);
    String getDescR();
    void setDescR(String descR);
    String recetteToString();
    String getNom();
    void setNom(String nom);
}

