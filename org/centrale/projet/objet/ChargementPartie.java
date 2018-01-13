/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Classe gérant les chargements de parties
 * @author Kevin
 */
public class ChargementPartie {

    /**
     * Nom du fichier de sauvegarde
     */
    public String source;

    /**
     * Reader adapté
     */
    public BufferedReader bR;
    
    /**
     * Ouvre le fichier de sauvegarde
     * @param source
     */
    public ChargementPartie(String source){              
        try {
          this.source = source ;
          this.bR = new BufferedReader(new FileReader(source));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Fichier non trouvé");
        }
    }
    
    /**
     * Crée le monde enregistré dans la sauvegarde
     * @return Monde
     * @throws IOException
     */
    public World chargerPartie() throws IOException{
        
        String ligne = this.bR.readLine();
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        int largeur = Integer.parseInt(tokenizer.nextToken());
        
        ligne = this.bR.readLine();
        tokenizer = new StringTokenizer(ligne, delimiteur);
        inutile = tokenizer.nextToken();
        int hauteur = Integer.parseInt(tokenizer.nextToken());
        
        LinkedList<Creature> listeC = new LinkedList<>();
        LinkedList<Objet> listeO = new LinkedList<>();
        Joueur player = new Joueur();

        ligne = this.bR.readLine();
        while (ligne != null) {
            String copieligne = new String(ligne);
            tokenizer = new StringTokenizer(copieligne, delimiteur);
            String nomClasse = tokenizer.nextToken();
            switch (nomClasse){
                case "Guerrier":
                    Guerrier g = new Guerrier(ligne);
                    listeC.push(g);
                    break;
                case "Archer":
                    Archer a = new Archer(ligne);
                    listeC.push(a);
                    break;
                case "Paysan":
                    Paysan pay = new Paysan(ligne);
                    listeC.push(pay);
                    break;
                case "Mage":
                    Mage m = new Mage(ligne);
                    listeC.push(m);
                    break;
                case "Loup":
                    Loup lo = new Loup(ligne);
                    listeC.push(lo);
                    break;
                case "Lapin":
                    Lapin la = new Lapin(ligne);
                    listeC.push(la);
                    break;
                case "Soin":
                    Soin s = new Soin(ligne);
                    listeO.push(s);
                    break;
                case "Mana":
                    Mana mana = new Mana(ligne);
                    listeO.push(mana);
                    break;
                case "NuageToxique":
                    NuageToxique nt = new NuageToxique(ligne);
                    listeO.push(nt);
                    break;
                case "Nourriture":
                    Nourriture no = new Nourriture(ligne);
                    listeO.push(no);
                    break;
                case "Joueur":
                    player = new Joueur(ligne);
                    break;
                default :
                    System.out.println("La classe proposée n'existe pas (Voleur par exemple). Nous créons donc un guerrier.");
                    Guerrier gtemp = new Guerrier(ligne);
                    listeC.push(gtemp);
                    break;
            }
            ligne = this.bR.readLine();
        }
        World monde = new World(hauteur, largeur, player, listeC, listeO);
        this.bR.close();
        return monde;
    }
    
    /**
     * @return the source
     */
    public String getSource(){
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the bR
     */
    public BufferedReader getbR() {
        return bR;
    }

    /**
     * @param bR the bR to set
     */
    public void setbR(BufferedReader bR) {
        this.bR = bR;
    }
    
}
