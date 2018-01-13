/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe gérant les sauvegades
 * @author Kevin
 */
public class SauvegardePartie {
    
    /**
     *
     */
    public String filename;

    /**
     *
     */
    public BufferedWriter bw;
    
    /**
     * Construit une sauvegarde avec un nom donné
     * @param filename
     */
    public SauvegardePartie(String filename){
        File f  = new File(filename);
        if(f.exists()){
            String choix = "";
            while (!(choix.equals("oui")||choix.equals("non"))){
                System.out.println("Attention le fichier existe déjà, voulez-vous l'écraser? Ecrivez 'oui' ou 'non' :" );
                Scanner sc1 = new Scanner(System.in);
                choix = sc1.next();
                if (choix.equals("non")){
                    System.out.println("Donnez un nouveau nom de fichier de sauvegarde (en n'oubliant pas le '.txt'):" );
                    Scanner sc2 = new Scanner(System.in);
                    filename = sc2.next();
                    File f2 = new File(filename);
                    while (f2.exists()){
                        System.out.println("Ce fichier existe déjà, donnez un autre nom (en n'oubliant pas le .txt)");
                        Scanner sc3 = new Scanner(System.in);
                        filename = sc3.next();
                        f2 = new File(filename);
                    }
                }           
            }
        }
        this.filename = filename;
        try {
            this.bw = new BufferedWriter(new FileWriter(filename));
        }
        catch (FileNotFoundException ex1){
            ex1.printStackTrace();
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
        }
    }
    
    /**
     * Construit une sauvegarde automatique
     */
    public SauvegardePartie(){
        int k = 0;
        String nom = "sauvegarde"+Integer.toString(k)+".txt";
        File f = new File(nom);
        while (f.exists()){
            k++;
            nom = "sauvegarde"+Integer.toString(k)+".txt";
            f = new File(nom);
        }
        this.filename = nom;
        try {
            this.bw = new BufferedWriter(new FileWriter(nom));
        }
        catch (FileNotFoundException ex1){
            ex1.printStackTrace();
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
        }
    }
    
    /**
     * Sauvegarde un Monde
     * @param monde
     */
    public void sauvegarderPartie(World monde){

        try {
            // On ecrit dans le fichier
            this.bw.write("Largeur "+monde.getLargeur());
            this.bw.newLine();

            this.bw.write("Hauteur "+monde.getHauteur());
            this.bw.newLine();

            LinkedList<Creature> lC = monde.getListeC();
            LinkedList<Objet> lO = monde.getListeO();            
            
            for(Creature c : lC){
                String texteCreature = c.getTexteSauvegarde();
                this.bw.write(texteCreature);
                this.bw.newLine();
            }
                       
            for(Objet o : lO){
                String texteObjet = o.getTexteSauvegarde();
                this.bw.write(texteObjet);                
                this.bw.newLine();
            }
            
            String texteJoueur = monde.player.getTexteSauvegarde();
            this.bw.write(texteJoueur);
        }
        // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // on ferme le fichier
        finally {
          try {
                // je force l'écriture dans le fichier
                this.bw.flush();
                // puis je le ferme
                this.bw.close();
          }
          // on attrape l'exception potentielle 
          catch (IOException ex) {
                ex.printStackTrace();
          }
        }
    }
    
    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the bw
     */
    public BufferedWriter getBw() {
        return bw;
    }

    /**
     * @param bw the bw to set
     */
    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }
}
