/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe de test des exceptions
 * @author Utilisateur
 */
public class TestExceptions {
    
    /**
     *
     * @throws NumberFormatException
     */
    public static void submain() throws NumberFormatException{
        String s = "2,5";
        double x;
        System.out.println("On essaie de transformer 2,5 en double");
        x = Double.parseDouble(s);
        System.out.println("Essai réussi");
    }
        
    /**
     * Tests principaux
     */
    public static void main(){
        Personnage p;
        p = null;
        System.out.println("\nOn essaie d'afficher le personnage");
        try{
            p.affiche();
            System.out.println("Essai réussi");
        }catch(NullPointerException e){
            System.out.println("Erreur : Cet objet renvoie vers null");
        }finally{
            System.out.println("Fin de l'essai");
        }
        
        ArrayList<Personnage> t = new ArrayList();
        System.out.println("\nOn essaie d'accéder au 1er élément d'un tableau vide");
        try{
            System.out.println(t.get(0));
            System.out.println("Essai réussi");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Erreur : On a essayé d'accéder à un élément en dehors des limites du tableau");
        }finally{
            System.out.println("Fin de l'essai");
        }
        
        int i = 2;
        int j = 0;
        System.out.println("\nOn essaie de diviser 2 par 0");
        try{
            System.out.println(i/j);
            System.out.println("Essai réussi");
        }catch(ArithmeticException e){
            System.out.println("Erreur : Opérations arithmétique non autorisée");
        }finally{
            System.out.println("Fin de l'essai");
        }
        
        Guerrier g = new Guerrier();
        p = new Personnage();
        System.out.println("\nOn essaie de transformer un Personnage en Guerrier");
        try{
            g = (Guerrier) p;
            System.out.println("Essai réussi");
        }catch(ClassCastException e){
            System.out.println("Erreur : Transtypage non autorisé");
        }finally{
            System.out.println("Fin de l'essai");
        }
        
        String s = "2,5";
        double x;
        System.out.println("\nOn essaie de transformer 2,5 en double");
        try{
            x = Double.parseDouble(s);
            System.out.println("Essai réussi");
        }catch(NumberFormatException e){
            System.out.println("Erreur : Mauvais format de nombre");
        }finally{
            System.out.println("Fin de l'essai");
        }
        
        
        
        System.out.println("\nOn essaie d'éxécuter une boucle infinie");
        try{
            Infini.launch();
            System.out.println("Essai réussi");
        }catch(StackOverflowError e){
            System.out.println("Erreur : Dépassement de pile d'appels");
        }finally{
            System.out.println("Fin de l'essai");
        }
        
        t = new ArrayList<>();
        t.add(new Personnage());
        t.add(new Personnage());
        t.add(new Personnage());
        System.out.println("\nOn essaie de supprimer les éléments du tableau 1 à 1");
        try{
            for(Personnage c : t){
                t.remove(c);
            }
            System.out.println("Essai réussi");
        }catch(java.util.ConcurrentModificationException e){
            System.out.println("Erreur : Modification impossible");
        }finally{
            System.out.println("Fin de l'essai");
        }
        
        String input = new String();
        Scanner scan = new Scanner(System.in);
        Boolean b = true;
        System.out.println("Veuillez entrer un nombre décimal");

        while(b){
            try{
                input = scan.nextLine();
                x = Double.parseDouble(input);
                System.out.println("Vous avez entré : "+x);
                b = false;
            }
            catch(NumberFormatException e){
                System.out.println("Format incorrect veuillez recommencer");
            }
        }
        System.out.println("Essai terminé");

        System.out.println("\nAvec une méthode :");
        try{
            submain();
        }
        catch(NumberFormatException e){
            System.out.println("Format incorrect");
        }
        System.out.println("Essai terminé");
    }

    
}
