
package Terrain.initStrategie;


import Terrain.ChampDeBataille;
import entites.Mur;
import Terrain.Fighter;
import Terrain.playerFactory.FighterFactory;
import entites.Pastille;
import Terrain.playerFactory.SniperFactory;
import Terrain.playerFactory.SoldierFactory;
import Terrain.playerFactory.BanditFactory;
import entites.Position;

import java.util.Random;


public class Init1 implements InitChampDeBataille{

    @Override
    public void init(ChampDeBataille champ) {

        Random r = new Random();

        FighterFactory cf;

        int i=0,j=0;

        int cote = 0;

        int player;


        //Cloture de murs

            for(int z=0;z<champ.getHeight();z++){
                champ.getGrid()[0][z].setContenue(new Mur(new Position(0,z)));
                 champ.getGrid()[champ.getHeight()-1][z].setContenue(new Mur(new Position(champ.getHeight()-1,z)));
            }
             for(int z=1;z<champ.getHeight()-1;z++){
                champ.getGrid()[z][0].setContenue(new Mur(new Position(z,0)));
                champ.getGrid()[z][champ.getHeight()-1].setContenue(new Mur(new Position(z,champ.getHeight()-1)));
            }

         //mise en place des murs

             for(int k=3;k<champ.getHeight()-3;k++){
                 if(k!=((champ.getHeight()-2)/2+1) &&  k!=((champ.getHeight()-2)/2) && k!=((champ.getHeight()-2)/2+2)){
                 champ.getGrid()[3][k].setContenue(new Mur(new Position(3,k)));
                 }
                 if(k!=((champ.getHeight()-2)/2+1 )&&  k!=((champ.getHeight()-2)/2) && k!=((champ.getHeight()-2)/2+2) ){
                 champ.getGrid()[k][3].setContenue(new Mur(new Position(k,3)));
                 }


                  if(k!=((champ.getHeight()-2)/2+1)&&  k!=((champ.getHeight()-2)/2) && k!=((champ.getHeight()-2)/2+2)){
                 champ.getGrid()[champ.getHeight()-5][k].setContenue(new Mur(new Position(champ.getHeight()-4,k)));
                 }
                 if(k!=((champ.getHeight()-2)/2+1)&&  k!=((champ.getHeight()-2)/2) && k!=((champ.getHeight()-2)/2+2)){
                 champ.getGrid()[k][champ.getHeight()-3].setContenue(new Mur(new Position(k,champ.getHeight()-4)));
                 }

             }
              for(int k=5;k<champ.getHeight()-3;k++){

                 champ.getGrid()[k][5].setContenue(new Mur(new Position(k,5)));

               champ.getGrid()[k][champ.getHeight()-3].setContenue(new Mur(new Position(k,champ.getHeight()-3)));


             }

        //ajouter aléatoirement les fighters  dans le tableau

        for(int k=0; k<champ.getNbFighters();k++){
            Position pos;
            i = r.nextInt(champ.getHeight());
            j = r.nextInt(champ.getHeight());
            while(champ.getGrid()[i][j].getContenue() instanceof Mur ){
                        i = r.nextInt(champ.getHeight());
                        j = r.nextInt(champ.getHeight());

            }
            pos = new Position(i,j);

            player = r.nextInt(3);

            switch(player){
                case 0:
                    cf = new SniperFactory();

                    champ.getFighter()[k] = cf.creeFighter("Sniper"+(k+1), pos);
                    champ.getGrid()[pos.getX()][pos.getY()].setContenue(champ.getFighter()[k]);break;
                case 1:
                    cf = new SoldierFactory();

                    champ.getFighter()[k] = cf.creeFighter("Soldier"+(k+1), pos);
                    champ.getGrid()[pos.getX()][pos.getY()].setContenue(champ.getFighter()[k]);break;
                case 2:
                    cf = new BanditFactory();
                    champ.getFighter()[k] = cf.creeFighter("Bandit"+(k+1), pos);
                    champ.getGrid()[pos.getX()][pos.getY()].setContenue(champ.getFighter()[k]);break;
            }



        }
        //placer de facon aléatoire les pastilles
        int nombrePastille = champ.getNbFighters();
        for(int k=0; k<nombrePastille;k++){
           i = r.nextInt(champ.getHeight());
           j = r.nextInt(champ.getHeight());
            while((champ.getGrid()[i][j].getContenue() instanceof Mur ) || (champ.getGrid()[i][j].getContenue() instanceof Fighter ) ){
                i = r.nextInt(champ.getHeight());
                j = r.nextInt(champ.getHeight());
            }
             champ.getGrid()[i][j].setContenue(new Pastille(new Position(i,j)));



        }
    }

}
