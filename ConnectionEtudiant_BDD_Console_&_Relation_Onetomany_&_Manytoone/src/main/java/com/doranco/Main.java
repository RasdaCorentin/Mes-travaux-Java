/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.imp.EtudiantDaoImp;
import com.doranco.dao.imp.SpecialiteDaoImp;
import com.doranco.dao.interfaces.CarteDaoInterface;
import com.doranco.dao.interfaces.EtudiantDaoInterface;
import com.doranco.dao.interfaces.SpecialiteDaoInterface;
import com.doranco.entities.Carte;
import com.doranco.entities.Etudiant;
import com.doranco.entities.Specialite;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author samha
 */
public class Main {

    public static void main(String[] args) {

//        DaoFactory daoFactory = new DaoFactory();
//
//        Specialite specialite = new Specialite("Sciences", "Maths, physique, chimie");
//        Etudiant etudiant = new Etudiant("Danvers", "Carole");
//        Carte carte = new Carte();
//        SpecialiteDaoInterface specialiteDaoInterface = daoFactory.getSpecialiteDaoInterface();
//        EtudiantDaoInterface etudiantDaoInterface = daoFactory.getEtudiantDaoInterface();
////          
//
//       carte = CarteDaoInterface.createCarte(carte);
//       specialite = specialiteDaoInterface.createSpecialite(specialite);
////        
//        etudiant.setSpecialite(specialite);
////        
//        etudiant.setCarte(carte);
//
//        etudiantDaoInterface.createEtudiant(etudiant);
//
//        daoFactory.closeEntityManagerFactory();

DaoFactory daoFactory = new DaoFactory();
        
        Specialite specialite = new Specialite("Securite systeme Information", "Introduction securite systemes information...");
        Etudiant etudiant = new Etudiant("William", "Wills");
        Carte carte = new Carte();
//        
        SpecialiteDaoInterface specialiteDaoInterface = daoFactory.getSpecialiteDaoInterface();
        EtudiantDaoInterface etudiantDaoInterface = daoFactory.getEtudiantDaoInterface();
        CarteDaoInterface carteDaoInterface = daoFactory.getCarteDaoInterface();
        
        carte = carteDaoInterface.createCarte(carte);
        
        specialite = specialiteDaoInterface.createSpecialite(specialite);
        
        etudiant.setSpecialite(specialite);
        etudiant.setCarte(carte);
        
        etudiantDaoInterface.createEtudiant(etudiant);
        
        
        System.out.println(etudiant.toString());
        
        daoFactory.closeEntityManagerFactory();


    }
}
