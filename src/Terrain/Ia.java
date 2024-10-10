package Terrain;

import Terrain.playerArme.Mine;
import Terrain.playerArme.Explosable;
import entites.Mur;
import entites.Position;

public class Ia<T> {
    //actions possible


    int[][] zoneDeDanger;
    boolean pasDeMine=false;

    public Ia(ChampDeBataille champ){

       this.zoneDeDanger= new int[champ.getHeight()][champ.getHeight()];
           for(int i=0;i<champ.getHeight();i++){
            for(int j=0;j<champ.getHeight();j++){
                this.zoneDeDanger[i][j]=0;
            }
           }

    }


    public int[] decision(ChampDeBataille champ ,Fighter Fighter){

        int[] tabDecision=new int[4];

        Position[] posTire= new Position[champ.getNbFighters()];

        for(int i=0;i<champ.getHeight();i++){
            for(int j=0;j<champ.getHeight();j++){
                if(champ.getGrid()[i][j].getContenue() instanceof Fighter ){
                    this.zoneDeDanger[i][j]=1;
                } else if(champ.getGrid()[i][j].getContenue() instanceof Explosable){
                    //case qui contient des Explosable
                    if(champ.getGrid()[i][j].getContenue() instanceof Mine){
                        pasDeMine=true;
                    }
                   // Explosable exp=(Explosable) champ.getGrid()[i][j].getContenue();
                   Position[] p =champ.caseVoisine(champ.getGrid()[i][j].getPosition());
                    for (Position p1 : p) {
                        this.zoneDeDanger[p1.getX()][p1.getY()] = 2;
                    }
                }
            }
        }

        char[] tab={'z','d','q','s'};

        if(!(Fighter instanceof Bandit)){

            for(char c :tab){

                //Position[]  tabPosTire=Fighter.tirer(c);
                Position[] tabPosTire = champ.caseSuccessive(Fighter.getPosition(), c);
                for(int i=0;i<tabPosTire.length && tabPosTire[i]!=null;i++){


                    if(tabPosTire[i].getX()<=champ.getHeight()-1 && tabPosTire[i].getY()<=champ.getHeight()-1 &&
                     tabPosTire[i].getX()>=0 && tabPosTire[i].getY()>=0) {


                        if((champ.getGrid()[tabPosTire[i].getX()][tabPosTire[i].getY()].getContenue() instanceof Mur)){
                                break;}
                        else{

                            if(champ.getGrid()[tabPosTire[i].getX()][tabPosTire[i].getY()].getContenue() instanceof Fighter){


                                tabDecision[3]++;


                            }

                        }

                    }

                }

            }

        }




        Position[] p1= champ.caseVoisine(Fighter.getPosition());

        for(Position p2:p1){

            if(this.zoneDeDanger[p2.getX()][p2.getY()]==0){

                tabDecision[0]++;

            }else if(this.zoneDeDanger[p2.getX()][p2.getY()]==1){

                tabDecision[1]++;

            }else if(this.zoneDeDanger[p2.getX()][p2.getY()]==2){

                tabDecision[2]++;

            }



        }


        return tabDecision;

    }

      public String applicationDecisionSniper(ChampDeBataille champ ,Fighter Fighter){

         int[] tabDecision=this.decision(champ, Fighter);

         if(tabDecision[3]>=1 && tabDecision[2]==0){

             return "tire";

         }

         if(tabDecision[1]>=3 && tabDecision[2]==0){

             return "explosif";

         }else if(tabDecision[2]>=1 && !pasDeMine){

              //return "deplacer";
              return "bouclier";

         }
         else{
             return "deplacer";
             //return "bouclier";
         }
     }
     public String applicationDecisionBandit(ChampDeBataille champ ,Fighter Fighter){

         int[] tabDecision=this.decision(champ, Fighter);



         if(tabDecision[1]>=2 && tabDecision[2]==0){

             return "explosif";

         }else if(tabDecision[1]>=5){

              //return "deplacer";
              return "deplacer";

         }
         else if(tabDecision[2]==2){
             return "bouclier";
         }
         else{
             return "deplacer";
             //return "bouclier";
         }
     }

     public String applicationDecisionSoldier(ChampDeBataille champ ,Fighter Fighter){

         int[] tabDecision=this.decision(champ, Fighter);

         if(tabDecision[3]>=1 && tabDecision[2]==0){

             return "tire";

         }

         if(tabDecision[1]>=3 && tabDecision[2]==0){

             return "explosif";

         }else if(tabDecision[2]>=1){


              return "bouclier";

         }
         else{
             return "deplacer";
             
         }
     }




}
