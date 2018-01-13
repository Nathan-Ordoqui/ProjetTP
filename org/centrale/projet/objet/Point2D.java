/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Point2D
 * @author Utilisateur
 */
public class Point2D {
    /**
     * Abscisse
     */
    protected double x;
    
    /**
    * Ordonnée
    */
    protected double y;
    
    /**
     * Cosntructeur par défaut à l'origine
     */
    public Point2D(){
        x = 0;
        y = 0;
    }
    
    /**
     * Cosntructeur avec entrées réels
     * @param a abscisse
     * @param b ordonnée
     */
    public Point2D(double a, double b){
        x = a;
        y = b;
    }
    
    /**
     * Constructeur de recopie
     * @param p point à recopier
     */
    public Point2D(Point2D p){
        x = p.getX();
        y = p.getY();
    }
    
    /**
     * Vérifie l'égalité de position entre deux points
     * @param p point à vérifier avec l'obje courant
     * @return booléen indiquant égalité ou non
     */
    public Boolean equals(Point2D p){
        return ((this.x == p.getX())&&(this.y == p.getY()));
    }
    
    /**
     *
     * @return x abscisse
     */
    public double getX(){
        return x;
    }

    /**
     *
     * @param a
     */
    public void setX(double a){
        x = a;
    }
    
    /**
     *
     * @return y ordonnée
     */
    public double getY(){
        return y;
    }

    /**
     *
     * @param b
     */
    public void setY(double b){
        y = b;
    }
    
    /**
     * Affiche les coordonées du point
     */
    public void affiche(){
        System.out.println("["+x+" ; "+y+" ]");
    }
    
    @Override
    public String toString(){
        return "["+x+" ; "+y+" ]";
    }
    
    /**
     * Translate un point
     * @param a horizontalement
     * @param b verticalement
     */
    public void translate(double a, double b){
        x += a;
        y += b;
    }
    
    /**
     *
     * @param p
     */
    public void translate(Point2D p){
        x += p.getX();
        y += p.getY();
    }
    
    /**
     * Modifie la position
     * @param a abscisse
     * @param b ordonnée
     */
    public void setPosition(double a, double b){
        x = a;
        y = b;
    }
    
    /**
     * Calcule la distance entre deux points
     * @param p point
     * @return distance
     */
    public double distance(Point2D p){
        return Math.sqrt((this.getX()-p.getX())*(this.getX()-p.getX())+(this.getY()-p.getY())*(this.getY()-p.getY()));
    }
    
    /**
     * Vérifie que le point est sur le plateau
     * @param l
     * @return booléen
     */
    public Boolean inMap(int h, int l){
        return (this.x<l) && (this.x>=0) && (this.y<h) && (this.y>=0);
    }
    
    /**
     *
     * @param pi
     * @return
     */
    public static Point2D newPos(Point2D pi){
        Point2D p = new Point2D(pi);
        int m = RandomInteger.main(8);
        switch(m) {
            case 0 : p.translate(1, 0);
            break;
            case 1 : p.translate(1, 1);
            break;
            case 2 : p.translate(0, 1);
            break;
            case 3 : p.translate(-1, 1);
            break;
            case 4 : p.translate(-1, 0);
            break;
            case 5 : p.translate(-1, -1);
            break;
            case 6 : p.translate(0, -1);
            break;
            case 7 : p.translate(1, -1);
            break;
        }
        return p;
    }

    /**
     * Retourne une nouvelle position aléatoire
     * @param h
     * @param l
     * @return Point2D
     */
    public static Point2D newPos(int h, int l){
        Point2D p = new Point2D(RandomInteger.main(l),RandomInteger.main(h));
        return p;
    }
}
