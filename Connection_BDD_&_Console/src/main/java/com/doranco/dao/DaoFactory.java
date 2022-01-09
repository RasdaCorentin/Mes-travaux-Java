/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao;

import com.doranco.dao.iinterface.IngredientDaoInterface;
import com.doranco.dao.iinterface.RecetteDaoInterface;
import com.doranco.dao.imp.IngredientDaoImp;
import com.doranco.dao.imp.RecetteDaoImp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 33767
 */
public class DaoFactory {
    private final EntityManagerFactory entityManagerfactory;
    
    public DaoFactory(){
        this.entityManagerfactory = Persistence.createEntityManagerFactory("exam-pu");
    }
     public EntityManager getEntityManager(){
        return this.entityManagerfactory.createEntityManager();
                    }
    public IngredientDaoInterface getIngredientDaoInterface(){
        return new IngredientDaoImp(this);
    }
    public RecetteDaoInterface getRecetteDaoInterface(){
        return new RecetteDaoImp(this);
    }

    public void closeEntityManagerFactory() {
       this.entityManagerfactory.close();
    }
}