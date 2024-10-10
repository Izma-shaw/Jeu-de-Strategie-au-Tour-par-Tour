package Terrain;

import entites.Case;
import entites.Contenue;
import Terrain.playerArme.BombeInvisible;
import Terrain.playerArme.MineInvisible;
import entites.Position;
import java.util.ArrayList;
import java.util.Observer;


public class ChampDeBatailleProxy implements Plateau{

    ChampDeBataille champ;
    Fighter c;
    public ChampDeBatailleProxy(ChampDeBataille champ, Fighter c){
        this.champ = champ;
        this.c = c;
    }



    @Override
    public void init(ChampDeBataille champ) {
        this.champ.init();
    }

    @Override
    public int getHeight() {
        return champ.getHeight();
    }

    @Override
    public Case[][] getGrid() {
        return champ.getGrid();
    }
    @Override
    public Contenue getContenue(Position p){
        if(champ.getGrid()[p.getX()][p.getY()].getContenue() instanceof BombeInvisible ||
                champ.getGrid()[p.getX()][p.getY()].getContenue() instanceof MineInvisible){
            for(int i=0; i<champ.getNbFighters();i++){
                if(!champ.getFighter()[i].equals(c)){
                    if(champ.getFighter()[i].getExplosifsDepose().contains(champ.getGrid()[p.getX()][p.getY()].getContenue())){
                        return null;
                    }
                }
            }
        }
        return champ.getContenue(p);
    }


    @Override
    public int getNbFighters() {
        return champ.getNbFighters();
    }

    @Override
    public Fighter[] getFighter() {
        return champ.getFighter();
    }

    @Override
    public void nextPlayer() {
        this.champ.nextPlayer();
    }

    @Override
    public void tir(char direction) {
        this.champ.tir(direction);
    }

    @Override
    public void addObserver(Observer obs){
        this.champ.addObserver(obs);
    }

    @Override
    public void notifyObservers(){
       for(Observer obs : this.champ.getListObserver()){
           obs.update(this.champ, obs);
       }
   }

    @Override
    public void teste() {
        this.champ.teste();
    }

    @Override
    public void placerExplosif(boolean visibilite, Position position, String typeExplosif)
    {
        this.champ.placerExplosif(visibilite, position, typeExplosif);
    }

    @Override
    public void playGame()
    {
        this.champ.playGame();
    }

    @Override
    public int getIdplayerCourant()
    {
        return this.champ.getIdplayerCourant();
    }

    @Override
    public ArrayList<Observer> getListObserver()
    {
        return this.champ.getListObserver();
    }
}
