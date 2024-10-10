
package Terrain;

import Terrain.playerArme.*;
import entites.Case;
import entites.CaseVide;
import entites.Contenue;
import entites.ExplosionMine;
import entites.Explosion;
import entites.Tire;
import entites.Pastille;
import entites.Mur;
import Terrain.initStrategie.InitChampDeBataille;
import entites.Position;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

//Classe centrale représentant la grid principale du jeu
 
public class ChampDeBataille extends Observable implements Plateau{

    private final int height;

    private Fighter[] fighters ;

    private int nbFighters ;

    private Case[][] grid ;

    private int Id_playerCourant;

    private int nbTourDeJeu;

    private ArrayList<Observer> listeObserver = new ArrayList<>();

    protected InitChampDeBataille champs;
    public ChampDeBataille(InitChampDeBataille champs,int height,int nbFighters ){
       this.champs = champs;
       this.height = height ;
       this.nbFighters  = nbFighters ;
       fighters  = new Fighter[nbFighters ];
       this.Id_playerCourant = 0;
       this.nbTourDeJeu = 0 ;
       grid = new CaseVide[height][height];
       for(int x=0; x<height ;x++){
            for(int y=0;y<height;y++){
                grid[x][y] = new CaseVide(new Position(x,y));
            }
        }

    }

    // Permet d'initialiser le jeu selon une strategie bien définie
     
    public void init(){
        champs.init(this);
    }
    @Override
    public Case[][] getGrid(){
        return this.grid;
    }

    @Override
    public int getHeight(){
        return this.height;
    }

    @Override
    public Fighter[] getFighter(){
        return fighters ;
    }
    @Override
    public int getNbFighters(){
        return nbFighters ;
    }

    @Override
    public int getIdplayerCourant(){
        return Id_playerCourant;
    }
    @Override
    public ArrayList<Observer> getListObserver(){
        return this.listeObserver;
    }

    private void afficheChampDeBataille(){
        for(int i=0; i<height;i++){
            for(int j=0; j<height; j++){
                if(this.grid[i][j].getContenue() instanceof Mur)
                    System.out.print("#");
                if(this.grid[i][j].getContenue() instanceof Soldier)
                    System.out.print("m");
                if(this.grid[i][j].getContenue() instanceof Bandit)
                    System.out.print("r");
                if(this.grid[i][j].getContenue() instanceof Sniper)
                    System.out.print("s");
                if(this.grid[i][j].getContenue() instanceof Pastille)
                    System.out.print("+");
                if(this.grid[i][j].getContenue() instanceof MineInvisible)
                    System.out.print(".");
                 if(this.grid[i][j].getContenue() instanceof MineVisible)
                    System.out.print("M");
                if(this.grid[i][j].getContenue() instanceof BombeVisible)
                    System.out.print("B");
                if(this.grid[i][j].getContenue() instanceof BombeInvisible)
                    System.out.print(".");
                if(this.grid[i][j].getContenue() instanceof Explosion)
                    System.out.print("e");
                if(this.grid[i][j].getContenue() instanceof ExplosionMine)
                    System.out.print("k");
                if(this.grid[i][j].getContenue() instanceof Tire)
                    System.out.print("t");
                if(this.grid[i][j].getContenue() instanceof Bouclier)
                    System.out.print("*");
               if(this.grid[i][j].getContenue()==null)
                    System.out.print(".");

            }
            System.out.println();
        }
    }
    @Override
    public String toString(){
        this.afficheChampDeBataille();
        return "";
    }
    //Retourne la position du Fighter ayant le tour
    public Position FighterPosition(){
        return this.fighters [Id_playerCourant].getPosition();
    }


    // Permet de faire une correspondance entre le caractere pass� en parametre et la position finale en fonction de la position courante
     
    public Position posDestination(char c){
        Position p = FighterPosition();
        switch(c){
            case 'z': return new Position(p.getX()-1,p.getY());
            case 's': return new Position(p.getX()+1,p.getY());
            case 'd': return new Position(p.getX(),p.getY()+1);
            case 'q': return new Position(p.getX(),p.getY()-1);
        }
        return null;
    }


    // Teste si un deplacement du player courant est possible vers une destination de position posDest
     
    public boolean estDeplacable(Position posDest){
        return !((this.grid[posDest.getX()][posDest.getY()].getContenue() instanceof Mur)
                ||
                (this.grid[posDest.getX()][posDest.getY()].getContenue() instanceof Fighter));
    }

    // Permet de deplacer un player vers la position passée en paramètre
     
