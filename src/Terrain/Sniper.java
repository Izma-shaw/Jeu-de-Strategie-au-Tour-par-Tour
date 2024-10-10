package Terrain;

import Terrain.initStrategie.StrategieFighter;
import Terrain.playerArme.*;
import entites.Position;


public class Sniper extends Fighter{

    private static final int S_MINES = 2;
    private static final int S_BALLES = 100;
    private static final int ARME_MAX = 3;
    private static final int ENERGIE_MAX = 160;



  public Sniper(StrategieFighter strategie,String pseudo, Position position){

      super(strategie,pseudo, position);
      minution = new int[ARME_MAX];
      armes = new Arme[ARME_MAX];
      energie = ENERGIE_MAX;

      this.chargerArme();

  }
    @Override
  public void chargerArme(){

      minution[0] = 0;
      minution[1] = S_MINES;
      minution[2] = S_BALLES;

  }
    @Override
    public Bombe deposerBombe(boolean visibilite,Position p) {
        throw new RuntimeException("Sniper ne dispose pas de bombe") ;
    }

    public static String caracteristique(){
        return  Fighter.caracteristique()+"\t==> SNIPER"
                +"\t"+ENERGIE_MAX+"\t"+"--"+"\t"+S_BALLES+"\t"+S_MINES;
    }

    @Override
    public String caracteristiqueCourant(){
        return super.pseudo+
                "\t==> SNIPER"
                +"\t"+this.energie+"\t"+"--"+"\t"+this.minution[0]+"\t"+this.minution[1];
    }
    @Override
    public void gainEnergie(int energie) {

        if(ENERGIE_MAX - this.energie > energie){
            this.energie += energie;
        }
        else{
            this.energie = ENERGIE_MAX;
        }
    }

}
