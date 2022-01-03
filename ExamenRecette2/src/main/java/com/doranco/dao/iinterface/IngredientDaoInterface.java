/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.iinterface;
import com.doranco.entities.Ingredient;
import java.util.List;

/**
 *
 * @author 33767
 */
public interface IngredientDaoInterface {
    
    //Lister tout les ingredient
    List<Ingredient> getListeIngredients();
    
    //Creer un ingredient
    boolean createIngredient(Ingredient ingredient);
    
    //Lire un ingredient a partir de son ID
    Ingredient readIngredient(int id);
    
    //Mettre a jour un ingredient
    boolean updateIngredient(Ingredient ingredient, int id);
    
    //Supprimer un ingredient
    boolean deleteIngredient(int id);
}
