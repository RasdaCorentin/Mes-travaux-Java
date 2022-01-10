/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao;

import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.dao.imp.UtilisateurDaoImp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 33767
 */
/*
Outil merveilleux pour recycler son code. 
10/01/22 10:30 Je vais ajouter Recette et Ingredients encore. On va d'abord tester l'utilisateur
10/01/22 11:15 test ok deux utilisateurs enregistré 
10/01/22 12:00 J'ai implémenter la fonction lister utilisateur en JSON
               Je dois implémenter créer un utilisateur 
10/01/22 15:17 Changement dans RequestFilter
               Création Utilisateur à partir de 0
10/01/22 15:34 premier tests heures creatioN OK

*/

public class DaoFactory {
    private final EntityManagerFactory entityManagerFactory;
    
    public DaoFactory() {
        
        this.entityManagerFactory = Persistence.createEntityManagerFactory("projet-recette");
    }
    
    public EntityManager getEntityManager() {
        return this.entityManagerFactory.createEntityManager();
    }
    
    public void closeEntityManagerFactory() {
        this.entityManagerFactory.close();
    }
    public UtilisateurDaoInterface getUtilisateurDaoInterface(){
        return new UtilisateurDaoImp(this);
    }
}
