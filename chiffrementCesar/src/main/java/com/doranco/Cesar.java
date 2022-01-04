/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco;

/**
 *
 * @author 33767
 */
public class Cesar {
    /**
     * Cette fonction chiffre un message à partir de son décalage
     * @param message
     * @param decalage
     * @return 
     */
    public String chiffrement (String message, int decalage){
        
        StringBuilder messageCrypte = new StringBuilder();
        
        for (char charactere:message.toCharArray()) {
            if(charactere != ' '){
                int positionOriginale = charactere - 'a';
                int nouvellePosition = (positionOriginale + decalage) % 26;
                char nouveauCharactere = (char) ('a' + nouvellePosition);
                
                messageCrypte.append(nouveauCharactere);
            }else messageCrypte.append(charactere);   
        }
        
        return messageCrypte.toString();
    }
    /**
     * Dechiffrement 
     * @param message
     * @param decalage
     * @return 
     */
    public String dechiffrement (String message, int decalage){
        return chiffrement(message, 26 - decalage % 26);
    }
}
