/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Classe mage, sous-classe de Personnage
 * @author Utilisateur
 */
public class Mage extends Personnage{

    /**
     * Construit un Mage à partir d'une ligne de sauvegarde
     * @param ligne
     */
    public Mage(String ligne){
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
        this.pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
    }

    /**
     * Construit un mage par dégaut
     */
    public Mage(){
        this.ptVie = 50+RandomInteger.main(40);
        this.pos = new Point2D();
        this.distAttMax = 3;
        this.nom = "Mage";
        this.pourcentageMag = 60+RandomInteger.main(20);
        this.ptPar = 5+RandomInteger.main(5);
        this.pourcentagePar = +RandomInteger.main(10);
        this.pourcentageResistMag = 10+RandomInteger.main(30);
        this.degMag = 35+RandomInteger.main(10);
        this.ptMana = 50+RandomInteger.main(40);
    }
    
    /**
     * Crée une copie de mage
     * @param m mage à copier
     */
    public Mage(Mage m){
        super((Personnage) m);
    }
    
    /**
     * Construit un amge avec paramètres à fournir en entrée
     * @param nom Nom
     * @param ptV points de vie
     * @param ptM points de mana
     * @param pA pourcentage d'attaque
     * @param pP points de parade
     * @param pcP pourcentage de parade
     * @param pM pourcentage de magie
     * @param rM pourcentage de résistance à magie
     * @param dA dégâts d'attaque
     * @param dM dégâts e magie
     * @param distMax distance maximale d'attaque
     * @param pos position
     */
    public Mage(String nom, int ptV, int ptM, int pA, int pP,int pcP, int pM, int rM, int dA, int dM, int distMax, Point2D pos){
        this.nom = nom;
        this.ptVie = ptV;
        this.ptMana = ptM;
        this.pourcentageAtt = pA;
        this.pourcentagePar = pcP;
        this.ptPar = pP;
        this.pourcentageMag = pM;
        this.pourcentageResistMag = rM;
        this.degAtt = dA;
        this.degMag = dM;
        this.distAttMax = distMax;
        this.pos = pos;
        this.nList = new LinkedList();
    }
    
    /**
     * Combat une créature
     * @param c créature à combattre
     */
    public void combattre(Creature c){
        if((this.ptMana>0)&&(this.getPos().distance(c.getPos())<this.distAttMax)&&(this.getPos().distance(c.getPos())>1)){
            this.ptMana -= 1;
            int r = Rand.main(100);
            System.out.println("\n"+this.nom+" attaque "+c.getSClass()+" : "+r+" / "+this.pourcentageMag);

            if(r <= this.pourcentageMag){
                c.setPtVie(c.getPtVie()-this.degMag);
                System.out.println(this.nom+" inflige "+this.degMag+" dégâts");
            }
            else{
                System.out.println(this.nom+" rate son attaque");
            }
            System.out.println(c.getSClass()+" a maintenant "+Math.max(0, c.getPtVie())+" points de vie");
        }

    }
    /**
     * Affiche les attributs du mage
     */
    @Override
    public void affiche(){
        System.out.println("Mage : nom : "+this.nom+"\n    points de vie : "+this.ptVie+
                "\n    points de mana : "+this.ptMana+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    dégâts magiques : "+this.degMag+"\n    pourcentage magique : "+this.pourcentageMag+
                "\n    pourcentage de résistance magique : "+this.pourcentageResistMag+
                "\n    pourcentage de parade : "+this.pourcentagePar+
                "\n    distance maximale d'attaque : "+this.distAttMax+
                "\n    position : "+this.pos.toString());
    }

    /**
     * Génère la ligne de sauvegarde du Mage
     * @return
     */
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
        return "Mage";
    }
}
