/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.interfaces.EtudiantDaoInterface;
import com.doranco.entities.Etudiant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Wills Corp SARL
 */
public class EtudiantDaoImp implements EtudiantDaoInterface {
    
    private DaoFactory daoFactory;
    
    public EtudiantDaoImp(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }
    
    @Override
    public List<Etudiant> getListeEtudiant() {
        EntityManager entityManager = null;
        List<Etudiant> listEtudiants = new ArrayList<>();
        try {
            entityManager = daoFactory.getEntityManager();

            Query query = entityManager.createQuery("SELECT e FROM Etudiant e", Etudiant.class);
            listEtudiants = query.getResultList();
        } catch (Exception ex) {

            System.out.println("Erreur lister etudiants \n" + ex);
//            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listEtudiants;
    }

    @Override
    public boolean createEtudiant(Etudiant etudiant) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(etudiant);
            transaction.commit();
            System.out.println("<----------- Creation etudiant avec success ------->");
            return true;
            
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur creation etudiant \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }

    @Override
    public Etudiant readEtudiant(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = daoFactory.getEntityManager();
//            Query query = entityManager.createQuery("select e from etudiant where p.id = 1");
            Etudiant etudiant = (Etudiant) entityManager.find(Etudiant.class, id);
            if (etudiant != null) {
                return etudiant;
            } else {
                System.out.println("Aucun e tudiant trouve avec id " + id);
            }
        } catch (Exception ex) {

            System.out.println("Erreur lister etudiants \n" + ex);
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
    public boolean updateEtudiant(Etudiant etudiant, int id) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();

            Etudiant etudiantAModifier = entityManager.find(Etudiant.class, etudiant.getId());
            if (etudiantAModifier != null) {
                transaction = entityManager.getTransaction();

                etudiantAModifier.setNom(etudiant.getNom());
                etudiantAModifier.setPrenom(etudiant.getPrenom());
                
                transaction.begin();
                entityManager.persist(etudiantAModifier);
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

    @Override
    public boolean deleteEtudiant(int id) {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();

            Etudiant etudiantAModifier = entityManager.find(Etudiant.class, id);
            if (etudiantAModifier != null) {
                transaction = entityManager.getTransaction();

                transaction.begin();
                entityManager.remove(etudiantAModifier);
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
