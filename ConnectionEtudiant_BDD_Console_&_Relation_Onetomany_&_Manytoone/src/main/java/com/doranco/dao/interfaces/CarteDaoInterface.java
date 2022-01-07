/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.interfaces;

import com.doranco.entities.Carte;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author samha
 */
//@Entity
public interface CarteDaoInterface {
     List<Carte> getListeCarte();
    
    //Create (constructeur sans id)
    Carte createCarte(Carte carte);
}