    public void deplacerVers(Position posDest){

        int i = Id_playerCourant;

        if(estDeplacable(posDest)){

            //teste si dans la case destination il y'a une pastille
            if(this.grid[posDest.getX()][posDest.getY()].getContenue() instanceof Pastille){
                //le Fighter recupere l'energie de la pastille
                this.fighters [i].gainEnergie(Pastille.ENERGIE_MAX);
                //le nouveau contenu de la case d'arrivée change
                this.grid[posDest.getX()][posDest.getY()].setContenue(this.fighters [i]);
                //le contenu de la case de depart change (a� null ne contient plus rien)
                this.grid[this.fighters [i].getPosition().getX()][this.fighters [i].getPosition().getY()].setContenue(null);
                //Appel de la methode deplacer du player
                fighters [i].seDeplace(posDest);
            }
            //teste si la case d'arrivée contient une mine
            else if(this.grid[posDest.getX()][posDest.getY()].getContenue() instanceof Mine){
                    //Si oui le Fighter perd une quantite d'energie egale au puissance de la mine
                    this.fighters [i].perteEnergie(Mine.PUISSANCE_MAX);
                    //le nouveau contenu de la case d'arrivée change
                    this.grid[posDest.getX()][posDest.getY()].setContenue(new ExplosionMine());
                    //le contenue de la case de depart change à null
                    this.grid[this.fighters [i].getPosition().getX()][this.fighters [i].getPosition().getY()].setContenue(null);
                    //Appel de la methode deplacer du player
                    fighters [i].seDeplace(posDest);
            }
            //teste si dans la case de destination il y'a une bombe
            else if(this.grid[posDest.getX()][posDest.getY()].getContenue() instanceof Bombe){
                    //Si oui le Fighter perd une quantite d'energie egale au puissance de la bombe

                    //change le contenu de la case d'arrivée
                    this.grid[posDest.getX()][posDest.getY()].setContenue(new Explosion());
                    //gére l'affichage de l'explosion
                    this.afficheExplosion(posDest);
                    //Appel de la methode deplacer du player
                    fighters [i].seDeplace(posDest);
            }
            //teste si la case de destination est une case vide
            else if(this.grid[posDest.getX()][posDest.getY()].getContenue()==null){
                    //si Oui le contenu de cette case change
                    this.grid[posDest.getX()][posDest.getY()].setContenue(this.fighters [i]);
                    //le contenue de la case de depart change à null
                    this.grid[this.fighters [i].getPosition().getX()][this.fighters [i].getPosition().getY()].setContenue(null);
                    //Appel de la methode du player
                    fighters [i].seDeplace(posDest);
            }
        }


    }

    private void afficheExplosion(Position posDest){
        if(!(this.grid[posDest.getX()+1][posDest.getY()].getContenue() instanceof Mur))
            this.grid[posDest.getX()+1][posDest.getY()].setContenue(new Explosion());

        if(!(this.grid[posDest.getX()-1][posDest.getY()].getContenue() instanceof Mur))
            this.grid[posDest.getX()-1][posDest.getY()].setContenue(new Explosion());

        if(!(this.grid[posDest.getX()][posDest.getY()+1].getContenue() instanceof Mur))
            this.grid[posDest.getX()][posDest.getY()+1].setContenue(new Explosion());

        if(!(this.grid[posDest.getX()][posDest.getY()-1].getContenue() instanceof Mur))
            this.grid[posDest.getX()][posDest.getY()-1].setContenue(new Explosion());

        if(!(this.grid[posDest.getX()+1][posDest.getY()+1].getContenue() instanceof Mur))
            this.grid[posDest.getX()+1][posDest.getY()+1].setContenue(new Explosion());

        if(!(this.grid[posDest.getX()+1][posDest.getY()-1].getContenue() instanceof Mur))
            this.grid[posDest.getX()+1][posDest.getY()-1].setContenue(new Explosion());

        if(!(this.grid[posDest.getX()-1][posDest.getY()-1].getContenue() instanceof Mur))
            this.grid[posDest.getX()-1][posDest.getY()-1].setContenue(new Explosion());

        if(!(this.grid[posDest.getX()-1][posDest.getY()+1].getContenue() instanceof Mur))
            this.grid[posDest.getX()-1][posDest.getY()+1].setContenue(new Explosion());

    }
    @Override
    public void nextPlayer(){

        if(this.Id_playerCourant<(this.nbFighters -1)){
            this.Id_playerCourant = this.Id_playerCourant+1;
        }
        else
            this.Id_playerCourant=0;
    }

