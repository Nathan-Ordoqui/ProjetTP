/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Potion
 * @author Utilisateur
 */
public class Potion extends Objet{
    
    /**
     * Booléen indiquant si la potion est pleine
     */
    protected Boolean pleine;
    
    /**
     * Crée une potion pleine par défaut
     */
    public Potion(){
        super("Potion",new Point2D());
        this.pleine = true;
    }
    
    /**
     * Crée une potion par défaut sauf que le nom peut être précisé
     * @param s potion à copier
     */
    public Potion(String s){
        super(s,new Point2D());
        this.pleine = true;
    }
    
    /**
     * Construit une potion à partir de paramètres à donner
     * @param s
     * @param p
     */
    public Potion(String s,Point2D p){
        super(s,p);
        this.pleine = true;
    }
    
    /**
     * Constructeur de recopie de potion
     * @param p potion à copier
     */
    public Potion(Potion p){
        super(p.getNom(),p.getPos());
        this.pleine = true;
    }

    /**
     * @return the pleine
     */
    public Boolean getPleine() {
        return pleine;
    }

    /**
     * @param pleine the pleine to set
     */
    public void setPleine(Boolean pleine) {
        this.pleine = pleine;
    }

    /**
     *
     */
    public void affiche(){
            System.out.println("Soin : \n    nom : "+this.nom+"\n    pleine : "+this.pleine+
            "\n    position : "+this.pos.toString());
    }    
}
