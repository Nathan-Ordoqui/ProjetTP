/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 * Classe de potion de soin
 * @author Utilisateur
 */
public class Soin extends Potion{
    
    /**
     * Valeur de soin
     */
    protected int valSoin;

    /**
     * Construit une Potion de Soin à partir d'une ligne de sauvegarde
     * @param ligne
     */
    public Soin(String ligne){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        this.nom = "Soin";
        this.valSoin = Integer.parseInt(tokenizer.nextToken());
        this.pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
        this.pleine = true;
    }
    
    /**
     * Constructeur de potion de soin par défaut
     */
    public Soin(){
        super("Soin");
        this.valSoin = 1+RandomInteger.main(29);
    }
    
    /**
     * Constructeur de potion de soin avec valeur de soin en argument, nom est prédéfini
     * @param val
     */
    public Soin(int val){
        super("Soin");
        this.valSoin = val;
    }

    /**
     * Constructeur de recopie de la potion de soin
     * @param s potion de soin à copier
     */
    public Soin(Soin s){
        super(s.getNom());
        this.valSoin = s.getValSoin();
    }
    
    /**
     * Constructeur de potion de soin avec valeur et nom
     * @param s
     * @param val
     */
    public Soin(String s,int val){
        super(s);
        this.valSoin = val;
    }

    /**
     * @return the valSoin
     */
    public int getValSoin() {
        return valSoin;
    }

    /**
     * @param valSoin the valSoin to set
     */
    public void setValSoin(int valSoin) {
        this.valSoin = valSoin;
    }

    /**
     * Génère la ligne de sauvegarde de la Potion
     * @return
     */
    public String getTexteSauvegarde(){
        int x = (int)this.pos.getX();
        int y = (int)this.pos.getY();
        String texte = this.getSClass()+" "+this.valSoin+" "+x+" "+y;
        return texte;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getSClass(){
        return "Soin";
    }
    
    /**
     *
     */
    @Override
    public void affiche(){
            System.out.println("Soin : \n    nom : "+this.nom+"\n    pleine : "+this.pleine
            +"\n    valeur de soin : "+this.valSoin+"\n    position : "+this.pos.toString());
    }    
}
