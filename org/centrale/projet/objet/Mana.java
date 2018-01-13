/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 * Classe de potion de mana
 * @author Utilisateur
 */
public class Mana extends Potion{

    /**
     * Valeur de mana de la potion
     */
    protected int valMana;

    /**
     * Construit un Potion de mana depuis une ligne de sauvegarde
     * @param ligne
     */
    public Mana(String ligne){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        this.nom = "Mana";
        this.valMana = Integer.parseInt(tokenizer.nextToken());
        this.pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
        this.pleine = true;
    }
    
    /**
     * Constructeur de potion de mana par défaut
     */
    public Mana(){
        super("Mana");
        this.valMana = 1+RandomInteger.main(29);
    }
    
    /**
     * Construit une potion avec valeur de la mana en argument, on ne peut pas spécifier le nom ici
     * @param val valeur de la mana
     */
    public Mana(int val){
        super("Mana");
        this.valMana = val;
    }

    /**
     * Crée une copie de la potion en entrée
     * @param s potion de mana à copier
     */
    public Mana(Mana s){
        super(s.getNom());
        this.valMana = s.getValMana();
    }
    
    /**
     * Construit une potion de mana avec arguments, on peut spécifier le nom ici
     * @param s
     * @param val
     */
    public Mana(String s,int val){
        super(s);
        this.valMana = val;
    }

    /**
     * @return the valMana
     */
    public int getValMana() {
        return valMana;
    }

    /**
     * @param valMana the valMana to set
     */
    public void setValMana(int valMana) {
        this.valMana = valMana;
    }

    /**
     * Génère la ligne de sauvegarde de la Potion
     * @return
     */
    public String getTexteSauvegarde(){
        int x = (int)this.pos.getX();
        int y = (int)this.pos.getY();
        String texte = this.getSClass()+" "+this.valMana+" "+x+" "+y;
        return texte;
    }
    
    /**
     *
     * @return
     */
    public String getSClass(){
        return "Mana";
    }

    /**
     *
     */
    public void affiche(){
            System.out.println("Mana : \n    nom : "+this.nom+"\n    valeur de soin : "+this.valMana+"\n    pleine : "+this.pleine+
            "\n    position : "+this.pos.toString());   
    }    
}
