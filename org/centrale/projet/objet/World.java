/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


/**
 * Classe World
 * @author Utilisateur
 */
public class World {

    /**
     * Largeur du plateau
     */
    public int largeur;

    /**
     * Hauteur du plateau
     */
    public int hauteur;
    
    /**
     * Liste des créatures
     */
    public LinkedList<Creature> listeC;
    
    /**
     * Liste des objets
     */
    public LinkedList<Objet> listeO;
    
    /**
     * Joueur
     */
    public Joueur player;

    /**
     * Constructeur avec attributs donnés en arguments
     * @param hauteur
     * @param largeur
     * @param player
     * @param listeC
     * @param listeO
     */
    public World(int hauteur, int largeur, Joueur player, LinkedList<Creature> listeC, LinkedList<Objet> listeO){
        this.player = player;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listeC = listeC;
        this.listeO = listeO;
    }
    
    /**
     * Affiche des caractéristiques du monde selon les choix de l'utilisateur
     */
    public void afficheWorld(){
        System.out.println("\nVotre monde est de largeur "+this.getHauteur()+" et de hauteur "+this.getLargeur());
        System.out.println("Voici le joueur :\n");
        this.getPlayer().getPerso().affiche();
        
        System.out.println("\nLe monde contient "+this.listeC.size()+" créatures (+1 joueur) et "+this.listeO.size()+" objets.");
        System.out.println("\nVoulez-vous voir la liste des créatures composant votre monde ? Ecrivez 'oui' ou 'non' :");
        Scanner sc1 = new Scanner(System.in);
        String choix = sc1.next();
        while (!(choix.equals("oui")||choix.equals("non"))){
            System.out.println("Ecrivez bien 'oui' ou 'non' :");
            Scanner sc2 = new Scanner(System.in);
            choix = sc2.next();
        }
                
        if (choix.equals("oui")){
            System.out.println("\nVoici les créatures :");
            for(Creature c : this.getListeC()){
                c.affiche();
            }            
        }

        System.out.println("\nVoulez-vous voir la liste des objets composant votre monde ? Ecrivez 'oui' ou 'non' :");
        Scanner sc3 = new Scanner(System.in);
        String choix2 = sc3.next();
        while (!(choix2.equals("oui")||choix2.equals("non"))){
            System.out.println("Ecrivez bien 'oui' ou 'non' :");
            Scanner sc4 = new Scanner(System.in);
            choix2 = sc4.next();
        }
        
        if (choix2.equals("oui")){
            System.out.println("\nVoici les objets :");
            for(Objet o : this.getListeO()){
            o.affiche();
            }        
        }
    }
    
