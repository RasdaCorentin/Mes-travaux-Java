/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.ssl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author 33767
 */
public class ServerSSL {
    public static void main(String[] args) throws IOException {
        
        //etablir connexion
        int port = 9191;
        System.out.println("En attente d'une connexion !!!");
        
        SSLServerSocketFactory serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        
        SSLServerSocket sSLServerSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
        
        SSLSocket socket = (SSLSocket) sSLServerSocket.accept();
        
        System.out.println("Connexion d'un client");
        
        //Message 
        
         InputStream inputStream = socket.getInputStream();
            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
           
            String message = bufferedReader.readLine();
            
            System.out.println("Message du client: " + message);
            
        //Fermeture    
        socket.close();
        sSLServerSocket.close();
        
    }
}
