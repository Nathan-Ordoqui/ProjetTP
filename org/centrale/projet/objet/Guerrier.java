/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Classe Guerrier, sous-classe de Personnage
 * @author Utilisateur
 */
public class Guerrier extends Personnage{

    /**
     * Construit un Guerrier depuis une ligne de sauvegarde
     * @param ligne
     */
    public Guerrier(String ligne){
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
     * Construit un guerrier par défaut en utilisant le constructeur de personnage
     */
    public Guerrier(){
        this.ptVie = 50+RandomInteger.main(40);
        this.pos = new Point2D();
        this.distAttMax = 1;
        this.nom = "Guerrier";
        this.pourcentageAtt = 60+RandomInteger.main(20);
        this.ptPar = 5+RandomInteger.main(5);
        this.pourcentagePar = 20+RandomInteger.main(10);
        this.pourcentageResistMag = RandomInteger.main(30);
        this.degAtt = 25+RandomInteger.main(10);
        this.nList = new LinkedList();
        
        //this.Guerrier(nomv, ptV, 0, pA, pP, pcP, 0, rM, dA, 0, distMax, posit);
        
        }
    
    /**
     * Crée une copie du guerrier grâce au constructeur de recopie de Personnage
     * @param g guerrier à copier
     */
    public Guerrier(Guerrier g){
        super((Personnage) g);
    }
    
    /**
     * Construit un guerrier grâce aux entrées
     * @param nom Nom
     * @param ptV Points de vie
     * @param ptM points de mana
     * @param pA Pourcentage d'attaque
     * @param pP pooints de parade
     * @param pcP pourcentage de parade
     * @param pM Pourcentage de magie
     * @param rM Pourcentage de résistance magie
     * @param dA Dégâts d'attaque
     * @param dM Dégâts de magie
     * @param distMax Distance maximale d'attaque
     * @param pos position
     */
    public Guerrier(String nom, int ptV, int ptM, int pA, int pP,int pcP, int pM, int rM, int dA, int dM, int distMax, Point2D pos){
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
     * Combat avec une créature
     * @param c créature à combattre
     */
    public void combattre(Creature c){
        if(this.getPos().distance(c.getPos())==1){
            int r = Rand.main(100);
            System.out.println("\n"+this.nom+" attaque "+c.getSClass()+" : "+r+" / "+this.pourcentageAtt);

            if(r <= this.pourcentageAtt){
                r = Rand.main(100);
                System.out.println("Défense : "+r+" / "+c.getPourcentagePar());
                
                if(r > c.getPourcentagePar()){
                    c.setPtVie(c.getPtVie()-this.degAtt);
                    System.out.println(this.nom+" inflige "+this.degAtt+" dégâts");
                }
                else{
                    c.setPtVie(c.getPtVie()-this.degAtt + c.getPtPar());
                    System.out.println("Parade, "+this.nom+" inflige "+(this.degAtt-c.getPtPar())+" dégâts");
                }
            }
            else{
                System.out.println(this.nom+" rate son attaque");
            }
            System.out.println(c.getSClass()+" a maintenant "+Math.max(0, c.getPtVie())+" points de vie");
        }
    }
    
    /**
     * Affiche les attributs du guerrier
     */
    @Override
    public void affiche(){
    System.out.println("Guerrier : nom : "+this.nom+"\n    points de vie : "+this.ptVie+
                "\n    points de mana : "+this.ptMana+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    dégâts magiques : "+this.degMag+"\n    pourcentage magique : "+this.pourcentageMag+
                "\n    pourcentage de résistance magique : "+this.pourcentageResistMag+
                "\n    pourcentage de parade : "+this.pourcentagePar+
                "\n    distance maximale d'attaque : "+this.distAttMax+
                "\n    position : "+this.pos.toString());
    
    }

    /**
     * Génère la ligne de sauvegarde du Guerrier
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
        return "Guerrier";
    }
}
