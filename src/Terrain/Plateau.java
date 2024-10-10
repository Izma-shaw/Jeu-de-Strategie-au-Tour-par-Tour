
package Terrain;


import entites.Case;
import entites.Contenue;
import entites.Position;
import java.util.ArrayList;
import java.util.Observer;

public interface Plateau {
    // Affiche une representation textuelle de la grid du jeu
   
    @Override
    String toString();//pour le proxy

    // Initaialise la grid selon la strategie choisie
    
    void init(ChampDeBataille champ);//pour la strategie de remplissage (pattern strategy)
   
    int getHeight();
    // Retourne une matrice représentant la grid
    
    Case[][] getGrid();
    
    Contenue getContenue(Position position);
  
    int getNbFighters();
     //Retourne la liste des fighters  des fighters  du jeu
     
    Fighter[] getFighter();
    
    void teste();
    // Permet de placer un explosif dans la grid
     
    void placerExplosif(boolean visibilite,Position position,String typeExplosif);
   // Permet de passer le tour au player suivant dans la liste des players
     
    void nextPlayer();
    //Permet d'effectuer un tir suivant la direction spécifiée en paramètre
   
    void tir(char direction);
  
    void playGame();
  // Retourne l'indice du player ayant le tour de jeu
    
    int getIdplayerCourant();
    //Permet d'ajouter l'observer passé en paramètre dans la liste des observers
    
    void addObserver(Observer obs);
   //Notifie les observateurs lors d'un changement
     
    void notifyObservers();
    /**
     *
     * @return
     */
    ArrayList<Observer> getListObserver();
}
