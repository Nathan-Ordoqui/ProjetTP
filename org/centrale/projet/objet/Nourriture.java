/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 * Classe stockant les informations d'une unité de nourriture
 * @author Kevin
 */
public class Nourriture extends Objet{

    /**
     *
     */
    public int duree;

    /**
     *
     */
    public int bonus;

    /**
     *
     */
    public int malus;
    
    /**
     *
     */
    protected Boolean b_m;

    /**
     * Construit une Nourriture à partir d'une ligne de sauvegarde
     * @param ligne
     */
    public Nourriture(String ligne){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        this.nom = "Nourriture";
        this.duree = Integer.parseInt(tokenizer.nextToken());
        this.bonus = Integer.parseInt(tokenizer.nextToken());
        this.malus = Integer.parseInt(tokenizer.nextToken());
        this.pos =new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
        this.b_m = Rand.rand_bool();
    }
    
    /**
     *
     */
    public Nourriture(){
        super("Nourriture", new Point2D());
        this.duree = 1+RandomInteger.main(9);
        this.bonus = 1+RandomInteger.main(9);
        this.malus = 1+RandomInteger.main(9);
        this.b_m = Rand.rand_bool();
    }
    
    /**
     *
     * @param nom
     * @param duree
     * @param b
     * @param m
     * @param pos
     */
    public Nourriture(String nom, int duree, int b, int m, Point2D pos){
        super(nom, new Point2D(pos));
        this.duree = duree;
        this.bonus = b;
        this.malus = m;
        this.b_m = Rand.rand_bool();
    }
    
    /**
     *
     * @param n
     */
    public Nourriture(Nourriture n){
        super(n);
        this.duree = n.getDuree();
        this.bonus = n.getBonus();
        this.malus = n.getMalus();
        this.b_m = n.getB_m();
    }

    /**
     * Génère la ligne de sauvegarde de la Nourriture
     * @return
     */
    @Override
    public String getTexteSauvegarde(){
        int x = (int)this.pos.getX();
        int y = (int)this.pos.getY();
        String texte = this.getSClass()+" "+this.duree+" "+this.bonus+" "+this.malus+" "+x+" "+y;
        return texte;
    }
    
    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the malus
     */
    public int getMalus() {
        return malus;
    }

    /**
     * @param malus the malus to set
     */
    public void setMalus(int malus) {
        this.malus = malus;
    }
    
    /**
     *
     * @return
     */
    public String getSClass(){
        return "Nourriture";
    }
    
    /**
     *
     */
    public void affiche(){
            System.out.println("Nourriture : \n    nom : "+this.nom
                    +"\n    durée : "+this.duree+"\n    bonus : "
                    +this.bonus+"\n    malus : "+this.malus+
                    "\n    position : "+this.pos.toString());   
    }        

    /**
     * @return the b_m
     */
    public Boolean getB_m() {
        return b_m;
    }

    /**
     * @param b_m the b_m to set
     */
    public void setB_m(Boolean b_m) {
        this.b_m = b_m;
    }
}
