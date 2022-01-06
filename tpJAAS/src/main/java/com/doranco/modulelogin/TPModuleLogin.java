/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.modulelogin;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.iinterface.UtilisateurDaoInterface;
import com.doranco.entities.Utilisateur;
import com.doranco.principal.TPPrincipal;
import java.io.IOException;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 *
 * @author 33767
 */
public class TPModuleLogin implements LoginModule {

//    private static final String[][] USERS__TEST = {{"Corentin", "123"},{"Rasda","1234"}};
    private Subject subject;
    private CallbackHandler callbackHandler;
    private TPPrincipal tPPrincipal;
    
    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> map, Map<String, ?> map1) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        System.out.println("---------------Initialisation du module login-------------------");
    }

    @Override
    public boolean login() throws LoginException {
        System.out.println("<-------Login en cours------------->");
        boolean login = false;
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("Nom: ");
        callbacks[1] = new PasswordCallback("Mot de passe: ",false);
        
        try{
            this.callbackHandler.handle(callbacks);
            String nom = ((NameCallback)callbacks[0]).getName();
            String password = new String (((PasswordCallback) callbacks[1]).getPassword());
            
            Utilisateur utilisateur = new Utilisateur(nom, password);
            DaoFactory daoFactory = new DaoFactory();
            UtilisateurDaoInterface utilisateurDaoInterface = daoFactory.getUtilisateurDaoInterface();
            
            utilisateur = utilisateurDaoInterface.loginUtilisateur(utilisateur);
            if(utilisateur != null){
                System.out.println("Auth sucess");
                tPPrincipal = new TPPrincipal(utilisateur.getNom());
                login = true;
                
            }
                    
//            int position = 0;
//
//            while(position < USERS__TEST.length){
//                if(USERS__TEST [position][0].equals(nom) && USERS__TEST[position][1].equals(password)){
//                    System.out.println("<-----------Authentification avec succés----------->");
//                    tPPrincipal = new TPPrincipal(nom);
//                    login = true;
//                    break;
//                }
//                position ++;
//            }
//            
            
        }catch(IOException | UnsupportedCallbackException ex){
            System.out.println("Erreur :" + ex);
        }
        
        return login;
    }

    @Override
    public boolean commit() throws LoginException {
        System.out.println("------------Commit après login------------");
        boolean result = false;
        if (this.subject != null && !this.subject.getPrincipals().contains(this.tPPrincipal)) {
            this.subject.getPrincipals().add(this.tPPrincipal);
            result = true;   
        }
        return result;
    }

    @Override
    public boolean abort() throws LoginException {
        System.out.println("---------------Abort login utilisateur--------------");
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        System.out.println("----------Logout Utilisateur-----------");
        subject.getPrincipals().remove(tPPrincipal);
        subject = null;
        return true;
    }
    
}
