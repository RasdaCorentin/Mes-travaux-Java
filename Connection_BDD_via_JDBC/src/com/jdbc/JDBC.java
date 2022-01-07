package com.jdbc;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//import java.sql.*;
import com.util.BDUtil;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 33767
 */
public class JDBC {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable pour l'établissement d'une connection
        Connection connect = null;
        //variable pour la requete
        Statement statement = null;
        //variable pour enregistrer les résultats
        ResultSet resultats = null;
        
        try{
            //etablissement d'une connection
            connect = BDUtil.getConnection(); //DriverManager.getConnection(URL_JDBC, NOM_UTILISATEUR, MOT_DE_PASSE);
//voir liste etudiant
             String requete = "select * from etudiant";
             statement = connect.createStatement();
             resultats = statement.executeQuery(requete);
             System.out.println("Connection Sucess");
             while (resultats.next()){
                System.out.println("ID:" + resultats.getString("id") 
                        + " Nom:" + resultats.getString("nom") 
                        + " Prenom:" +resultats.getString("prenom") + "\n");
           }
//Ajouter etudiant
//            String requete = "insert into etudiant values (null, 'Puth', 'Charlie')";
//            statement = connect.createStatement();
//            statement.executeUpdate(requete);
//            System.out.println("Enregistrement effectué avec succés");
//Supprimer etudiant 
//    String requete = "delete from etudiant where id = 8";
//             statement = connect.createStatement();
//             statement.executeUpdate(requete);
//             System.out.println("Suppression effectué avec succés");
// 

//Modifier client
//Pour tout sélectionner
//String requeteSelectAll = "select * from etudiant";
//////Pour modifier le nom et le prénom d’un étudiant à un id précis (ici 2, par ex)
//String requeteUpdate = "update etudiant SET nom = 'john', prenom = 'doe' where id = 1";
////Initialisation du statement
//statement = connect.createStatement();
////On lui dit de modifier (update) la table 
//statement.executeUpdate(requeteUpdate);
////Ici, on appelle resultats pour pouvoir boucler dans la table qui a été modifiée au dessus et afficher les etudiants
//resultats = statement.executeQuery(requeteSelectAll);
////Affichage qui va bien pour rassurer, tout ça...
//System.out.println("Modification effectuée avec succès;");
        }catch(SQLException sqlEx){
            System.out.println("Message d'Erreur : " + sqlEx.getMessage());
            
        }finally{
           
                try { 
                    
                    if (resultats != null){
                    resultats.close();
                    } 
                    if (statement != null){
                    statement.close();
                    } 
                    if (connect != null){
                    connect.close();
                    } 
                    
                }catch (SQLException ex) {
                     System.out.println("Message d'Erreur : " + ex.getMessage());
                }
        }
    }
}
    
