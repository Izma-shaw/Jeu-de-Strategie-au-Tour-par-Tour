
package Terrain;

import Terrain.initStrategie.StrategieFighter;
import Terrain.playerArme.Arme;
import entites.Position;

public class Bandit extends Fighter{

    private static final int ENERGIE_MAX = 300;
    private static final int ARME_MAX = 3;
    private static final int R_BOMBES = 10;
    private static final int R_MINES = 10;

    public Bandit(StrategieFighter strategie ,String pseudo , Position position){
        super(strategie,pseudo,position);
        energie = ENERGIE_MAX;
        minution = new int[ARME_MAX];
        armes = new Arme[ARME_MAX];
        this.chargerArme();
    }

    @Override
    public void chargerArme(){
        minution[0] = R_BOMBES;
        minution[1] = R_MINES;
        minution[2] = 0;
    }

    public static String caracteristique(){
        return Fighter.caracteristique()+"\t==> Bandit"
                +"\t"+ENERGIE_MAX+"\t"+R_BOMBES+"\t"+R_MINES+"\t"+"--";
    }
    @Override
    public String caracteristiqueCourant(){
        return super.pseudo+
                "\t==> Bandit "
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

    @Override
    public void tirer() {
        throw new RuntimeException("Bandit ne dispose pas de pistolet");

    }

}
