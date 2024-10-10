
package Terrain.playerStrategy;

import Terrain.initStrategie.StrategieFighter;
import entites.Mur;
import Terrain.playerArme.Explosable;
import entites.Pastille;
import entites.CaseVide;
import Terrain.ChampDeBataille;
import Terrain.Fighter;
import Terrain.Ia;

import entites.Position;
import java.util.Random;

public class StrategieSoldier implements StrategieFighter{

    String decision;

    public String getDecision() {
        return decision;
    }
    @Override
    public void action(ChampDeBataille champ, Fighter c) {
         Ia ia = new Ia(champ);
           decision = ia.applicationDecisionSoldier(champ, c);
          System.out.println("Decision "+decision+" Fighter Soldier");

        switch(decision){

            case "deplacer":
                this.deplacement(champ, c);
                break;
            case "explosif":
                this.combat1(champ, c);
                break;
            case "tire":
                this.combat2(champ,c);
                break;
            case "bouclier":
                champ.bouclier();
                c.activeBouclier();
                break;
        }
    }

    public void deplacement(ChampDeBataille champ, Fighter c) {

        Position p = new Position(0,0);

        Random r=new Random();

        Position[] pos = new Position[4];
        pos[0] = new Position(c.getPosition().getX()+1,c.getPosition().getY());
        pos[1] = new Position(c.getPosition().getX()-1,c.getPosition().getY());
        pos[2] = new Position(c.getPosition().getX(),c.getPosition().getY()+1);
        pos[3] = new Position(c.getPosition().getX(),c.getPosition().getY()-1);

        for( int i = 0;i<pos.length; i++){
            if(champ.getGrid()[pos[i].getX()][pos[i].getY()].getContenue() instanceof Explosable){
                switch(i){
                    case 0: p = new Position(pos[i].getX()-1,pos[i].getY());break;
                    case 1: p = new Position(pos[i].getX()+1,pos[i].getY());break;
                    case 2: p = new Position(pos[i].getX(),pos[i].getY()-1);break;
                    case 3: p = new Position(pos[i].getX(),pos[i].getY()+1);break;
                }

                break;
            }if(champ.getGrid()[pos[i].getX()][pos[i].getY()].getContenue() instanceof Pastille){

                p = pos[i];
                break;
            }
            else{
                if( champ.getGrid()[pos[i].getX()][pos[i].getY()] instanceof CaseVide){


                 int k=  r.nextInt(4);

                  while  ( !(champ.getGrid()[pos[k].getX()][pos[k].getY()] instanceof CaseVide)){
                     k=  r.nextInt(4);
                  };
                  p = pos[k];

                }
            }
        }
        champ.deplacerVers(p);

    }


    public void combat1(ChampDeBataille champ,Fighter c){
        Position[] positionAutour = new Position[9];
        positionAutour = champ.caseVoisine(c.getPosition());

        Position[] pos = new Position[9];
        Position bonnePosition;

        int nbFighter = 0;

        for(Position p : positionAutour){
            if(champ.getGrid()[p.getX()][p.getY()].getContenue() instanceof Fighter){
                pos[nbFighter] = p;
                nbFighter++;
            }
        }
        Position p;
        if(nbFighter>=1){
            //deposer bombe si reste minution
            if(c.getMinution()[0]>0){
                //on cherche la bonne position
                for(int i=0;i<pos.length;i++){
                    if(champ.getGrid()[pos[i].getX()+1][pos[i].getY()].getContenue()==null){
                        champ.placerExplosif(false, new Position(pos[i].getX()+1,pos[i].getY()), "bombe");
                        break;
                    }else if(champ.getGrid()[pos[i].getX()-1][pos[i].getY()].getContenue()==null){
                        champ.placerExplosif(false, new Position(pos[i].getX()-1,pos[i].getY()), "bombe");
                        break;
                    }else if(champ.getGrid()[pos[i].getX()][pos[i].getY()+1].getContenue()==null){
                        champ.placerExplosif(false, new Position(pos[i].getX(),pos[i].getY()+1), "bombe");
                        break;
                    }else{
                        champ.placerExplosif(false, new Position(pos[i].getX(),pos[i].getY()-1), "bombe");
                        break;
                    }
                }

            }
            //sinon deposer mine si reste minution
            else if(c.getMinution()[1]>0){
               //on cherche la bonne position
                for(int i=0;i<pos.length;i++){
                    if(champ.getGrid()[pos[i].getX()+1][pos[i].getY()].getContenue()==null){
                        champ.placerExplosif(false, new Position(pos[i].getX()+1,pos[i].getY()), "mine");
                        break;
                    }else if(champ.getGrid()[pos[i].getX()-1][pos[i].getY()].getContenue()==null){
                        champ.placerExplosif(false, new Position(pos[i].getX()-1,pos[i].getY()), "mine");
                        break;
                    }else if(champ.getGrid()[pos[i].getX()][pos[i].getY()+1].getContenue()==null){
                        champ.placerExplosif(false, new Position(pos[i].getX(),pos[i].getY()+1), "mine");
                        break;
                    }else{
                        champ.placerExplosif(false, new Position(pos[i].getX(),pos[i].getY()-1), "mine");
                        break;
                    }
                }
            }
        }else{
            //sinon deplacer
            this.deplacement(champ,c);
        }
    }

    public void combat2(ChampDeBataille champ,Fighter Fighter){


        if(Fighter.getMinution()[2]>0){
             char[] tab={'z','d','q','s'};
             for(char c :tab){


                //Position[]  tabPosTire=Fighter.tirer(c);
                Position[] tabPosTire = champ.caseSuccessive(Fighter.getPosition(), c);
                for(int i=0;i<tabPosTire.length && tabPosTire[i]!=null;i++){


                    if(tabPosTire[i].getX()<=champ.getHeight()-1 && tabPosTire[i].getY()<=champ.getHeight()-1 &&
                     tabPosTire[i].getX()>=0 && tabPosTire[i].getY()>=0) {


                        if(!(champ.getGrid()[tabPosTire[i].getX()][tabPosTire[i].getY()].getContenue() instanceof Mur)){


                            if(champ.getGrid()[tabPosTire[i].getX()][tabPosTire[i].getY()].getContenue() instanceof Fighter){
                                    Fighter.tirer();
                                    champ.tir(c);
                                    break;


                            } else{
                                continue;
                            }

                        }

                    }

                }

            }
        }
          
         else{
            Random r = new Random();
            int k=r.nextInt(2);
            if(k==0){
            this.deplacement(champ, Fighter);
            } else{
                this.combat1(champ, Fighter);
            }
        }
    }
}
