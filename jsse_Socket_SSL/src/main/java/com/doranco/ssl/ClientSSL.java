/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.ssl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author 33767
 */
public class ClientSSL {
    public static void main(String[] args) {
        int port = 9090;
        String host = "localhost";
        SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.setProperty("javax.net.ssl.trustStore", "trustkeystore.jts");
        
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        
        try {
         //Connexion   

        SSLSocket socket = (SSLSocket) socketFactory.createSocket(host, port);
        
        //Message
        OutputStream out = socket.getOutputStream();
            
            PrintWriter printWriter = new PrintWriter(out);
            printWriter.println("Salutation");
            printWriter.flush();
        //Fermeture
        socket.close();      
        } catch (IOException ex) { 
            Logger.getLogger(ClientSSL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
