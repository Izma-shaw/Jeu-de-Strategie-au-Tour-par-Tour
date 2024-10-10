
package Terrain.playerArme;

import entites.Contenue;

//Cette classe permet l'utilisation de bouclier par les différents Fighters
 
public class Bouclier implements Contenue{

    private Boolean etat;
    private static final int DUREE_PROTECTION = 5;
    private int duree;

    public Bouclier() {
        this.etat = false;
        this.duree = DUREE_PROTECTION;
    }
    // Permet de connaitre l'etat du bouclier.Si le bouclier est actif cette variable vaudra True et False sinon
     
    public Boolean getEtat() {
        return etat;
    }
 
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
    
    public void decrementeDuree(){
        this.duree -= 1;
    }
    
    public int getDuree(){
        return duree;
    }
}
