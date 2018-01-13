/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 * Classe Loup, sous-classe de Monstre
 * @author Utilisateur
 */
public class Loup extends Monstre{

    /**
     * Construit un Loup depuis une ligne de sauvegarde
     * @param ligne
     */
    public Loup(String ligne){
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
     * Construit un loup par défaut
     */
    public Loup(){
        this.ptVie = 40+RandomInteger.main(20);
        this.pos = new Point2D();
        this.pourcentageAtt = 60+RandomInteger.main(20);
        this.ptPar = RandomInteger.main(5);
        this.pourcentagePar = 20+RandomInteger.main(10);
        this.degAtt = 15+RandomInteger.main(10);
    }
    
    /**
     * Crée une copie de loup
     * @param l loup à copier
     */
    public Loup(Loup l){
        super((Monstre) l);
    }
    
    /**
     * Construit un loup avec attributs à fournir
     * @param pV points de vie
     * @param pA pourcentage d'attaque
     * @param pP pourcentage de parade
     * @param dA dégâts d'attaque
     * @param p position
     */
    public Loup(int pV, int pA, int pP, int dA, Point2D p){
        ptVie = pV;
        pourcentageAtt = pA;
        pourcentagePar = pP;
        degAtt = dA;
        pos = new Point2D(p);
    }
    
    /**
     * Combat une créature
     * @param c créature à combattre
     */
    public void combattre(Creature c){
        if(this.getPos().distance(c.getPos())==1){
            int r = Rand.main(100);
            System.out.println("\nLoup attaque "+c.getSClass()+" : "+r+" / "+this.pourcentageAtt);
            
            if(r <= this.pourcentageAtt){
                r = Rand.main(100);
                System.out.println("Défense : "+r+" / "+c.getPourcentagePar());

                if(r > c.getPourcentagePar()){
                    c.setPtVie(c.getPtVie()-this.degAtt);
                    System.out.println("Loup inflige "+this.degAtt+" dégâts");
                }
                else{
                    c.setPtVie(c.getPtVie()-this.degAtt + c.getPtPar());
                    System.out.println("Parade : Loup inflige "+(this.degAtt-c.getPtPar())+" dégâts");
                }
            }
            else{
                System.out.println("Loup rate son attaque");
            }
            System.out.println(c.getSClass()+" a maintenant "+Math.max(0, c.getPtVie())+" points de vie");
        }
    }
    
    /**
     * Affiche les attributs du lapin
     */
    @Override
    public void affiche(){
                System.out.println("Loup : \n    points de vie : "+this.ptVie+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    pourcentage de parade :"+this.pourcentagePar+
                "\n    position : "+this.pos.toString());

    }

    /**
     * Génère la ligne de sauvegarde du Loup
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
        return "Loup";
    }
    
}
