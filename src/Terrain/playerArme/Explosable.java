package Terrain.playerArme;


import entites.Contenue;
import entites.Position;

//Cette classe correspond à un groupe d'armes qui sont capables d'exploser ou d'avoir une position dans la grid.
 
public abstract class Explosable extends Arme implements Contenue {

    protected Position position;
    protected String type;

    //Permet d'activer l'explosif en question en initialisant sa position dans la grid
     
   protected abstract void activerExplosif(Position position);

   
   public Position getPosition(){
       return this.position;
   }

   public void setPosition(Position position){
       this.position = position;
   }


}
