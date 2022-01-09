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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 33767
 */
public class Client {
    public static void main(String[] args) {
        int port = 9292;
        String host = "localhost";
        
        try{
            Socket socket = new Socket(host, port);
            OutputStream out = socket.getOutputStream();
            
            PrintWriter printWriter = new PrintWriter(out);
            printWriter.println("Salutation");
            printWriter.flush();
            
            InputStream inputStream = socket.getInputStream();
            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
           
            String message = bufferedReader.readLine();
            
            System.out.println("Message du client: " + message);
            
        }catch ( IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}
