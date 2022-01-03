/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.RecetteDaoInterface;
import com.doranco.entities.Recette;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author 33767
 */
public class RecetteDaoImp implements RecetteDaoInterface {
    
    private DaoFactory daoFactory;
    
    public RecetteDaoImp(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

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

            System.out.println("Erreur lister recettes \n" + ex);
//            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listeRecettes;
    }
    

    @Override
    public boolean createRecette(Recette recette) {
                
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();
            
// ------------------------------------------Methode-------------------------------------------------- 

            transaction.begin();
            entityManager.persist(recette);
            transaction.commit();
            System.out.println("<----------- Creation recette avec success ------->");
            return true;
            
// ---------------------------------------FIN Methode-------------------------------------------------- 

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur creation recette \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }

    @Override
    public Recette readRecette(int id) {
        EntityManager entityManager = null;
        try {
            
            entityManager = daoFactory.getEntityManager();
//            Query query = entityManager.createQuery("select e from recette where p.id = 1");
// ------------------------------------------Methode--------------------------------------------------
            Recette recette = (Recette) entityManager.find(Recette.class, id);
            if (recette != null) {
                return recette;
            } else {
                System.out.println("Aucun recette trouve avec id " + id);
            }
// ---------------------------------------FIN Methode--------------------------------------------------            
        } catch (Exception ex) {

            System.out.println("Erreur lister recettes \n" + ex);
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
    public boolean updateRecette(Recette recette, int id) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
// ------------------------------------------Methode--------------------------------------------------
            Recette recetteAModifier = entityManager.find(Recette.class, recette.getId());
            if (recetteAModifier != null) {
                transaction = entityManager.getTransaction();

                recetteAModifier.setNom(recette.getNom());
                recetteAModifier.setDescription(recette.getDescription());

                transaction.begin();
                entityManager.persist(recetteAModifier);
                transaction.commit();
                System.out.println("<----------- Mise a jour recette avec success ------->");
// ---------------------------------------FIN Methode-------------------------------------------------- 

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

    @Override
    public boolean deleteRecette(int id) {
        
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();
            
// ------------------------------------------Methode--------------------------------------------------
            Recette recetteAModifier = entityManager.find(Recette.class, id);
            if (recetteAModifier != null) {
                transaction = entityManager.getTransaction();

                transaction.begin();
                entityManager.remove(recetteAModifier);
                transaction.commit();
                System.out.println("<-----------Supression avec success ------->");
// ---------------------------------------FIN Methode-------------------------------------------------- 

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
