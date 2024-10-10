
package entites;

//Cette classe permet de creer des instances de pastilles
 
public class Pastille implements Contenue{

    public static final int ENERGIE_MAX = 60;
    private Position position;
   
    public Pastille(Position position) {
        this.position = position;
    }
}
