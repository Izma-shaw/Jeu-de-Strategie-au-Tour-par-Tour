
package Terrain.playerArme;


//Cette classe permet de représenter les differents types d'armes que possèdent un Fighter
 
public abstract class Arme {

    protected String type;
    protected int puissance;
    protected int portee;


    // retourne le type de l'arme
  
    public String getType() {
        return type;
    }

    // Retourne la puissance de l'arme
     
    public int getPuissance() {
        return puissance;
    }

    // Retourne la portée de l'arme
    
    public int getPortee() {
        return portee;
    }
    // Modifie la puissance de l'arme par la puissance passée en paramètre
 
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    //Modifie la portée de l'arme par la portée passée en paramètre
 
    public void setPortee(int portee) {
        this.portee = portee;
    }
}
