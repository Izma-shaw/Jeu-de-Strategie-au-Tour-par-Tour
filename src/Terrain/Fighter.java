
package Terrain;

import Terrain.playerArme.*;
import entites.Contenue;
import Terrain.initStrategie.StrategieFighter;
import entites.Position;
import java.util.ArrayList;

public abstract class Fighter implements Contenue{

    private StrategieFighter strategie;
    private static final int COUT_DEPLACEMENT = 2;
    private static final int COUT_BOUCLIER = 5;

    protected String pseudo;
    protected int energie;
    protected Bouclier bouclier;
    protected Position position;
    protected Arme[] armes;
    private ArrayList<Explosable> explosifsDepose;
    protected int[] minution;

    public Fighter(StrategieFighter strategie, String pseudo, Position position){

        this.strategie = strategie;
        this.pseudo = pseudo;
        this.bouclier = new Bouclier();
        this.position = position;
        explosifsDepose = new ArrayList<>();
    }
 
    public void action(ChampDeBataille champ){
        this.strategie.action(champ, this);

    }
    public String decision(){
        return this.strategie.getDecision();
    }
       public void seDeplace(Position position){
        this.setPosition(position);
        this.perteEnergie(COUT_DEPLACEMENT);
    }

    public void activeBouclier(){
        this.bouclier.setEtat(true);
        this.energie -= COUT_BOUCLIER;
    }
   
    public ArrayList<Explosable> getExplosifsDepose() {
        return explosifsDepose;
    }
    
    public Bombe deposerBombe(boolean visibilite,Position p){
        Bombe b=null;

        if(minution[0]>0){

            this.minution[0] -= 1;

            if(visibilite==true)
                b = new BombeVisible();
            else
                b = new BombeInvisible();

            b.activerExplosif(p);

            return b;

        }

        return null;
    }
   
    public Mine deposerMine(boolean visibilite, Position p){
        Mine m = null;

        if(minution[1]>0){

            this.minution[1] -= 1;

            if(visibilite==true)
                m = new MineVisible();
            else if(visibilite==false)
                m = new MineInvisible();

            m.activerExplosif(p);

            return m;

        }

        return null;
    }
  
    public void tirer(){
        minution[2] -= 1;
    }
 
    public void setPosition(Position position) {
        this.position = position;
    }
 
    public abstract void chargerArme();
  
    public abstract void gainEnergie(int energie);
    // Permet de diminuer l'energie du player par la variable passee en parametre.
  
    public void perteEnergie(int perte){
        if(this.bouclier.getEtat()==false){
            if(this.energie<=0)
                this.energie = 0;
            else
                this.energie -= perte;
        }
    }

   // Donne le pseudo du player
    
    public String getPseudo() {
        return pseudo;
    }

    // Donne la quantité d'energie courante du player
    
    public int getEnergie() {
        return energie;
    }

    // Retourne nn tableau contenant la liste des armes disponibles pour un player
     
    public Arme[] getArme() {
        return this.armes;
    }
   //  Retourne nn tableau contenant la liste des minutions pour chaque arme
     
    public int[] getMinution(){
        return this.minution;
    }
    // Retourne le bouclier du player pour se proteger des attaques adverses
  
    public Bouclier getBouclier() {
        return bouclier;
    }

    public Position getPosition() {
        return position;
    }
  // Retourne return une chaine représentant la quantité d'energie, les armes du player et leur minution
     
    public static String caracteristique(){
        System.out.println("------------------------------------------------------");
        return "CARACTERISTIQUES \tEnergie\tBombes\tMines\tBalles\n";
    }
    // Retourne les caractéristiques courantes du player
    
    public abstract String caracteristiqueCourant();
}
