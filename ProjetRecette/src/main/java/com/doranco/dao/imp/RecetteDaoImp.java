/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.RecetteDaoInterface;
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
    public Recette createRecette(Recette recette) {
        
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();
            
// ------------------------------------------Methode-------------------------------------------------- 

            recette.setDateCrea(dtf.format(now));
            recette.setDateModif(dtf.format(now));
//  Il faut aussi ajouter les ingredients
            recette.setLibelle(recette.getLibelle());
            recette.setDescription(recette.getDescription());
            
            transaction.begin();
            entityManager.persist(recette);
            transaction.commit();
            System.out.println("<----------- Creation Recette avec success ------->");
            return recette;
 
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

    @Override
    public boolean deleteRecette(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateRecette(Recette recette, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
