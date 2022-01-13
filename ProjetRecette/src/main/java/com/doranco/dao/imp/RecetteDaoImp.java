/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.IngredientDaoInterface;
import com.doranco.dao.iinterface.RecetteDaoInterface;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.Ingredient;
import com.doranco.entities.Recette;
import com.doranco.entities.Utilisateur;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;



/*
 * @author 
 */
public class RecetteDaoImp implements RecetteDaoInterface {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    Ingredient ingredient = new Ingredient();
    private DaoFactory daoFactory;
    
    public RecetteDaoImp(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    
    
/*
--------------------------------------------------------------------------------------------------------------------------
                                                 Liste Recette avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/    
//Utilise Jquery pour avoir une liste d'recette depuis la base de données
    @Override
    public List<Recette> getListeRecettes() {
        
        EntityManager entityManager = null;
        List<Recette> listeRecettes = new ArrayList<>();
       
        try {
// ------------------------------------------Methode-------------------------------------------------- 

            entityManager = daoFactory.getEntityManager();

            Query query = entityManager.createQuery("SELECT e FROM Recette e", Recette.class);
            listeRecettes = query.getResultList();
            
// ---------------------------------------FIN Methode--------------------------------------------------            
        } catch (Exception ex) {

            System.out.println("Erreur lister Recettes \n" + ex);
//            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listeRecettes;
    }
    
    
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Création Recette avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Override
    public Recette createRecette(Recette recette, Utilisateur utilisateur) {
        
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();
            
// ------------------------------------------Methode--------------------------------------------------              
// Marche pour ajouter une recette / utilisateur
            UtilisateurDaoInterface utilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();
            utilisateur = utilisateurDaoInterface.findUtilisateurByNom(utilisateur);
            
            if (utilisateur != null) {
            recette.setUtilisateur(utilisateur);
            recette.setDateCrea(dtf.format(now));
            recette.setDateModif(dtf.format(now));            
            recette.setLibelle(recette.getLibelle());
            recette.setDescription(recette.getDescription());           
            
            transaction.begin();            
            entityManager.persist(recette);
// Ajouter les ingredient
            
            List<Ingredient> listeIngredient = new ArrayList<>(recette.getListeIngredients());
            IngredientDaoInterface ingredientDaoInterface = daoFactory.getIngredientDaoInterface();
            Ingredient ingredient1 = new Ingredient();
            //Je passe recette en parametre
            ingredient1.setRecette(recette);
            ingredient1 = ingredientDaoInterface.createIngredient(listeIngredient.get(0));
            
            entityManager.persist(ingredient1);
            transaction.commit();
            System.out.println("<----------- Creation Recette avec success ------->");
            return recette;
            }
// ---------------------------------------FIN Methode-------------------------------------------------- 

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur creation Recette \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return null;
    }
/*
--------------------------------------------------------------------------------------------------------------------------
                                                 Delete Recette avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/    
    @Override
    public boolean deleteRecette(int id) {
        
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();
            
// ------------------------------------------Methode--------------------------------------------------

            Recette recette = entityManager.find(Recette.class, id);
            if (recette != null) {
                transaction = entityManager.getTransaction();

                transaction.begin();
                entityManager.remove(recette);
                transaction.commit();
                System.out.println("<-----------Supression avec success ------->");
                
// ---------------------------------------FIN Methode-------------------------------------------------- 

                return true;
            }
            System.out.println("<----------- Recette avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour Recette \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Update Recette avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/
    @Override
    public boolean updateRecette(Recette recette, int id) {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();
            System.out.println("------------------ DEBUT CHANGEMENT ---------");
// ------------------------------------------Methode--------------------------------------------------

            recette = entityManager.find(Recette.class, id);
            if (recette != null) {
                transaction = entityManager.getTransaction();
                                                
                recette.setDateModif(dtf.format(now));
                recette.setLibelle(recette.getLibelle());
                recette.setDescription(recette.getDescription());
                
// Ajouter les ingredients à modifier par ID 
// ---------------------------------------FIN Methode--------------------------------------------------   
                System.out.println("--------------------FIN CHANGEMENT-------------");
                transaction.begin();
                entityManager.persist(recette);
                transaction.commit();
                System.out.println("<----------- Mise a jour Recette avec success ------->");
                return true;

            }
            System.out.println("<----------- Recette avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour recette \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }
    

}
