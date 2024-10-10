
package entites;

// //Represente une entite a la contraire  de la grille
public class CaseVide extends Case{


    public CaseVide(Position p){
        super(p);
        contenue = null;
    }


    @Override
    public Contenue getContenue() {
        return contenue;
    }

    @Override
    public void setContenue(Contenue contenue) {
        this.contenue = contenue;
    }
}
