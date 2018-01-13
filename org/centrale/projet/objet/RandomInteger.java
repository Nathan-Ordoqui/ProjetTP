/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de génération aléatoire d'entiers
 * @author Utilisateur
 */
// Dans un fichier RandomInteger.java
import java.util.Random;

// On genere 10 entiers pseudo-aleatoires dans l'intervalle [0,99]

/**
 * Classe de génération aléatoire d'entiers
 * @author Kevin
 */
public class RandomInteger {

    /**
     *
     * @param n
     * @return
     */
    public static int main(int n) {
    
    // NB : il est INUTILE de creer plusieurs objets de type Random
    // UN SEUL suffit pour generer plusieurs 
    // nombres pseudo-aleatoires
    Random generateurAleatoire = new Random();
    
    // Boucle de generation des 10 nombres
    return generateurAleatoire.nextInt(n);
  }
}