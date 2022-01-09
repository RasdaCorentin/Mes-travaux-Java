/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.handlercallback;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *
 * @author 33767
 */
public class TPHandlerCallback implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("La methode handle est en cours d'exec ------------------------>");
        NameCallback nameCallback = (NameCallback) callbacks[0];
        System.out.println(nameCallback.getPrompt());
        InputStreamReader inputStreamReaderNom = new InputStreamReader(System.in);
        
        BufferedReader bufferedReaderNom = new BufferedReader(inputStreamReaderNom);
        
        nameCallback.setName(bufferedReaderNom.readLine());
        
        PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];
        
        System.out.println(passwordCallback.getPrompt());
        
        InputStreamReader inputStreamReaderPassword = new InputStreamReader(System.in);
        
        BufferedReader bufferedReaderPassword = new BufferedReader(inputStreamReaderPassword);
        
        passwordCallback.setPassword(bufferedReaderPassword.readLine().toCharArray());

    }
    
}
