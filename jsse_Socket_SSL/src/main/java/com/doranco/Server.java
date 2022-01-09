/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 33767
 */
public class Server {
    public static void main(String[] args) {
        int port = 9292;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("En attente d'une connexion !!!");
            
            Socket socket = serverSocket.accept();
            System.out.println("Connexion d'un client"); 
            
            InputStream inputStream = socket.getInputStream();
            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
           
            String message = bufferedReader.readLine();
            
            System.out.println("Message du client: " + message);
            
            OutputStream outputStream = socket.getOutputStream();
            
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("Message du Serveur");
            printWriter.flush();
            
       }catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null, ex);
       }
    }
}
