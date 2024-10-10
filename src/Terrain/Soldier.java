
package Terrain;
import Terrain.playerArme.Arme;
import Terrain.initStrategie.StrategieFighter;
import entites.Position;



public class Soldier extends Fighter{

    private static final int SO_BALLES = 50;
    private static final int SO_BOMBES = 3;
    private static final int SO_MINES = 1;
    private static final int ARME_MAX = 3;
    private static final int ENERGIE_MAX = 200;

    public Soldier(StrategieFighter strategie,String pseudo , Position position){

        super(strategie,pseudo, position);
        minution = new int[ARME_MAX];
        armes = new Arme[ARME_MAX];
        energie = ENERGIE_MAX;

        this.chargerArme();

    }

    @Override
    public void chargerArme(){

        minution[0] = SO_BOMBES;

        minution[1] = SO_MINES;

        minution[2] = SO_BALLES;
    }

    public static String caracteristique(){
        return Fighter.caracteristique()+"\t==> Soldier"
                +"\t"+ENERGIE_MAX+"\t"+SO_BOMBES+"\t"+SO_MINES+"\t"+SO_BALLES;
    }
    @Override
    public String caracteristiqueCourant(){
        return super.pseudo+
                "\t==> Soldier"
                +"\t"+this.energie+"\t"+this.minution[1]+"\t"+this.minution[2]+"\t"+this.minution[0];
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
