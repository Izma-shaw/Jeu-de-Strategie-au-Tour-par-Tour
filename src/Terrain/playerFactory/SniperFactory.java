
package Terrain.playerFactory;

import Terrain.Fighter;
import Terrain.Sniper;
import Terrain.playerStrategy.StrategieSniper;
import entites.Position;

//Fabrique pour un Fighter de type Sniper
 
public class SniperFactory extends FighterFactory{

    @Override
    public Fighter creeFighter(String pseudo, Position p) {
        return new Sniper(new StrategieSniper(),pseudo,p);
    }

}