    /**
     * Constructeur du monde avec la méthode creeMondeAlea
     * @throws java.io.IOException
     */
    public World() throws IOException{
        System.out.println("Voulez-vous générer un monde aléatoire ou charger une partie existante? Ecrivez 'aleatoire' ou 'charger' :");
        Scanner sc1 = new Scanner(System.in);
        String choix = sc1.next();
        while(!(choix.equals("aleatoire")||choix.equals("charger"))){
            System.out.println("Ecrivez bien 'aleatoire' ou 'charger' :");
            Scanner sc2 = new Scanner(System.in);
            choix = sc2.next();
        }
        if (choix.equals("aleatoire")){
            this.creeMondeAlea();
        }
        else if(choix.equals("charger")){
            System.out.println("Entrez le nom du fichier (! sans oublier '.txt' !) :");
            Scanner sc3 = new Scanner(System.in);
            String filename = sc3.next();
            File f = new File(filename);
            while (!f.exists()){
                System.out.println("Entrez un fichier EXISTANT (! sans oublier '.txt' !) :");
                Scanner sc4 = new Scanner(System.in);
                filename = sc4.next();
                f = new File(filename);
            }
            ChargementPartie cP = new ChargementPartie(filename);
            World monde = cP.chargerPartie();
            this.player = monde.getPlayer();
            this.hauteur = monde.getHauteur();
            this.largeur = monde.getLargeur();
            this.listeC = monde.getListeC();
            this.listeO = monde.getListeO();
        }
        this.afficheWorld();   
    }
    
   
     /**
     * Créé un monde aléatoire
     */
    public final void creeMondeAlea(){
        // o
        System.out.println("\nVoulez-vous choisir la taille de votre monde ? Ecrivez 'oui' ou 'non' :");
        Scanner sc1 = new Scanner(System.in);
        String choix = sc1.next();
        while (!(choix.equals("oui")||choix.equals("non"))){
            System.out.println("Ecrivez bien 'oui' ou 'non' :");
            Scanner sc2 = new Scanner(System.in);
            choix = sc2.next();
        }

        if (choix.equals("oui")){
            System.out.println("\nVeuillez donner la dimension (en restant raisonnable):");
            Scanner sc3 = new Scanner(System.in);
            int largeur = Integer.parseInt(sc3.next());
            this.hauteur = largeur;
            this.largeur = largeur;
        }
        
        else if(choix.equals("non")){
            this.hauteur = 30+RandomInteger.main(40);
            this.largeur = this.hauteur;
        }   
                
        Joueur joujou = new Joueur();
        joujou.choixPerso();
        Personnage perso_temp = joujou.getPerso();
        perso_temp.setPos(new Point2D(RandomInteger.main(this.hauteur), RandomInteger.main(this.largeur)));
        joujou.setPerso(perso_temp);
        this.setPlayer(joujou);
        this.setListeC(new LinkedList<>());
        this.setListeO(new LinkedList<>());
        
        int nombre = (this.hauteur*this.largeur)/25;
        for(int i=0;i<nombre;i++){
            Point2D p = new Point2D(Point2D.newPos(this.hauteur, this.largeur));
  
            int j = 0;
            Boolean ok = true;
            while(!disponible(p)){
                p = Point2D.newPos(this.hauteur, this.largeur);
                j++;
                if(i==100){ok=false; break;}
                }
            
            if(ok && i!=0){
                int cle = RandomInteger.main(6);
                Creature rperso = new Creature();
                switch(cle){
                    case 0 :
                        rperso = new Archer();
                        break;
                    case 1 :
                        rperso = new Guerrier();
                        break;
                    case 2 :
                        rperso = new Lapin();
                        break;
                    case 3 :
                        rperso = new Loup();
                        break;
                    case 4 :
                        rperso = new Mage();
                        break;
                    case 5 :
                        rperso = new Paysan();
                        break;
                }
                
                rperso.setPos(p);
                this.getListeC().add(rperso);}            
        }
        
        for(int i=0;i<nombre;i++){
            Point2D p = new Point2D(Point2D.newPos(this.hauteur,this.largeur));
            
            int j = 0;
            Boolean ok = true;
            while(!disponibleO(p)){
                p = Point2D.newPos(this.hauteur, this.largeur);
                j++;
                if(i==100){ok=false; break;}
                }
            
            if(ok && i!=0){
                int cle = RandomInteger.main(4);
                Objet robjet = new Objet();
                switch(cle){
                    case 0 :
                        robjet = new Soin();
                        break;
                    case 1 :
                        robjet = new Mana();
                        break;
                    case 2 :
                        robjet = new Nourriture();
                        break;
                    case 3 :
                        robjet = new NuageToxique();
                        break;
                    
                }
                
                robjet.setPos(p);
                this.getListeO().add(robjet);}            
        }
    }
   
    /**
     *
     * @param nb
     *//*
    public final void creeMondeAlea(int nb){
        // o
        this.setListeC(new LinkedList<>());
        for(int i=0;i<nb;i++){
            Point2D p = new Point2D(Point2D.newPos(getN()));
            int j = 0;
            Boolean ok = true;
            while(!disponible(p)){
                p = Point2D.newPos(getN());
                j++;
                if(j==100){ok=false; break;}
                }
            
            if(ok){
                Loup peon = new Loup();
                peon.setPos(p);
                this.getListeC().add(peon);}
            
        }
        
        for(int i=0;i<nb;i++){
            Point2D p = new Point2D(Point2D.newPos(getN()));
            
            int j = 0;
            Boolean ok = true;
            while(!disponibleO(p)){
                p = Point2D.newPos(getN());
                j++;
                if(i==100){ok=false; break;}
                }
            
            if(ok && i!=0){
                //Paysan peon = new Paysan();
                NuageToxique mist = new NuageToxique();
                mist.setPos(p);
                this.getListeO().add(mist);}            
        }
        
    }
 */   
    /**
     * Vérifie la disponibilité d'une case pour les créatures
     * @param p
     * @return
     */
    public Boolean disponible(Point2D p){
        Boolean b;
        b = true;
        LinkedList<Creature> ltemp = new LinkedList<>(this.getListeC());
        ltemp.offerFirst(this.player.getPerso());
        for(Creature c : ltemp){
            if(p.equals(c.getPos())||!p.inMap(this.hauteur, this.largeur)){
                b = false;
                return b;
            }
            //else{System.out.println("ok");}
        }
        return b;
    }
    
