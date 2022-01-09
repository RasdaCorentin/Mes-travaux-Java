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
        int port = 9191;
        String host = "localhost";
        
        try {
         //Connexion   
        SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
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
