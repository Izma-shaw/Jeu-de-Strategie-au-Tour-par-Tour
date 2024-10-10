
package entites;

//Represente une entite de la grille
 
public abstract class Case implements Conteneur{
    //Represente la position de la case dans la grille
     
    protected Position position;
   // Represente le contenu de la case
   
    protected Contenue contenue;

    public Case(Position p){
        this.position = p;
        this.contenue = null;
    }

    public Position getPosition(){
        return this.position;
    }

    
    public abstract Contenue getContenue();
  
    public abstract void setContenue(Contenue contenue);
}
