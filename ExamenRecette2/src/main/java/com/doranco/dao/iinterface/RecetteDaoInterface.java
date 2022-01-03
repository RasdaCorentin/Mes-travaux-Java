/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.iinterface;

import com.doranco.entities.Recette;
import java.util.List;

/**
 *
 * @author 33767
 */

public interface RecetteDaoInterface {
    //Lister tout les recette
    List<Recette> getListeRecettes();
    
    //Creer un recette
    boolean createRecette(Recette recette);
    
    //Lire un recette a partir de son ID
    Recette readRecette(int id);
    
    //Mettre a jour un recette
    boolean updateRecette(Recette recette, int id);
    
    //Supprimer un recette
    boolean deleteRecette(int id);
}
