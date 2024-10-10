package Main;


import Terrain.View.Fenetre;
import Terrain.View.ViewChampDeBataille;
import Terrain.View.FenetreDialogue;
import Terrain.View.ViewPrincipale;
import Terrain.ChampDeBataille;
import Terrain.ChampDeBatailleProxy;
import Terrain.Plateau;
import Terrain.initStrategie.Init1;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws InterruptedException {

        label : do{

            int nb=0;
            Scanner sc = new Scanner(System.in);

            Fenetre fen;



            while(nb<2 || nb>6){
                String nbcom=FenetreDialogue.nombreFighter();
                nb=Integer.parseInt(nbcom);
            }

            Fenetre fenetresProxy[] = new Fenetre[nb];

            ChampDeBataille champ = new ChampDeBataille(new Init1(),13,nb);
            champ.init();
            ViewChampDeBataille p = new  ViewChampDeBataille(champ);



            ViewPrincipale View = new ViewPrincipale(p);


            Plateau[] proxy = new ChampDeBatailleProxy[champ.getNbFighters()];

            for(int i =0;i<champ.getNbFighters();i++){
                //proxy
                proxy[i] = new ChampDeBatailleProxy(champ,champ.getFighter()[i]);
            }



            int option = FenetreDialogue.launch();
            String gagnant="";
            switch(option){
                case 1:

                     champ.playGame();break;

                case 0:

                    fen = new Fenetre(View,champ);

                    for(int i =0;i<champ.getNbFighters();i++){
                        ViewPrincipale View1 =  new ViewPrincipale(new ViewChampDeBataille(proxy[i]));

                         fenetresProxy[i] = new Fenetre(View1,proxy[i]);
                         fenetresProxy[i].setTitle("Fighter "+champ.getFighter()[i].getPseudo());
                         proxy[i].addObserver(View1);

                    }

                    champ.playGame();
                    gagnant = champ.getFighter()[0].getPseudo();
                    option = FenetreDialogue.Information(gagnant);
                    switch(option){
                        case 0:
                            //on recommence l'execution;
                            ;break;
                        case 1:
                            fen.dispose();
                            for(Fenetre fenetre : fenetresProxy){
                                fenetre.dispose();
                            }
                            break label;
                    }
                    for(Fenetre fenetre : fenetresProxy){
                        fenetre.dispose();
                    }
                    fen.dispose();
                    break;
                default: break;
            }
       }while(true);
    }
}
