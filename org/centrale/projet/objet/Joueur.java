/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Classe représentant le joueur et son personnage
 * @author Kevin
 */
public class Joueur {
    private Personnage perso;

    /**
     * Construit un Joueur depuis la ligne de sauvegarde
     * @param ligne
     */
    public Joueur(String ligne){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        String classePerso = tokenizer.nextToken();
        String lignebis = classePerso;
        while (tokenizer.hasMoreTokens()){
            lignebis += " "+tokenizer.nextToken();
        }
        switch(classePerso){
            case "Guerrier":
                Guerrier g = new Guerrier(lignebis);
                this.perso= (Personnage)g;
                break;
            case "Archer":
                Archer a = new Archer(lignebis);
                this.perso = (Personnage)a;
                break;
            case "Paysan":
                Paysan pay = new Paysan(lignebis);
                this.perso = (Personnage)pay;
                break;
            case "Mage":
                Mage m = new Mage(lignebis);
                this.perso = (Personnage)m;
                break;
            default :
                System.out.println("Donner un vrai nom de classe au personnage");
        }
    }        
    
    /**
     * Construit le Joueur par défaut
     */
    public Joueur(){
        this.perso = new Personnage();
    }
    
    /**
     * Construit le Joueur à partir d'un Personnage donné
     * @param perso
     */
    public Joueur(Personnage perso){
        this.perso = perso;
    }
    
    /**
     * Constructeur de recopie
     * @param j
     */
    public Joueur(Joueur j){
        this.perso = new Personnage(j.getPerso());
    }
    
    /**
     * Permet au joueur de créer son personnage
     */
    public void choixPerso(){
        //Personnage perso = new Personnage();
        
        System.out.println("Veuillez saisir le type de personnage choisi pour le joueur ('Archer', 'Guerrier', 'Paysan' ou 'Mage') :");
        Scanner sc1 = new Scanner(System.in);
        String choix = sc1.nextLine();
        
        System.out.println("Veuillez entrer le nom du joueur :");
        Scanner sc2 = new Scanner(System.in);
        String nom = sc2.nextLine();

        /*
         * Constructeur de Personnage avec arguments
         * @param nom Nom
         * @param ptV Points de vie
         * @param ptM Poitns de magie
         * @param pA Pourcentage d'attaque
         * @param pP Points de parade
         * @param pcP pourcentage de parade
         * @param pM pourcentage de magie
         * @param rM résistance magie
         * @param dA dégâts d'attaque
         * @param dM dégâts de magie
         * @param distMax distance maximale d'attaque
         * @param pos position
         */        
        int ptV = 100;
        //Point2D pos = new Point2D(RandomInteger.main(50), RandomInteger.main(50));
        Point2D pos = new Point2D();
        int distMax = 1;
        
        int pA;
        int pP;
        int pcP;
        int rM;
        int dA;
        
        switch(choix){
            case "Guerrier":
                
                pA = 5+RandomInteger.main(5);
                pP = 5+RandomInteger.main(5);
                pcP = 50+RandomInteger.main(50);
                rM = RandomInteger.main(30);
                dA = 25+RandomInteger.main(25);
                
                Guerrier g = new Guerrier(nom, ptV, 0, pA, pP, pcP, 0, rM, dA, 0, distMax, pos);
                this.perso=(Personnage) g;
                break;
            case "Archer":
                
                pA = 50+RandomInteger.main(40);
                pP = 1+RandomInteger.main(9);
                pcP = RandomInteger.main(50);
                rM = RandomInteger.main(30);
                dA = 20+RandomInteger.main(30);
                distMax = 5;
                
                int nbF = RandomInteger.main(30);
                Archer a = new Archer(nom, ptV, 0, pA, pP, pcP, 0, rM, dA, 0, distMax, pos, nbF);
                this.perso=(Personnage) a;
                break;
            case "Mage":
            
                pA = RandomInteger.main(3);
                pP = RandomInteger.main(3);
                pcP = RandomInteger.main(30);
                rM = RandomInteger.main(100);
                dA = RandomInteger.main(10);
                
                int ptM = RandomInteger.main(10);
                int pM = RandomInteger.main(100);
                int dM = RandomInteger.main(50);
                Mage m = new Mage(nom, ptV, ptM, pA, pP, pcP, pM, rM, dA, dM, distMax, pos);
                this.perso=(Personnage) m;
                break;
            case "Paysan":
                
                pA = RandomInteger.main(3);
                pP = RandomInteger.main(3);
                pcP = RandomInteger.main(30);
                rM = RandomInteger.main(30);
                dA = RandomInteger.main(10);

                Paysan pay = new Paysan(nom, ptV, 0, pA, pP, pcP, 0, rM, dA, 0, distMax, pos);
                this.perso= (Personnage) pay;
                break;
            default:
                
                pA = 5+RandomInteger.main(5);
                pP = 5+RandomInteger.main(5);
                pcP = 50+RandomInteger.main(50);
                rM = RandomInteger.main(30);
                dA = 25+RandomInteger.main(25);
                
                Guerrier perso = new Guerrier(nom, ptV, 0, pA, pP, pcP, 0, rM, dA, 0, distMax, pos);
                this.perso = perso;
                break;
        
        }
    }
    
    /**
     * Déplace le joueur sur une position valide
     * @param w
     */
    public void deplaceJoueur(World w){
        System.out.println("Veuillez déplacer votre personnage (aze q d wxc) :");
        Scanner scx = new Scanner(System.in);
        Point2D p = new Point2D(-1,-1);
        Boolean b = true;
        String input = new String();
        int x = 0;
        int y = 0;
        while(b){
            input = scx.next();
            if(input.equals("z")||input.equals("q")||input.equals("x")||input.equals("d")||input.equals("a")||input.equals("e")||input.equals("w")||input.equals("c")){
                switch(input){
                    case "z" : 
                        x = 0;
                        y = -1;
                        break;
                    case "q" : 
                        x = -1;
                        y = 0;
                        break;
                    case "x" : 
                        x = 0;
                        y = 1;
                        break;
                    case "d" : 
                        x = 1;
                        y = 0;
                        break;
                    case "a" : 
                        x = -1;
                        y = -1;
                        break;
                    case "e" : 
                        x = 1;
                        y = -1;
                        break;
                    case "w" : 
                        x = -1;
                        y = 1;
                        break;
                    case "c" : 
                        x = 1;
                        y = 1;
                        break;
                }
               
                Point2D position = new Point2D(this.perso.getPos());
                position.translate(y, x);
                if(w.disponible(position)){
                    this.perso.setPos(position);
                    b = false;
                }
                else{
                    System.out.println("Déplacement impossible, recommencer"+this.perso.getPos().toString()+position.toString());
                }
            }
            else{
                    System.out.println("Déplacement incorrect, recommencer");   
                        }
        }
    }
    
    /**
     *
     * @return
     */
    public String getTexteSauvegarde(){
        String texte = "Joueur "+this.perso.getTexteSauvegarde();
        return texte;
    }
    
    /**
     *
     * @param c
     */
    public void combatJoueur(Creature c){
        
        this.perso.combattre(c);
    }
    
    /**
     * @return the perso
     */
    public Personnage getPerso() {
        return perso;
    }

    /**
     * @param perso the perso to set
     */
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    
    
}
