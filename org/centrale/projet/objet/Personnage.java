/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Classe Personnage, sous-classe de Creature
 * @author Kevin
 */
public class Personnage extends Creature{
    
    /**
     * Nom de la créature
     */
    protected String nom;

    /**
     * points de mana
     */
    protected int ptMana;

    /**
     * pourcentage de magie
     */
    protected int pourcentageMag;

    /**
     * pourcentage de résistance magie
     */
    protected int pourcentageResistMag;

    /**
     * dégâts de magie
     */
    protected int degMag;

    /**
     * distance maximale d'attaque
     */
    protected int distAttMax;
    
    /**
     *
     */
    protected LinkedList<Nourriture> nList;
    
    /**
     * Constructeur de Personnage avec arguments
     * @param nom Nom
     * @param ptV Points de vie
     * @param ptM Poitns de magie
     * @param pA Pourcentage d'attaque
     * @param pP Points de parade
     * @param pcP pourcentage de parade
     * @param pM pourcentage de magie
     * @param rM résistance magie
     * @param dA dégâts d'attaque
     * @param dM dégâts de magie
     * @param distMax distance maximale d'attaque
     * @param pos position
     */
    public Personnage(String nom, int ptV, int ptM, int pA,int pP, int pcP, int pM, int rM, int dA, int dM, int distMax, Point2D pos){
        this.nom = nom;
        this.ptVie = ptV;
        this.ptMana = ptM;
        this.pourcentageAtt = pA;
        this.ptPar = pP;
        this.pourcentagePar = pcP;
        this.pourcentageMag = pM;
        this.pourcentageResistMag = rM;
        this.degAtt = dA;
        this.degMag = dM;
        this.distAttMax = distMax;
        this.pos = pos;
        this.nList = new LinkedList();
    }
    
    /**
     * Crée une copie du personnage en entrée
     * @param perso Personnage à copier
     */
    public Personnage(Personnage perso){
        nom = perso.getNom();
        ptVie = perso.getPtVie();
        ptMana = perso.getPtMana();
        pourcentageAtt = perso.getPourcentageAtt();
        pourcentagePar = perso.getPourcentagePar();
        pourcentageMag = perso.getPourcentageMag();
        pourcentageResistMag = perso.getPourcentageResistMag();
        degAtt = perso.getDegAtt();
        degMag = perso.getDegMag();
        distAttMax = perso.getDistAttMax();
        pos = new Point2D(perso.getPos()); 
        this.nList = new LinkedList();
    }

    /**
     * Construit un Personnage par défaut
     */
    public Personnage(){
        nom = "Personnage";
        ptVie = 0;
        ptMana = 0;
        pourcentageAtt = 0;
        pourcentagePar = 0;
        pourcentageResistMag = 0;
        degAtt = 0;
        degMag = 0;
        distAttMax = 0;
        pos = new Point2D();
        this.nList = new LinkedList();
    }
    
    /**
     *
     * @return Nom
     */
    public String getNom(){
        return nom;
    }
    
    /**
     *
     * @param value
     */
    public void setNom(String value){
        this.nom = value;
    }
       
    /**
     *
     * @return
     */
    public int getPtMana(){
        return ptMana;
    }
    
    /**
     *
     * @param value
     */
    public void setPtMana(int value){
        this.ptMana = value;
    }
    
    /**
     *
     * @return
     */
    public int getPourcentageMag(){
        return pourcentageMag;
    }
        
    /**
     *
     * @param value
     */
    public void setPourcentageMag(int value){
        this.pourcentageMag = value;
    }

    /**
     *
     * @return
     */
    public int getPourcentageResistMag(){
        return pourcentageResistMag;
    }
        
    /**
     *
     * @param value
     */
    public void setPourcentageResistMag(int value){
        this.pourcentageResistMag = value;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax(){
        return distAttMax;
    }
         
    /**
     *
     * @param value
     */
    public void setDistAttMax(int value){
        this.distAttMax = value;
    }

    /**
     *
     * @return
     */
    public int getDegMag(){
        return degMag;
    }
    
    /**
     *
     * @param value
     */
    public void setDegMag(int value){
        this.degMag = value;
    }
    
    /**
     *
     */
    @Override
    public void affiche(){
        System.out.println("Personnage : nom : "+this.nom+"\n    points de vie : "+this.ptVie+
                "\n    points de mana : "+this.ptMana+"\n    pourcentage d'attaque : "+this.pourcentageAtt+
                "\n    dégâts d'attaque : "+this.degAtt+"\n    dégâts magiques : "+this.degMag+"\n    pourcentage magique : "+this.pourcentageMag+
                "\n    pourcentage de résistance magique : "+this.pourcentageResistMag+
                "\n    pourcentage de parade : "+this.pourcentagePar+
                "\n    distance maximale d'attaque : "+this.distAttMax+"\n    position : "+this.pos.toString());
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
    
    /**
     *
     * @param s
     */
    public void consomme(Soin s){
        this.ptVie += s.getValSoin();
        s.setPleine(false);
    }

    /**
     *
     * @param m
     */
    public void consomme(Mana m){
        this.ptMana += m.getValMana();
        m.setPleine(false);
    }
    
    /**
     *
     * @param p
     */
    public void consomme(Potion p){
        if(p.getClass().equals(new Soin().getClass())){
            Soin s = (Soin) p;
            this.consomme(s);
        }
        else if(p.getClass().equals(new Mana().getClass())){
            Mana m = (Mana) p;
            this.consomme(m);
        }
    }
    
    /**
     *
     * @param food
     */
    public void getBM(Nourriture food){
        
        if(food.getB_m()){
            this.degAtt = Math.min(100,this.degAtt+food.getBonus());
        }
        else{
            this.degAtt = Math.max(0,this.degAtt-food.getMalus());
        }
        
    }
    
    /**
     *
     */
    public void vieillit(){
        for (Iterator<Nourriture> iter = this.nList.listIterator(); iter.hasNext(); ) {
            Nourriture food = iter.next();
            food.setDuree(food.getDuree()-1);
            if (food.getDuree()<=0) {
                if(food.getB_m()){
                    this.degAtt = Math.min(100,this.degAtt-food.getBonus());
                }
                else{
                    this.degAtt = Math.max(0,this.degAtt+food.getMalus());
                }
                iter.remove();
                }
            System.out.println("L'effet s'estompe");
        }
    }
  
    /**
     *
     * @param c
     */
    public void combattre(Creature c){
        
    }

    /**
     * @return the nList
     */
    public LinkedList<Nourriture> getnList() {
        return nList;
    }

    /**
     * @param nList the nList to set
     */
    public void setnList(LinkedList<Nourriture> nList) {
        this.nList = nList;
    }

    /**
     *
     * @return
     */
    public String getTexteSauvegarde() {
        return "Ceci est un personnage";
    }
    
    
    
    }
    

    

