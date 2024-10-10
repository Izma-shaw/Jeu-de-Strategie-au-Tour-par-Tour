
package Terrain.playerFactory;

import Terrain.Fighter;
import Terrain.Soldier;
import Terrain.playerStrategy.StrategieSoldier;
import entites.Position;


/**
 *Fabrique pour Fighter de type Soldier
 */
public class SoldierFactory extends FighterFactory{

    @Override
    public Fighter creeFighter(String pseudo, Position p) {
        return new Soldier(new StrategieSoldier(),pseudo,p);
    }

}
