
package Terrain.playerFactory;

import Terrain.Fighter;
import entites.Position;

//Interface utilisee pour la fabrique des des Fighter
 
public abstract class FighterFactory {
  
    public abstract Fighter creeFighter(String pseudo, Position position);

    protected Fighter nouveauFighter(String pseudo , Position position){
        Fighter Fighter = this.creeFighter(pseudo, position);
        return Fighter;
    }

}
