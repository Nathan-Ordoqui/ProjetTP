/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Objet
 * @author Utilisateur
 */
public class Objet {

    /**
     * Nom
     */
    protected String nom;

    /**
     * Position
     */
    protected Point2D pos;

    /**
     * Cosntructeur d'objet par défaut
     */
    public Objet(){
        this.nom = "Objet";
        this.pos = new Point2D();
    }
    
    /**
     * Constructeur d'objet avec entrées
     * @param s nom de l'objet
     * @param p position
     */
    public Objet(String s,Point2D p){
        this.nom = s;
        this.pos = new Point2D(p);
    }
    
    /**
     * Crée une copie d'un objet
     * @param o objet à copier
     */
    public Objet(Objet o){
        this.nom = o.getNom();
        this.pos = new Point2D(o.getPos());
    }
    
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the pos
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     *
     * @return
     */
    public String getSClass(){
        return "Objet";
    }

    /**
     *
     * @return
     */
    public String getTexteSauvegarde(){
        return "Ceci est un objet";
    }    
    
    /**
     *
     */
    public void affiche(){
            System.out.println("Soin : \n    nom : "+this.nom+
            "\n    position : "+this.pos.toString());
    }    
}
