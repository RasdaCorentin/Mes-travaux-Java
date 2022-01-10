/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.Utilisateur;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.mindrot.jbcrypt.BCrypt;

/*
 * @author 
 */
public class UtilisateurDaoImp implements UtilisateurDaoInterface {
    private DaoFactory daoFactory;
    
    public UtilisateurDaoImp(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }
    
//Utilise Jquery pour avoir une liste d'utilisateur depuis la base de données
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
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  

            String salt = BCrypt.gensalt();
            String passwordHash = BCrypt.hashpw(utilisateur.getPassword(), salt);
            utilisateur.setDateCrea(dtf.format(now));
            utilisateur.setDateModif(dtf.format(now));
            utilisateur.setPassword(passwordHash);
            utilisateur.setSalt(salt);
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
    public Utilisateur findUtilisateurByNom(Utilisateur utilisateur) {
        EntityManager entityManager = null;            
            entityManager = daoFactory.getEntityManager();
            Query query = entityManager.createQuery("select util from Utilisateur util where nom=:username");
              query.setParameter("username",utilisateur.getNom());             
              if (query.getResultList().isEmpty()){
                  System.out.println("Ce nom utilisateur n'existe pas");
                  return null;}
              utilisateur = (Utilisateur) query.getResultList().get(0);           
              return utilisateur;}

    /*
    Methode login lié à la methode compare
    */

    @Override
    public Utilisateur loginUtilisateur(Utilisateur utilisateur) {
        EntityManager entityManager = null;
        
        entityManager = daoFactory.getEntityManager();
        String passwordTemp = utilisateur.getPassword();
        utilisateur = findUtilisateurByNom(utilisateur);
        if(utilisateur == null){
         return null;   
        }
        if(comparePassword(passwordTemp, utilisateur)){
            return utilisateur;
        }
        
        return null;
        
        //Vérifie présence utilisateur
//        entityManager = daoFactory.getEntityManager();
//        
//        Query query = entityManager.createQuery("SELECT u from Utilisateur u WHERE u.nom = '" + utilisateur.getNom() + "' AND u.password = '" + utilisateur.getPassword() + "'");
//        
//        if(query.getResultList().isEmpty()){
//            System.out.println("Aucun utilisateur trouvé");
//            return null;
//        
//    }
//    utilisateur = (Utilisateur) query.getResultList().get(0);
//    utilisateur.setPassword(null);
//        System.out.println("Utilisateur Existe : " + utilisateur );
//    return utilisateur;
}
    @Override
    public boolean comparePassword(String passwordTemp, Utilisateur utilisateur) {
     String passwordHash = BCrypt.hashpw(passwordTemp, utilisateur.getSalt());
     if(passwordHash.compareTo(utilisateur.getPassword()) == 0){
         return true;
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
            System.out.println("<----------- utilisateur avec id non trouve ------->");
            return false;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur mise a jour utilisateur \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return false;
    }

}