    @Override
    public void playGame(){

        while(!fin()){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }

            afficheChampDeBataille();

            System.out.println(this.fighters [Id_playerCourant].caracteristiqueCourant());

            teste();
            fighters [Id_playerCourant].action(this);

            testeMort();

            this.notifyObservers();

            nextPlayer();


        }

    }


     // Gere l'impact du tir dans la grid
    
    public void tireImpact(Position[] listPositionTirees){

        for (Position position : listPositionTirees) {
                //teste si la position courante correspond a un mur
                if(this.grid[position.getX()][position.getY()].getContenue() instanceof Mur){
                    break;
                }
                //teste si cette position position correspond a un Fighter dans la grid
                if(this.grid[position.getX()][position.getY()].getContenue() instanceof Fighter){
                    //si oui on recupere le Fighter correspondant
                    for(int k=0; k<nbFighters ;k++){
                        if(this.grid[position.getX()][position.getY()].getContenue().equals(fighters [k])){
                            //le Fighter perd une quantite d'energie egale au puissance du pistolet
                            fighters [k].perteEnergie(Pistolet.PUISSANCE_MAX);
                        }
                    }
                }
               else {
                    //on represente l'affichage du tir
                    this.grid[position.getX()][position.getY()].setContenue(new Tire());

                }
            }

    }

    public void explosionImpact(Explosable exp,Position[] listCaseBombarde){

        Position p;

        //On parcours la liste des cases concernées
        for (Position position : listCaseBombarde) {
            //recupere la position de la case courante dans p
            p = position;
            //teste si la case courante contient un mur
            if(this.grid[p.getX()][p.getY()].getContenue() instanceof Mur){
                //explosion touche pas mur
            }
            //teste si la case courante contient un Fighter
            else if(this.grid[p.getX()][p.getY()].getContenue() instanceof Fighter){
                //on parcours le tableau contenant tous les fighters
                for(Fighter c : this.fighters ){
                    if(c.equals(this.grid[p.getX()][p.getY()].getContenue())){
                        //le Fighter perd une quantite d'energie egale au puissance de la bombe
                        c.perteEnergie(Bombe.PUISSANCE_MAX);
                    }
                }
                this.grid[p.getX()][p.getY()].setContenue(new ExplosionMine());
            }
            else{
                this.grid[p.getX()][p.getY()].setContenue(new Explosion());
            }
        }
    }



    @Override
    public void placerExplosif(boolean visibilite,Position p,String typeExplosif){

         Explosable expl=null;

         //teste si la position correspondant à b est autre qu'un mur ou Fighter
         if(this.estDeplacable(p)){

            //si l'explosif est marquée visible
            if(visibilite==true){
               if(typeExplosif.equalsIgnoreCase("bombe")){
                   //expl = new BombeVisible();
                   expl = this.fighters [Id_playerCourant].deposerBombe(visibilite,p);
                   //this.grid[p.getX()][p.getY()].setContenue(expl);
               }
               else{
                   //expl = new MineVisible();
                   expl = this.fighters [Id_playerCourant].deposerMine(visibilite, p);
                   //this.grid[p.getX()][p.getY()].setContenue(expl);
               }
               //on affiche l'explosif dans la grid
               this.grid[p.getX()][p.getY()].setContenue(expl);
            }
            else if(visibilite==false){
                if(typeExplosif.equalsIgnoreCase("bombe")){

                   expl = this.fighters [Id_playerCourant].deposerBombe(visibilite,p);

               }
               else if(typeExplosif.equalsIgnoreCase("mine")){

                   expl = this.fighters [Id_playerCourant].deposerMine(visibilite, p);
                  
               }
                //l'explosif ne sera pas visible dans la grid
                this.grid[p.getX()][p.getY()].setContenue(expl);
            }

         }
         fighters [Id_playerCourant].getExplosifsDepose().add(expl);
         notifyObservers();
    }




    @Override
    public void teste(){

        Bombe b;

        //teste si pour le bouclier du Fighter qui doit jouer vaut true
        if(fighters [Id_playerCourant].getBouclier().getEtat()==true){
            //si le bouclier est actif on decremente la duree de protection du bouclier
            fighters [Id_playerCourant].getBouclier().decrementeDuree();
            //teste si la duree de proection du bouclier est termine
            if(fighters [Id_playerCourant].getBouclier().getDuree()==0){
                //si oui on desactive le bouclier
                fighters [Id_playerCourant].getBouclier().setEtat(false);
            }
            //sinon on met à jour le bouclier avec la nouvelle position du Fighter
            else if(fighters [Id_playerCourant].getBouclier().getDuree()>0){
                bouclier();
            }
        }
        //nettoie le champ apres explosion ou tir
        for(int i=0;i<this.height;i++){
            for(int j=0;j<this.height;j++){
                if(this.grid[i][j].getContenue() instanceof Explosion){
                    this.grid[i][j].setContenue(null);
                }
                else if(this.grid[i][j].getContenue() instanceof Tire){
                    this.grid[i][j].setContenue(null);
                }
            }
        }
        //affiche l'explosion dans le champ
        for(int i =0;i<this.height;i++){
            for(int j=0;j<this.height;j++){
                //teste si  la case courante contient une bombe
                if(this.grid[i][j].getContenue() instanceof Bombe){
                    b = (Bombe) this.grid[i][j].getContenue();
                    //teste son compte a rebours
                    if(b.getCompteARebours()==0){
                        explosionImpact(b,this.caseVoisine(b.getPosition()));
                    }
                    //sinon on decremente son compte a rebours
                    else{
                        b.decremente();
                    }
                }
            }
        }

        notifyObservers();
    }


    /**
     * Teste si le jeu est terminé ou pas
     * @return True si leu est fini et false sinon
     */
     public boolean fin(){
        int k=0;
        for(int i=0;i<nbFighters ; i++){
            if(this.fighters [i].getEnergie()<=0)
                k++;
        }
        return ((nbFighters -k)==1);
    }




    @Override
    public void tir(char direction){

        if(!(this.fighters [Id_playerCourant] instanceof Bandit)){

            tireImpact(this.caseSuccessive(this.fighters [Id_playerCourant].getPosition(), direction));
        }
        else{
             deplacerVers(posDestination(direction));
        }

    }

    public void bouclier(){

        Bouclier bouclier = fighters [Id_playerCourant].getBouclier();

        Position p = fighters [Id_playerCourant].getPosition();

        this.grid[p.getX()][p.getY()].setContenue(bouclier);


    }
    @Override
    public void addObserver(Observer obs){
        this.listeObserver.add(obs);
    }

    @Override
    public void notifyObservers(){
       for(Observer obs : this.listeObserver){
           obs.update(this, obs);
       }
   }

    @Override
    public void init(ChampDeBataille champ) {
    }
    @Override
    public Contenue getContenue(Position p) {
        return this.grid[p.getX()][p.getY()].getContenue();
    }

    /**
     * Donne la position des 8 cases voisines de la position passée en paramètre
     * @param position Position courante
     * @return Un tableau contenant les 8 cases voisines de la position en paramètre
     */
     public Position[] caseVoisine(Position position){

        Position voisines[] = new Position[9];

        voisines[0] = new Position(position.getX(),position.getY());
        voisines[1] = new Position(position.getX()+1,position.getY());
        voisines[2] = new Position(position.getX()-1,position.getY());
        voisines[3] = new Position(position.getX(),position.getY()+1);
        voisines[4] = new Position(position.getX(),position.getY()-1);
        voisines[5] = new Position(position.getX()+1,position.getY()+1);
        voisines[6] = new Position(position.getX()-1,position.getY()-1);
        voisines[7] = new Position(position.getX()+1,position.getY()-1);
        voisines[8] = new Position(position.getX()-1,position.getY()+1);

        return voisines;
    }

     public Position[] caseSuccessive(Position p,char direction){
        Position[] cases= new Position[Pistolet.PORTEE_MAX];
        int k;
        if(direction=='z'){
                for(int i=0;i<Pistolet.PORTEE_MAX;i++){

                    cases[i] = new Position(p.getX()-(i+1),p.getY());

                }
            }
            else if(direction=='s'){
                k=0;
                for(int i=0;i<Pistolet.PORTEE_MAX;i++){

                    cases[i] = new Position(p.getX()+(i+1),p.getY());

                }
            }
            else if(direction=='q'){

                for(int i=0;i<Pistolet.PORTEE_MAX;i++){

                    cases[i] = new Position(p.getX(),p.getY()-(i+1));

                }
            }

            else if(direction=='d'){

                for(int i=0;i<Pistolet.PORTEE_MAX;i++){

                    cases[i] = new Position(p.getX(),p.getY()+(i+1));

                }
            }
        return cases;
     }

     public void testeMort(){
        //teste Fighter
        Fighter[] copie = new Fighter[this.nbFighters ];
        int k=0,mort=0;
        for (Fighter Fighter : this.fighters ) {
            if (Fighter.getEnergie() > 0) {
                //on recupere le Fighter
                copie[k] = Fighter;
                k++;
            }
            else if(Fighter.getEnergie()<=0){
                mort+=1;
                this.grid[Fighter.getPosition().getX()][Fighter.getPosition().getY()].setContenue(null);
            }
        }
        if(mort>=1){
            this.nbFighters  = this.nbFighters  - mort;
            fighters  = new Fighter[this.nbFighters ];
            for(int i=0;i<fighters .length;i++){
                fighters [i] = copie[i];
            }
        }
     }
}
