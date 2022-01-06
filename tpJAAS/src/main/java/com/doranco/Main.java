/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.Utilisateur;
import com.doranco.handlercallback.TPHandlerCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author 33767
 */
public class Main {
    
            public enum Action {
            act1, act2, act3, logout
        }
    public static void main(String[] args) {
        
/*
--------------------------------------------------------------------------------------------------------------------------
                                                Création étudiant avec DAO FACTORY 
--------------------------------------------------------------------------------------------------------------------------
*/

//       DaoFactory daoFactory = new DaoFactory();
//       
//       Utilisateur utilisateur = new Utilisateur("Corentin", "1234");
//       
//       UtilisateurDaoInterface utilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();
       
//      System.out.println(utilisateurDaoInterface.createUtilisateur(utilisateur));
//        System.out.println(utilisateurDaoInterface.findUtilisateurByNom(utilisateur));
        
//       daoFactory.closeEntityManagerFactory();
//        
        try {
            System.setProperty("java.security.auth.login.config","jaastp.config");
            LoginContext loginContext = new LoginContext("tp", new TPHandlerCallback());
            loginContext.login();
            boolean action = true;
            
            while(action){
                try{
                    action = effectuerAction(loginContext);
                } catch (IOException ex){
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } catch (LoginException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static boolean effectuerAction (LoginContext context)throws IOException, LoginException{
        System.out.println("Choisir  une à effectuer");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = true; 
        
        switch(Action.valueOf(bufferedReader.readLine())){
            case act1:
                System.out.println("Action 1 effectuee avec succes");
                break;
            case act2:
                System.out.println("Action 2 effectuee avec succes");
                break;
            case act3:
                System.out.println("Action 3 effectuee avec succes");
                break;
            case logout:
                context.logout();
                result = false;
                System.out.println("Log out effectuee avec succes");
                break;
        }
        
        return result;    
        
    }
}
