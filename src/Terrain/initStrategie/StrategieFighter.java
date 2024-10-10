package Terrain.initStrategie;


import Terrain.ChampDeBataille;
import Terrain.Fighter;

//Strategie des actions du Fighter
 
public interface StrategieFighter {
    void action(ChampDeBataille champ,Fighter c);
    String getDecision();

}
