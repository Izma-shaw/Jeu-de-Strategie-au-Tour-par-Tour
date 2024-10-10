
package Terrain;

import java.util.ArrayList;

//Permet de représenter un groupe de Fighter
 
public class FighterGroupeImpl implements FighterGroupe{

    ArrayList<Fighter> listeFighter;

    public FighterGroupeImpl(){
        listeFighter = new ArrayList<>();
    }
    @Override
    public int getSize() {
        return listeFighter.size();
    }

    @Override
    public Fighter getFighter(int i) {
        return listeFighter.get(i);
    }

    @Override
    public void add(Fighter c){
        this.listeFighter.add(c);
    }

    @Override
    public void remove(int indice) {
        this.listeFighter.remove(indice);
    }

}
