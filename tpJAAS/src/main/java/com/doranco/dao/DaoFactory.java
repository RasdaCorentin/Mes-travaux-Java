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
public class DaoFactory {
    private final EntityManagerFactory entityManagerFactory;
    
    public DaoFactory() {
        //A la création, on récupère le contexte / la persistance
        this.entityManagerFactory = Persistence.createEntityManagerFactory("tp-jaas");
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
