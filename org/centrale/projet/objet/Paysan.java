/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Classe Paysan, sous-classe de Personnage
 * @author Utilisateur
 */
public class Paysan extends Personnage{

    /**
     * Construit un Paysan à partir d'une ligne de sauvegarde
     * @param ligne
     */
    public Paysan(String ligne){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        this.nom = tokenizer.nextToken();
        this.ptVie = Integer.parseInt(tokenizer.nextToken());
        this.ptMana = Integer.parseInt(tokenizer.nextToken());
        this.pourcentageAtt = Integer.parseInt(tokenizer.nextToken());
        this.pourcentagePar = Integer.parseInt(tokenizer.nextToken());
        this.pourcentageMag = Integer.parseInt(tokenizer.nextToken());
        this.pourcentageResistMag = Integer.parseInt(tokenizer.nextToken());
        this.degAtt = Integer.parseInt(tokenizer.nextToken());
        this.degMag = Integer.parseInt(tokenizer.nextToken());
        this.distAttMax = Integer.parseInt(tokenizer.nextToken());
        this.ptPar = Integer.parseInt(tokenizer.nextToken());
        this.pos = new Point2D(Double.parseDouble(tokenizer.nextToken()),Double.parseDouble(tokenizer.nextToken()));
    }
        
    
    /**
     * Constructeur du paysan
     * @param nom Nom
     * @param ptV
     * @param pA pourcentage d'attaque
     * @param pP points de parade
     * @param ptM
     * @param pcP pourcentage de parade
     * @param pM pourcentage de mana
     * @param rM résistance à la magie
     * @param dA dégâts d'attaque
     * @param dM dégâts de magie
     * @param distMax distance maximale d'attaque
     * @param pos position
     */
    public Paysan(String nom, int ptV,int pA, int ptM, int pP, int pcP, int pM, int rM, int dA, int dM, int distMax, Point2D pos){
       this.nom = nom; 
       this.ptVie = ptV; 
       this.ptMana = ptM;
       this.pourcentageAtt = pA;
       this.ptPar = pP;
       this.pourcentagePar = pcP;
       this.pourcentageMag = ptM;
       this.pourcentageResistMag = rM;
       
       this.degAtt = dA;
       this.degMag = dM;
       this.distAttMax = distMax;
       this.pos = new Point2D(pos);
       this.nList = new LinkedList();
    }
    
    /**
     * Crée une copie du paysan
     * @param p
     */
    public Paysan(Paysan p){
        super((Personnage) p);
    }
    
    /**
     * Constructeur par défaut du paysan
     */
    public Paysan(){
        this.ptVie = 50+RandomInteger.main(40);
        this.pos = new Point2D();
        this.distAttMax = 1;
        this.pourcentageAtt = 70;
        this.degAtt = 1;
        this.nom = "Paysan";
        this.pourcentageMag = 0;
        this.ptPar = 5+RandomInteger.main(5);
        this.pourcentagePar = +RandomInteger.main(10);
        this.pourcentageResistMag = 10+RandomInteger.main(30);
        this.degMag = 0;
        this.ptMana = 50+RandomInteger.main(40);
    }
    
    /**
     * Affiche les attributs d'un paysan
     */
    @Override
    public void affiche(){
        System.out.println("Paysan : nom : "+this.nom+"\n    points de vie : "+this.ptVie+
                "\n    points de mana : "+this.ptMana+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    dégâts magiques : "+this.degMag+"\n    pourcentage magique : "+this.pourcentageMag+
                "\n    pourcentage de résistance magique : "+this.pourcentageResistMag+
                "\n    pourcentage de parade : "+this.pourcentagePar+
                "\n    distance maximale d'attaque : "+this.distAttMax+
                "\n    position : "+this.pos.toString());
        
    }

    /**
     * Génère la ligne de sauvegarde du Paysan
     * @return
     */
    @Override
    public String getTexteSauvegarde(){
        int x = (int)this.pos.getX();
        int y = (int)this.pos.getY();
        String texte = this.getSClass()+" "+this.nom
                +" "+this.ptVie+" "+this.ptMana+" "
                +this.pourcentageAtt+" "+this.pourcentagePar+" "+
                this.pourcentageMag+" "+this.pourcentageResistMag+
                " "+this.degAtt+" "+this.degMag+" "+this.distAttMax+" "+this.ptPar
                +" "+x+" "+y;
        return texte;
    }    
    
    /**
     *
     * @return
     */
    public String getSClass(){
        return "Paysan";
    }
}
