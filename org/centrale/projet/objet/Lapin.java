/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 * Classe lapin, sous-classe de Monstre
 * @author Utilisateur
 */
public class Lapin extends Monstre{

    /**
     * Construit un Lapin à partir d'une ligne de sauvegarde
     * @param ligne
     */
    public Lapin(String ligne){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        this.ptVie = Integer.parseInt(tokenizer.nextToken());
        this.pourcentageAtt = Integer.parseInt(tokenizer.nextToken());
        this.pourcentagePar = Integer.parseInt(tokenizer.nextToken());
        this.degAtt = Integer.parseInt(tokenizer.nextToken());
        this.ptPar = Integer.parseInt(tokenizer.nextToken());
        this.pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
    }
    
    /**
     * Construit un lapin grâce aux arguments
     * @param pV points de vie
     * @param pA pourcentage d'attaque
     * @param pP pourcentage de parade
     * @param dA dégâts d'attaque
     * @param p position
     */
    public Lapin(int pV, int pA, int pP, int dA, Point2D p){
        ptVie = pV;
        pourcentageAtt = pA;
        pourcentagePar = pP;
        degAtt = dA;
        pos = new Point2D(p);
    }

    /**
     * Crée une copie d'un lapin
     * @param m lapin à copier
     */
    public Lapin(Lapin m){
        ptVie = m.getPtVie();
        pourcentageAtt = m.getPourcentageAtt();
        pourcentagePar = m.getPourcentagePar();
        degAtt = m.getDegAtt();
        pos = new Point2D(m.getPos());
    }

    /**
     * Construit un lapin par défaut
     */
    public Lapin(){

        this.ptVie = 5+RandomInteger.main(5);
        this.pos = new Point2D();
        this.pourcentageAtt = 50+RandomInteger.main(20);
        this.ptPar = RandomInteger.main(5);
        this.pourcentagePar = 20+RandomInteger.main(10);
        this.degAtt = RandomInteger.main(5);
    }
    
    /**
     * Affiche les attributs du lapin
     */
    @Override
    public void affiche(){
                System.out.println("Lapin : \n    points de vie : "+this.ptVie+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    pourcentage de parade :"+this.pourcentagePar+
                "\n    position : "+this.pos.toString());

    }

    /**
     * Génère la ligne de sauvegarde du Lapin
     * @return
     */
    public String getTexteSauvegarde(){
        int x = (int)this.pos.getX();
        int y = (int)this.pos.getY();        
        String texte = this.getSClass()+" "+this.ptVie+" "
                +this.pourcentageAtt+" "+this.pourcentagePar+" "
                +this.degAtt+" "+this.ptPar
                +" "+x+" "+y;
        return texte;
    }
    
    /**
     *
     * @return
     */
    public String getSClass(){
        return "Lapin";
    }
}
