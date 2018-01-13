/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Creature
 * @author Utilisateur
 */
public class Creature {

    /**
     * Points de vie
     */
    protected int ptVie;

    /**
     * Pourcentage d'attaque
     */
    protected int pourcentageAtt;

    /**
     * Pourcentage de parade
     */
    protected int pourcentagePar;

    /**
     * Points de parade
     */
    protected int ptPar;

    /**
     * Dégâts d'attaque
     */
    protected int degAtt;
    
    /**
     *
     */
    protected int distAttMax;

    /**
     * Positin
     */
    protected Point2D pos;

    /**
     * Construit une créature avec les entrées suivantes
     * @param pV points de vie
     * @param pA points d'attaque
     * @param pP points de parade
     * @param pcP pourcentage de parade
     * @param dA dégâts d'attaque
     * @param position
     */
    public Creature(int pV, int pA, int pP, int pcP, int dA, Point2D position){
        ptVie = pV;
        pourcentageAtt = pA;
        ptPar = pP;
        pourcentagePar = pcP;
        degAtt = dA;
        pos = new Point2D(position);
        distAttMax = 1;
    }
    
    /**
     * Crée une copie d'une créature 
     * @param m créature à copier
     */
    public Creature(Creature m){
        ptVie = m.getPtVie();
        pourcentageAtt = m.getPourcentageAtt();
        ptPar = m.getPtPar();
        pourcentagePar = m.getPourcentagePar();
        degAtt = m.getDegAtt();
        pos = new Point2D(m.getPos());
        distAttMax = 1;
    }
    
    /**
     * Construit une créature par défaut
     */
    public Creature(){
        ptVie = 0;
        pourcentageAtt = 0;
        ptPar = 0;
        pourcentagePar = 0;
        degAtt = 0;
        pos = new Point2D();
        distAttMax = 1;
    }
    
    /**
     * @return the ptVie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * @param ptVie the ptVie to set
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * @return the pourcentageAtt
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     * @param pourcentageAtt the pourcentageAtt to set
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     * @return the degAtt
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * @param degAtt the degAtt to set
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
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
        this.pos = new Point2D(pos);
    }
    
    /**
     * Affiche les attributs de la créature
     */
    public void affiche(){
        System.out.println("Creature : \n   points de vie : "+this.ptVie+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    pourcentage parade : "+this.pourcentagePar+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    position : "+this.pos.toString());
    }
    
    /**
     * Déplace la créature dans une position aléatoire adjacente à sa position précédente
     */
    public void deplace(){
        int n = RandomInteger.main(8);
        switch(n) {
            case 0 : this.pos.translate(1, 0);
            break;
            case 1 : this.pos.translate(1, 1);
            break;
            case 2 : this.pos.translate(0, 1);
            break;
            case 3 : this.pos.translate(-1, 1);
            break;
            case 4 : this.pos.translate(-1, 0);
            break;
            case 5 : this.pos.translate(-1, -1);
            break;
            case 6 : this.pos.translate(0, -1);
            break;
            case 7 : this.pos.translate(1, -1);
            break;
        } 
    }
    
    /**
     *
     * @param c
     */
    public void combattre(Creature c){
        
    }

    /**
     * @return the pourcentagePar
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     * @param pourcentagePar the pourcentagePar to set
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     * @return the ptPar
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * @param ptPar the ptPar to set
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }
    
    /**
     *
     * @return
     */
    public String getSClass(){
        return "Creature";
    }
    
    /**
     *
     */
    public void vieillit(){
        
    }
    
    /**
     *
     * @return
     */
    public String getTexteSauvegarde() {
        return "Ceci est une créature";
    }

    /**
     * @return the distAttMax
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * @param distAttMax the distAttMax to set
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
}
