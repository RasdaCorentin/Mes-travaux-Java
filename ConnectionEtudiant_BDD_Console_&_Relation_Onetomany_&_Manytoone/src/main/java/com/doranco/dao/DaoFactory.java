/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao;

import com.doranco.dao.imp.CarteDaoImp;
import com.doranco.dao.imp.EtudiantDaoImp;
import com.doranco.dao.imp.SpecialiteDaoImp;
import com.doranco.dao.interfaces.CarteDaoInterface;
import com.doranco.dao.interfaces.EtudiantDaoInterface;
import com.doranco.dao.interfaces.SpecialiteDaoInterface;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author samha
 */
public class DaoFactory {
    private final EntityManagerFactory entityManagerFactory;
    
    public DaoFactory() {
        //A la création, on récupère le contexte / la persistance
        this.entityManagerFactory = Persistence.createEntityManagerFactory("tp3-pu-1");
    }
    
    public EntityManager getEntityManager() {
        return this.entityManagerFactory.createEntityManager();
    }
    
    public void closeEntityManagerFactory() {
        this.entityManagerFactory.close();
    }
     
    
    public EtudiantDaoInterface getEtudiantDaoInterface () {
        //Ici, on passe tous les parametres de l'objet Dao avec le this
        //car EtudiantDaoImp est capable de prendre en param un objet DaoFactory
        return new EtudiantDaoImp(this);
    }
    
    public SpecialiteDaoInterface getSpecialiteDaoInterface () {
        //this represente l'objet daoFactory créé lors de l'appel du constructeur
        return new SpecialiteDaoImp(this); 
    }
    
    public CarteDaoInterface getCarteDaoInterface () {
        //this represente l'objet daoFactory créé lors de l'appel du constructeur
        return new CarteDaoImp(this); 
    }
    
}
