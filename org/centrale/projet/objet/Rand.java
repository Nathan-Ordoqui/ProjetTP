/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;

/**
 * Classe de génération aléatoire
 * @author Utilisateur
 */

public class Rand {

      /**
       * Génére aléatoirement entre 1 et 100
       * @param n
       * @return
       */
      public static int main(int n){
        Random gen = new Random();
        return gen.nextInt(n)+1;
  }
      /**
       * Génère un Booléen aléatoire
       * @return 
       */
      
      public static Boolean rand_bool(){
          Random random = new Random();
          return random.nextBoolean();
      }
  
}

