/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


/**
 *
 * @author 33767
 */
public class BDUtil {
    
    private static final String NOM_UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "";
    private static final String URL_JDBC = "jdbc:mysql://localhost:3306/formation";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL_JDBC, NOM_UTILISATEUR, MOT_DE_PASSE);
        }catch(SQLException ex) {
            System.out.println("Message d'Erreur : " + ex.getMessage());
        }
        return null;
    }
    
}
