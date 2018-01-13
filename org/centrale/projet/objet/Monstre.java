/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Monstre, sous-classe de Creature
 * @author Utilisateur
 */
public class Monstre extends Creature{
    
    /**
     * Construit un monstre avec arguments
     * @param pV Points de vie
     * @param pA Pourcentage d'attaque
     * @param pP points de parade
     * @param pcP pourcentage de parade
     * @param dA dégâts d'attaque
     * @param p position du monstre
     */
    public Monstre(int pV, int pA, int pP,int pcP, int dA, Point2D p){
        ptVie = pV;
        pourcentageAtt = pA;
        pourcentagePar = pcP;
        ptPar = pP;
        degAtt = dA;
        pos = new Point2D(p);
        distAttMax = 1;
    }
    
    /**
     * Crée une copie du monstre en entrée
     * @param m monstre à copier
     */
    public Monstre(Monstre m){
        ptVie = m.getPtVie();
        pourcentageAtt = m.getPourcentageAtt();
        ptPar = m.getPtPar();
        pourcentagePar = m.getPourcentagePar();
        degAtt = m.getDegAtt();
        pos = new Point2D(m.getPos());
        distAttMax = 1;
    }
    
    /**
     * Constructeur de monstre par défaut
     */
    public Monstre(){
        ptVie = 10;
        pourcentageAtt = 0;
        pourcentagePar = 0;
        degAtt = 0;
        ptPar = 0;
        pos = new Point2D();
        distAttMax = 1;
    }

    /**
     * Affiche les attributs du monstre
     */
    @Override
    public void affiche(){
        System.out.println("Monstre : \n    points de vie : "+this.ptVie+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    points de parade : "+this.ptPar+"\n    pourcentage de parade :"+this.pourcentagePar+
                "\n    position : "+this.pos.toString());
    }

    /**
     * @return the ptPar
     */
    @Override
    public int getPtPar() {
        return ptPar;
    }

    /**
     * @param ptPar the ptPar to set
     */
    @Override
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

}
