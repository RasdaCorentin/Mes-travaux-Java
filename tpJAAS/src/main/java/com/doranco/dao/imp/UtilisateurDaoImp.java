/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * @author Wills Corp SARL
 */
public class UtilisateurDaoImp implements UtilisateurDaoInterface {
    
    private DaoFactory daoFactory;
    
    public UtilisateurDaoImp(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }
    

    @Override
    public List<Utilisateur> getListeUtilisateurs() {
        
        EntityManager entityManager = null;
        List<Utilisateur> listeUtilisateurs = new ArrayList<>();
       
        try {
// ------------------------------------------Methode-------------------------------------------------- 

            entityManager = daoFactory.getEntityManager();

            Query query = entityManager.createQuery("SELECT e FROM Utilisateur e", Utilisateur.class);
            listeUtilisateurs = query.getResultList();
            
// ---------------------------------------FIN Methode--------------------------------------------------            
        } catch (Exception ex) {

            System.out.println("Erreur lister Utilisateurs \n" + ex);
//            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listeUtilisateurs;
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();
            
// ------------------------------------------Methode-------------------------------------------------- 

            transaction.begin();
            entityManager.persist(utilisateur);
            transaction.commit();
            System.out.println("<----------- Creation Utilisateur avec success ------->");
            return utilisateur;
            
// ---------------------------------------FIN Methode-------------------------------------------------- 

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur creation Utilisateur \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return null;
    }

    @Override
    public Utilisateur readUtilisateur(int id) {
        EntityManager entityManager = null;
        try {
            
            entityManager = daoFactory.getEntityManager();
//            Query query = entityManager.createQuery("select e from Utilisateur where p.id = 1");
// ------------------------------------------Methode--------------------------------------------------
            Utilisateur utilisateur = (Utilisateur) entityManager.find(Utilisateur.class, id);
            if (utilisateur != null) {
                return utilisateur;
            } else {
                System.out.println("Aucun Utilisateur trouve avec id " + id);
            }
// ---------------------------------------FIN Methode--------------------------------------------------            
        } catch (Exception ex) {

            System.out.println("Erreur lister Utilisateurs \n" + ex);
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
    public boolean updateUtilisateur(Utilisateur utilisateur, int id) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
// ------------------------------------------Methode--------------------------------------------------
            Utilisateur utilisateurAModifier = entityManager.find(Utilisateur.class, utilisateur.getId());
            if (utilisateurAModifier != null) {
                transaction = entityManager.getTransaction();

                utilisateurAModifier.setNom(utilisateur.getNom());
                utilisateurAModifier.setPassword(utilisateur.getPassword());

                transaction.begin();
                entityManager.persist(utilisateurAModifier);
                transaction.commit();
                System.out.println("<----------- Mise a jour Utilisateur avec success ------->");
// ---------------------------------------FIN Methode-------------------------------------------------- 

                return true;
            }
            System.out.println("<----------- Utilisateur avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour Utilisateur \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }
    
    @Override
    public boolean deleteUtilisateur(int id) {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();
            
// ------------------------------------------Methode--------------------------------------------------
            Utilisateur utilisateurAModifier = entityManager.find(Utilisateur.class, id);
            if (utilisateurAModifier != null) {
                transaction = entityManager.getTransaction();

                transaction.begin();
                entityManager.remove(utilisateurAModifier);
                transaction.commit();
                System.out.println("<-----------Supression avec success ------->");
// ---------------------------------------FIN Methode-------------------------------------------------- 

                return true;
            }
            System.out.println("<----------- Utilisateur avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour Utilisateur \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }

}
