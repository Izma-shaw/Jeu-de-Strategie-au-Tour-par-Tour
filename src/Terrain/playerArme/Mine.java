
package Terrain.playerArme;

import entites.Position;


//Cette classe permet de materialiser unt type d'arme de type mine
 
public abstract class Mine extends Explosable{

    public static final int PUISSANCE_MAX = 40;
    private static final int PORTEE_MAX = 1;

    public Mine() {
       this.puissance = PUISSANCE_MAX;
       this.portee = PORTEE_MAX;
    }


    @Override
    public void activerExplosif(Position p){
        this.setPosition(p);
    }
}
