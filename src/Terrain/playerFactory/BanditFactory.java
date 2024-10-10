
package Terrain.playerFactory;

import Terrain.Fighter;
import Terrain.Bandit;
import Terrain.playerStrategy.StrategieBandit;
import entites.Position;

// Fabrique pour un Fighter Bandit
 
public class BanditFactory extends FighterFactory{

    @Override
    public Fighter creeFighter(String pseudo, Position p) {
        return new Bandit(new StrategieBandit(),pseudo,p);
    }

}
