/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.IngredientDaoInterface;
import com.doranco.entities.Ingredient;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author 33767
 */
public class IngredientDaoImp implements IngredientDaoInterface {
    
    private DaoFactory daoFactory;
    
    public IngredientDaoImp(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Ingredient> getListeIngredients() {
        
        EntityManager entityManager = null;
        List<Ingredient> listeIngredients = new ArrayList<>();
       
        try {
// ------------------------------------------Methode-------------------------------------------------- 

            entityManager = daoFactory.getEntityManager();

            Query query = entityManager.createQuery("SELECT e FROM Ingredient e", Ingredient.class);
            listeIngredients = query.getResultList();
            
// ---------------------------------------FIN Methode--------------------------------------------------            
        } catch (Exception ex) {

            System.out.println("Erreur lister ingredients \n" + ex);
//            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listeIngredients;
    }

    @Override
    public boolean createIngredient(Ingredient ingredient) {
                
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();
            
// ------------------------------------------Methode-------------------------------------------------- 

            transaction.begin();
            entityManager.persist(ingredient);
            transaction.commit();
            System.out.println("<----------- Creation ingredient avec success ------->");
            
            
// ---------------------------------------FIN Methode-------------------------------------------------- 

        return true;
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur creation ingredient \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }

    @Override
    public Ingredient readIngredient(int id) {
                EntityManager entityManager = null;
        try {
            
            entityManager = daoFactory.getEntityManager();
//            Query query = entityManager.createQuery("select e from ingredient where p.id = 1");
// ------------------------------------------Methode--------------------------------------------------
            Ingredient ingredient = (Ingredient) entityManager.find(Ingredient.class, id);
            if (ingredient != null) {
                return ingredient;
            } else {
                System.out.println("Aucun ingredient trouve avec id " + id);
            }
// ---------------------------------------FIN Methode--------------------------------------------------            
        } catch (Exception ex) {

            System.out.println("Erreur lister ingredients \n" + ex);
//            ex.printStackTrace();

        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }
        System.out.println("Non trouve");
        return null;
    }

    @Override
    public boolean updateIngredient(Ingredient ingredient, int id) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
// ------------------------------------------Methode--------------------------------------------------
            Ingredient ingredientAModifier = entityManager.find(Ingredient.class, ingredient.getId());
            if (ingredientAModifier != null) {
                transaction = entityManager.getTransaction();

                ingredientAModifier.setNom(ingredient.getNom());
                ingredientAModifier.setQuantite(ingredient.getQuantite());

                transaction.begin();
                entityManager.persist(ingredientAModifier);
                transaction.commit();
                System.out.println("<----------- Mise a jour ingredient avec success ------->");
// ---------------------------------------FIN Methode-------------------------------------------------- 

                return true;
            }
            System.out.println("<----------- Ingredient avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour ingredient \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }

    @Override
    public boolean deleteIngredient(int id) {
        
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();
            
// ------------------------------------------Methode--------------------------------------------------
            Ingredient ingredientAModifier = entityManager.find(Ingredient.class, id);
            if (ingredientAModifier != null) {
                transaction = entityManager.getTransaction();

                transaction.begin();
                entityManager.remove(ingredientAModifier);
                transaction.commit();
                System.out.println("<-----------Supression avec success ------->");
// ---------------------------------------FIN Methode-------------------------------------------------- 

                return true;
            }
            System.out.println("<----------- Ingredient avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour ingredient \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }
    
}
