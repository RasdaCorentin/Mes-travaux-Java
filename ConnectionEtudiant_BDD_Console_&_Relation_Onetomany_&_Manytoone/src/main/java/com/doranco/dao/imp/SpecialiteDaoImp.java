/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.interfaces.SpecialiteDaoInterface;
import com.doranco.entities.Specialite;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


/**
 *
 * @author samha
 */
public class SpecialiteDaoImp implements SpecialiteDaoInterface {

    private DaoFactory daoFactory;

    //Constructeur de la classe, qui initialise la variable daoFactory avec ce qui est passé en parametetre dans DaoFactory
    public SpecialiteDaoImp(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override //Fonctionne
    public List<Specialite> getListeSpecialites() {
        //return daoFactory.getEntityManager().createQuery("select s from Specialite s").getResultList();
        EntityManager entityManager = null;

        List<Specialite> listeSpecialites = new ArrayList<>();

        String requeteJPQL = "select spec from Specialite spec";
        try {
            entityManager = daoFactory.getEntityManager();
            Query query = entityManager.createQuery(requeteJPQL, Specialite.class);
            listeSpecialites = query.getResultList();

        } catch (Exception ex) {

            System.out.println("Erreur :" + ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listeSpecialites;

    }

    @Override //Fonctionne
    public Specialite createSpecialite(Specialite specialite) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();
            // Debut de la transaction en base de donnees
            transaction.begin();
            entityManager.persist(specialite);
            transaction.commit();
            return specialite;

        } catch (Exception ex) {
            if (transaction != null) {
                // Annulation des operations en cas d'echec de la transaction
                transaction.rollback();
            }
            System.out.println("Erreur :" + ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return null;
    }

    @Override //Fonctionne
    public Specialite readSpecialite(int id) {
        return daoFactory.getEntityManager().find(Specialite.class, id);
    }

    @Override //A corriger
    public boolean updateSpecialite(Specialite specialite, int id) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();

            Specialite specialiteAModifier = entityManager.find(Specialite.class, id);
            if (specialiteAModifier != null) {
                transaction = entityManager.getTransaction();

                specialiteAModifier.setTitre(specialite.getTitre());
                specialiteAModifier.setDescription(specialite.getDescription());
                
                transaction.begin();
                entityManager.persist(specialiteAModifier);
                transaction.commit();
                System.out.println("<----------- Mise a jour etudiant avec success ------->");
                return true;

            }
            System.out.println("<----------- Etudiant avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour etudiant \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }

    @Override //A completer
    public boolean deleteSpecialite(int id) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();

            Specialite specialiteAModifier = entityManager.find(Specialite.class, id);
            if (specialiteAModifier != null) {
                transaction = entityManager.getTransaction();

                transaction.begin();
                entityManager.remove(specialiteAModifier);
                transaction.commit();
                System.out.println("<-----------Supression avec success ------->");
                return true;

            }
            System.out.println("<----------- Etudiant avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour etudiant \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }
   

}
