
package Terrain.playerArme;

import entites.Position;

public abstract class Bombe extends Explosable{

    public static final int PUISSANCE_MAX = 50;
    private static final int PORTEE_MAX = 9;
    public static final int DELAI_MAX = 3;

    protected int compteARebours;

    public Bombe(){
        super();
        puissance = PUISSANCE_MAX;
        portee = PORTEE_MAX;
    }

    @Override
    public void activerExplosif(Position p){
        this.setPosition(p);
        compteARebours = DELAI_MAX;
    }

    // Permet de decrémenter le compteARebours de la bombe
     
    public void decremente(){
        this.compteARebours -= 1;
    }
    /**
     *
     * @return Le compteArebours courant de la bombe
     */
    public int getCompteARebours(){
        return this.compteARebours;
    }
}
