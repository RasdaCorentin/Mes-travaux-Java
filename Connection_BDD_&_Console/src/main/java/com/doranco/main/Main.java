/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.main;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.IngredientDaoInterface;
import com.doranco.dao.iinterface.RecetteDaoInterface;
import com.doranco.dao.imp.IngredientDaoImp;
import com.doranco.dao.imp.RecetteDaoImp;
import com.doranco.entities.Recette;
import com.doranco.entities.Ingredient;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 33767
 */

public class Main {
    public static void main(String[] args) {

/*
--------------------------------------------------------------------------------------------------------------------------
                                                Lister les Ingredients avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/    
//        
        DaoFactory daoFactory = new DaoFactory();
        
        IngredientDaoInterface ingredientDaoInterface = daoFactory.getIngredientDaoInterface();
        
        System.out.println(ingredientDaoInterface.getListeIngredients());
        daoFactory.closeEntityManagerFactory();


/*
--------------------------------------------------------------------------------------------------------------------------
                                                Création Ingredient avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
//
//       DaoFactory daoFactory = new DaoFactory();
//       
//       Ingredient ingredient = new Ingredient("Shaquille", 5);
//       
//       IngredientDaoInterface ingredientDaoInterface = daoFactory.getIngredientDaoInterface();
//       
//       System.out.println(ingredientDaoInterface.createIngredient(ingredient));
//       daoFactory.closeEntityManagerFactory();
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Read Ingredient avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
//       DaoFactory daoFactory = new DaoFactory();
//      
//       IngredientDaoInterface ingredientDaoInterface = daoFactory.getIngredientDaoInterface();
//       
//       System.out.println(ingredientDaoInterface.readIngredient(1));
//        daoFactory.closeEntityManagerFactory();
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Update Ingredient avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
//       DaoFactory daoFactory = new DaoFactory();
//       
//       Ingredient ingredient = new Ingredient(1, "Lucky", "Luke");
//       
//       IngredientDaoInterface ingredientDaoInterface = daoFactory.getIngredientDaoInterface();
//       
//       ingredientDaoInterface.updateIngredient(ingredient, 1);
//        daoFactory.closeEntityManagerFactory();
/*
--------------------------------------------------------------------------------------------------------------------------
                                                 Delete Ingredient avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
//       DaoFactory daoFactory = new DaoFactory();
//       
//       IngredientDaoInterface ingredientDaoInterface = daoFactory.getIngredientDaoInterface();
//       
//       ingredientDaoInterface.deleteIngredient(1);
//        daoFactory.closeEntityManagerFactory();
    }
}
