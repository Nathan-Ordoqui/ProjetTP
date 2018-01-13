/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe gérant le fonctionnement général du jeu
 * @author Kevin
 */
public class Jeu {

    /**
     * Script d'exécution du jeu
     * @throws IOException
     */
    public static void main() throws IOException{        
        
        World monde = new World();
        
        System.out.println("\nVoulez-vous jouer ? Ecrivez 'oui' ou 'non' :");
        Scanner sc5 = new Scanner(System.in);
        String choix3 = sc5.next();
        while(!(choix3.equals("oui")||(choix3.equals("non")))){
            System.out.println("Ecrivez bien 'oui' ou 'non':");
            Scanner sc6 = new Scanner(System.in);
            choix3 = sc6.next();
        }
        if (choix3.equals("oui")){
            int k = 1;
            do{
                System.out.println("\nTour n°:"+k);
                monde.tourDeJeu();
                k++;
                
                System.out.println("\nVoulez-vous continuer à jouer ? Ecrivez 'oui' ou 'non' :");
                Scanner sc3 = new Scanner(System.in);
                String choix2 = sc3.next();
                while (!(choix2.equals("oui")||choix2.equals("non"))){
                    System.out.println("Ecrivez bien 'oui' ou 'non' :");
                    Scanner sc4 = new Scanner(System.in);
                    choix2 = sc4.next();
                }
                if (choix2.equals("non")){
                    System.out.println("Vous avez choisi de ne plus jouer. Ciao!");
                    break;
                }
            }while((monde.getPlayer().getPerso().getPtVie()>0)&&(!monde.getListeC().isEmpty()));
        }
        else if(choix3.equals("non")){
            System.out.println("Vous avez choisi de ne pas jouer. Ciao!");
        }
    }
}
