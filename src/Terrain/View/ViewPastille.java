
package Terrain.View;

import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Permet de représenter l'affichage de la pastille dans l'interface graphique
 
public class ViewPastille extends JLabel {
    private Image pastille;
    private ImageIcon iconpastille;

    public ViewPastille(Position p){
        iconpastille = new ImageIcon(getClass().getResource("../../Images/pastille1.png"));
        this.pastille = this.iconpastille.getImage();
        this.setIcon(iconpastille);
    }
          public Image getPastille(){
            return this.pastille;
   }

}
