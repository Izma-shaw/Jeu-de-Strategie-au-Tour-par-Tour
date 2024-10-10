
package Terrain.View;

import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Permet de représenter l'affichage d'un Soldier dans l'interface graphique
 
public class ViewSoldier extends JLabel{
    private Image Soldier;
    private ImageIcon iconSoldier;

    public ViewSoldier(Position p){
       iconSoldier = new ImageIcon(getClass().getResource("../../Images/Soldier2.png"));
        this.Soldier = this.iconSoldier.getImage();
        this.setIcon(iconSoldier);
    }
          public Image getSoldier(){
            return this.Soldier;
   }



}
