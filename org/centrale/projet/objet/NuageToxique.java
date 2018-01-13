/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 * Classe représentant l'élément nuage toxique
 * @author Kevin
 */
public class NuageToxique extends Objet{

    /**
     *
     */
    public int pourcentageAtt;

    /**
     *
     */
    public int pourcentagePar;

    /**
     *
     */
    public int degAtt;

    /**
     *
     */
    public int ptPar;

    /**
     * Construit un NuageToxique à partir d'une ligne de sauvegarde
     * @param ligne
     */
    public NuageToxique(String ligne){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        String inutile = tokenizer.nextToken();
        this.nom = "Nuage Toxique";
        this.pourcentageAtt = Integer.parseInt(tokenizer.nextToken());
        this.pourcentagePar = Integer.parseInt(tokenizer.nextToken());
        this.degAtt = Integer.parseInt(tokenizer.nextToken());
        this.ptPar = Integer.parseInt(tokenizer.nextToken());
        this.pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
    }    
    
    /**
     *
     */
    public NuageToxique(){
        super("Nuage Toxique", new Point2D());
        this.pourcentageAtt = 60+RandomInteger.main(20);
        this.pourcentagePar = 20+RandomInteger.main(10);
        this.degAtt = 25+RandomInteger.main(10);
        this.ptPar = 5+RandomInteger.main(5);
    }

    /**
     *
     * @param nom
     * @param pcA
     * @param pPar
     * @param dA
     * @param ptP
     * @param pos
     */
    public NuageToxique(String nom, int pcA, int pPar, int dA, int ptP, Point2D pos){
        super(nom, pos);
        this.pourcentageAtt = pcA;
        this.pourcentagePar = pPar;
        this.degAtt = dA;
        this.ptPar = ptP;
    }

    /**
     *
     * @param nt
     */
    public NuageToxique(NuageToxique nt){
        super(nt.getNom(),nt.getPos());
        this.pourcentageAtt = nt.getPourcentageAtt();
        this.pourcentagePar = nt.getPourcentagePar();
        this.degAtt = nt.getDegAtt();
        this.ptPar = nt.getPtPar();
    }           

    /**
     *
     */
    public void deplace(){
        int n = RandomInteger.main(8);
        switch(n) {
            case 0 : this.getPos().translate(1, 0);
            break;
            case 1 : this.getPos().translate(1, 1);
            break;
            case 2 : this.getPos().translate(0, 1);
            break;
            case 3 : this.getPos().translate(-1, 1);
            break;
            case 4 : this.getPos().translate(-1, 0);
            break;
            case 5 : this.getPos().translate(-1, -1);
            break;
            case 6 : this.getPos().translate(0, -1);
            break;
            case 7 : this.getPos().translate(1, -1);
            break;
        } 
    }
    
    /**
     *
     * @param c
     */
    public void combattre(Creature c){
        if(this.getPos().distance(c.getPos())==1){
            int r = Rand.main(100);
            System.out.println("\n"+this.getNom() +" attaque : "+r+" / "+this.getPourcentageAtt());

            if(r <= this.getPourcentageAtt()){
                r = Rand.main(100);
                System.out.println("Défense : "+r+" / "+this.getPourcentagePar());
                
                if(r > this.getPourcentagePar()){
                    c.setPtVie(c.getPtVie()-this.getDegAtt());
                    System.out.println(this.getNom()+" inflige "+this.getDegAtt()+" dégâts");
                }
                else{
                    c.setPtVie(c.getPtVie()-this.getDegAtt() + this.getPtPar());
                    System.out.println("Parade, "+this.getNom()+" inflige "+(this.getDegAtt()-this.getPtPar())+" dégâts");
                }
            }
            else{
                System.out.println("Nuage Toxique a raté son attaque");
            }
        }
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
        return "NuageToxique";
    }

    /**
     * Génère la ligne de sauvegarde du NuageToxique
     * @return
     */
    public String getTexteSauvegarde(){
        int x = (int)this.pos.getX();
        int y = (int)this.pos.getY();
        String texte = this.getSClass()+" "
                +this.pourcentageAtt+" "+this.pourcentagePar+" "
                +this.degAtt+" "+this.ptPar+" "
                +x+" "+y;
        return texte;
    }
    
    /**
     *
     */
    public void affiche(){
        System.out.println("Nuage Toxique : \n    nom : "+this.nom+"\n    pourcentage d'attaque : "+this.pourcentageAtt+"\n    dégâts d'attaque : "+this.degAtt+
        "\n    pourcentage de parade : "+this.pourcentagePar+"\n    points de parade : "+this.ptPar+"\n    position : "+this.pos.toString());
    }    
}
