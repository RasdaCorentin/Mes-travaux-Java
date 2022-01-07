package com.doranco;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 33767
 */
public class Main {
    public static void main(String[] args) {
        Cesar cesar = new Cesar();
        String messageChiffre = cesar.chiffrement("william est malade", 3);
        System.out.println(messageChiffre);
        
        System.out.println("");
        
        String messageClair = cesar.dechiffrement(messageChiffre, 3);
        
        System.out.println(messageClair);
        
        
              
   }
}
