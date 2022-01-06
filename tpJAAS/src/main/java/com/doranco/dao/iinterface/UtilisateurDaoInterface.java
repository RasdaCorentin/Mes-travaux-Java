/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.iinterface;

import com.doranco.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author 33767
 */
public interface UtilisateurDaoInterface {
    
    //Lister tout les Utilisateur
    List<Utilisateur> getListeUtilisateurs();
    
    //Creer un Utilisateur
    Utilisateur createUtilisateur(Utilisateur utilisateur);
    
    Utilisateur loginUtilisateur(Utilisateur utilisateur);
    
    //Lire un Utilisateur a partir de son ID
    Utilisateur findUtilisateurByNom(Utilisateur utilisateur);
    
//    //Mettre a jour un Utilisateur
//    boolean updateUtilisateur(Utilisateur utilisateur, int id);
//    
//    //Supprimer un Utilisateur
//    boolean deleteUtilisateur(int id);
    
    boolean comparePassword(String passwordTemp, Utilisateur utilisateur);
    
}
