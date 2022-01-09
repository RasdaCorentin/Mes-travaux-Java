/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.interfaces;

import com.doranco.entities.Etudiant;
import java.util.List;

/**
 *
 * @author samha
 */
public interface EtudiantDaoInterface {
    List<Etudiant> getListeEtudiant();
    
    //Create (constructeur sans id)
    boolean createEtudiant(Etudiant etudiant);
    
    //Read etudiant à partir de son identifiant
    Etudiant readEtudiant (int id);
    
    //Update (constructeur avec id)
    boolean updateEtudiant(Etudiant etudiant, int id);
    
    //Delete un etudiant
    boolean deleteEtudiant (int id);
}