    /**
     * Vérifie la disponibilité d'une case pour les objets
     * @param p
     * @return
     */
    public Boolean disponibleO(Point2D p){
        Boolean b;
        b = true;
        for(Objet o : this.getListeO()){
            if(p.equals(o.getPos())||!p.inMap(this.hauteur, this.largeur)){
                b = false;
                return b;
            }
        }
        return b;
    }
    
    /**
     * Vérifie la disponibilité (3 cases de distance)
     * @param p
     * @return
     */
    public Boolean disponible3(Point2D p){
        Boolean b;
        b = true;
        for(Creature c : this.getListeC()){
            if(p.distance(c.getPos())<3||!p.inMap(this.hauteur, this.largeur)){
                b = false;
                return b;
            }
        }
        return b;
    }
    
    /**
     * Tour de jeu complet incluant les actions du joueur et des PNJ
     */
    public void tourDeJeu(){
        
        if(this.getPlayer().getPerso().getPtVie()<=0){
            System.out.println("Perdu !");    
        }
        
        else{
        
        
        Personnage p_temp = this.getPlayer().getPerso();
        p_temp.vieillit();
        this.getPlayer().setPerso(p_temp);
        
        for(Creature c : this.getListeC()){
            try{
                Personnage perso = (Personnage) c;
                c.vieillit();
            }
            catch(ClassCastException e){
                
            }
        }        
 
        LinkedList<Creature> l = new LinkedList<>();
        for(Creature c : this.getListeC()){
            if(c.getPtVie()>0 && this.getPlayer().getPerso().getPos().distance(c.getPos())<this.getPlayer().getPerso().getDistAttMax()){
                l.add(c);
            }
        }
        
        this.affiche();

        System.out.println("\033[31m"+"\nVous pouvez vous déplacer (0) ou attaquer (si rien n'est marqué, alors vous ne pouvez que vous déplacer puisqu'aucun adversaire est à portée) :"+this.getNoir());
        int k = 1;

        for(Creature c : l){
            System.out.println(k+" : "+c.getSClass()+" en "+c.getPos().toString());
            k+=1;
        }
            
        Scanner scan = new Scanner(System.in);
        String input = new String();
        Boolean b = true;
        int res = -1;
        while(b){
            try{
                input = scan.next();
                res = Integer.parseInt(input);
                System.out.println("Vous avez entré : "+res);
                if(res<0 || res>k){
                    System.out.println("Numéro incorrect veuillez recommencer");
                }
                else{
                    b = false;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Format incorrect, veuillez recommencer");
            }
        }
        if(res == 0){
            this.getPlayer().deplaceJoueur(this);
        }
        else{
            this.getPlayer().combatJoueur(l.get(res-1));
        }
        
        this.ramassagePerso();
        
        System.out.println("\033[31m"+"\nC'est au tour des PNJ."+this.getNoir());
        
        for(Creature c : this.getListeC()){
            Point2D p = Point2D.newPos(c.getPos());
            int i = 0;
            Boolean ok = true;
            while(!disponible(p)){
                p = Point2D.newPos(c.getPos());
                i++;
                if(i==100){ok=false; break;}
                }
            
            if(ok){c.setPos(p);}
            LinkedList<Creature> ltemp = new LinkedList<>(this.getListeC());
            ltemp.offerFirst(this.player.getPerso());
            Boolean sortie = false;
            for(Creature cv : ltemp){
                if( !sortie && c.getPos().distance(cv.getPos())<c.getDistAttMax() && c.getPos() != cv.getPos() && cv.getPtVie()>0){
                    c.combattre(cv);
                    sortie = true;
                }
            }
        }
        
        for(Creature c : this.getListeC()){
            try{
                Personnage perso = (Personnage) c;
                this.ramassage(perso);
            }
            catch(ClassCastException e){
                
            }
        }
        
        for(Objet o : this.getListeO()){
            if(o.getClass().equals(new NuageToxique().getClass())){
                
                Point2D p = Point2D.newPos(o.getPos());
                int i = 0;
                Boolean ok = true;
                while(!disponibleO(p)){
                    p = Point2D.newPos(o.getPos());
                    i++;
                    if(i==100){ok=false; break;}
                    }

                if(ok){o.setPos(p);}
            }
            }
        }
        System.out.println("\033[31m"+"Les PNJ ont fini d'agir pour ce tour.\n"+this.getNoir());
        for (Iterator<Creature> iter = this.getListeC().listIterator(); iter.hasNext(); ) {
            Creature c = iter.next();
            if (c.getPtVie()<=0) {
                System.out.println(c.getSClass()+" est mort");
                iter.remove();
                }
        }
        this.sauvegardeTour();
    }
    

    /**
     * Affcihe l'état actuel du monde
     */
    public void affiche(){
//        System.out.println("Taille du monde : "+this.n+"\n");
//        
//        for(Creature c : this.listeC){
//            System.out.println(c.getClass()+" : "+c.getPos().toString());
//        }
        ArrayList<ArrayList<String>> m = new ArrayList<>(this.hauteur);
        ArrayList<String> l = new ArrayList<>(this.largeur);
        for(int i = 0; i<this.largeur; i++){
            l.add(".");
        }
        ArrayList<String> lt = new ArrayList<>(this.largeur);
//        for(int i = 0; i<this.largeur; i++){
//            l.set(i, ".");
//        }
        for(int i = 0; i<this.hauteur; i++){
            m.add(new ArrayList(l));
        }
        for(Creature c : this.getListeC()){
            double x = c.getPos().getX();
            double y = c.getPos().getY();
            String s = new String(c.getSClass());
            String token = new String();
            switch(s){
                case "Archer" : 
                    token = "A";
                    break;
                case "Guerrier" : 
                    token = "G";
                    break;
                case "Lapin" : 
                    token = "R";
                    break;
                case "Loup" : 
                    token = "L";
                    break;
                case "Mage" : 
                    token = "M";
                    break;
                case "Paysan" : 
                    token = "P";
                    break;
                default : 
                    token = "C";
                    break;
            }
            lt = new ArrayList(m.get((int) y));
            lt.set((int) x, token);
            m.set((int) y, lt);
        }
        
        for(Objet o : this.getListeO()){
            double x = o.getPos().getX();
            double y = o.getPos().getY();
            String s = new String(o.getSClass());
            String token = new String();
            switch(s){
                case "Soin" : 
                    token = this.getRouge();
                    break;
                case "Mana" : 
                    token = this.getBleu();
                    break;
                case "NuageToxique" : 
                    token = this.getViolet();
                    break;
                case "Nourriture" : 
                    token = this.getJaune();
                    break;
                default : 
                    token = "";
                    break;
            }
            lt = new ArrayList(m.get((int) y));
            String el = new String();
            el = token + m.get((int) y).get((int) x) + this.getNoir();
            lt.set((int) x, el);
            m.set((int) y, lt);
        }
        
        double x = this.getPlayer().getPerso().getPos().getX();
        double y = this.getPlayer().getPerso().getPos().getY();
        lt = new ArrayList(m.get((int) y));
        lt.set((int) x, "\033[31m"+"@"+this.getNoir());
        m.set((int) y, lt);
        
        
        String res = new String();
        for(int i=0; i<this.largeur; i++){
            for(int j=0; j<this.hauteur;j++){
                res += m.get(j).get(i);
            }
            res += "\n";
        }
        System.out.println(res);
        System.out.println("Légende :\nCréatures : A = Archer, G = Guerrier, M = Mage, P = Paysan, R = Lapin, L = Loup"
                +"\nObjets : "+this.getJaune()+"Jaune"+this.getNoir()+" = Nourriture, "+this.getViolet()+"Violet"+this.getNoir()+" = Nuage Toxique, "+this.getBleu()+"Bleu"+this.getNoir()+" = Mana, "+this.getRouge()+"Rouge"+this.getNoir()+" = Soin\nJoueur : "+"\033[31m"+"@"+this.getNoir());
        System.out.println("\nLe joueur est à la ligne "+((int) this.player.getPerso().getPos().getX()+1)+ " et la colonne "+((int) this.player.getPerso().getPos().getY()+1));
        System.out.println("Il reste "+this.player.getPerso().getPtVie()+" points de vie au joueur");
    }
    
    /**
     * Effectue le ramassage automatique d'objets pour les PNJ
     * @param p
     */
    public void ramassage(Personnage p){
        for (Iterator<Objet> iter = this.getListeO().listIterator(); iter.hasNext(); ) {
            Objet o = iter.next();
            
            if (o.getPos().equals(p.getPos())) {
                if(o.getClass().equals(new Nourriture().getClass())){
                    LinkedList<Nourriture> temp = p.getnList();
                    Nourriture sandwitch = (Nourriture) o;
                    temp.add(sandwitch);
                    p.setnList(temp);
                    iter.remove();
                    
                }
                else if(o.getClass().equals(new NuageToxique().getClass())){
                    NuageToxique cloud = (NuageToxique) o;
                    cloud.combattre(p);
                    
                }
                else{
                    Potion pot = (Potion) o;
                    p.consomme(pot);
                    iter.remove();
                    
                }
            }
        }
    }
    
    /**
     * Effectue le ramassage automatique d'objet pour le joueur
     */
    public void ramassagePerso(){
        
        for (Iterator<Objet> iter = this.getListeO().listIterator(); iter.hasNext(); ) {
            Objet o = iter.next();
            Personnage p = this.getPlayer().getPerso();
            //System.out.println(p.getPos().equals(o.getPos()));
            if(o.getPos().equals(p.getPos())) {

                //System.out.println("RAMASSAGE");
                if(o.getClass().equals(new Nourriture().getClass())){
                    LinkedList<Nourriture> temp = this.getPlayer().getPerso().getnList();
                    Nourriture sandwitch = (Nourriture) o;
                    temp.add(sandwitch);
                    this.getPlayer().getPerso().setnList(temp);
                    iter.remove();
                    
                    System.out.println("Vous avez mangé, vous avez maintenant "+this.getPlayer().getPerso().getDegAtt()+" points d'attaque");
                    
                }
                else if(o.getClass().equals(new NuageToxique().getClass())){
                    NuageToxique cloud = (NuageToxique) o;
                    cloud.combattre(this.getPlayer().getPerso());
               
                    System.out.println("Vous avez respiré du gaz toxique, vous avez maintenant "+this.getPlayer().getPerso().getPtVie()+" points de vie");
                    
                }
                else{
                    Potion pot = (Potion) o;
                    this.getPlayer().getPerso().consomme(pot);
                    iter.remove();
                    
                    System.out.println("Vous avez consommé une potion, vous avez maintenant "+this.getPlayer().getPerso().getPtVie()+" points de vie et "+this.getPlayer().getPerso().getPtMana()+" points de mana");
                    
                }
            }
            //else{System.out.println("AH");}
        }
    }

    /**
     * Propose la sauvegarde à chaque tour
     */
    public void sauvegardeTour(){
        System.out.println("Voulez-vous sauvegarder la partie ? Ecrivez 'oui' ou 'non' :");
        Scanner sc1 = new Scanner(System.in);
        String choix = sc1.next();
        while (!(choix.equals("oui")||choix.equals("non"))){
            System.out.println("Veuillez écrire 'oui' ou 'non' à la question 'Voulez-vous sauvegarder la partie ?' :");
            Scanner sc2 = new Scanner(System.in);
            choix = sc2.next();
        }
        if (choix.equals("oui")){
            System.out.println("Si vous voulez choisir le nom du fichier tappez le nom (! sans oublier '.txt' !) sinon écrivez 'auto' :");
            Scanner sc3 = new Scanner(System.in);
            String nom = sc3.next();
            SauvegardePartie sP;
            if (nom.equals("auto")){
                sP = new SauvegardePartie();
                sP.sauvegarderPartie(this);
            }
            else{
                sP = new SauvegardePartie(nom);
                sP.sauvegarderPartie(this);
            }
        }
    }
    
    /**
     * Crée une police surlignée en violet
     * @return
     */
    public static String getViolet(){
        return "\033[45m";
    }
    
    /**
     * Crée une police surlignée en bleu
     * @return
     */
    public static String getRouge(){
        return "\033[41m";
    }
    
    /**
     *
     * @return
     */
    public static String getBleu(){
        return "\033[44m";
    }
    
    /**
     * Crée une police surlignée en jaune
     * @return
     */
    public static String getJaune(){
        return "\033[43m";
    }
    
    /**
     * Crée la couleur native
     * @return
     */
    public static String getNoir(){
        return "\033[0m";
    }

    /**
     * @return the listeC
     */
    public LinkedList<Creature> getListeC() {
        return listeC;
    }

    /**
     * @param listeC the listeC to set
     */
    public void setListeC(LinkedList<Creature> listeC) {
        this.listeC = listeC;
    }

    /**
     * @return the listeO
     */
    public LinkedList<Objet> getListeO() {
        return listeO;
    }

    /**
     * @param listeO the listeO to set
     */
    public void setListeO(LinkedList<Objet> listeO) {
        this.listeO = listeO;
    }

    /**
     * @return the player
     */
    public Joueur getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Joueur player) {
        this.player = player;
    }

    /**
     * @return the largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @param largeur the largeur to set
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * @return the hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @param hauteur the hauteur to set
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

}


