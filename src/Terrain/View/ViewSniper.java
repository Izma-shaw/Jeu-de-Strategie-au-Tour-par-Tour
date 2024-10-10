
package Terrain.View;

import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Permet de representer l'affichage d'un sniper dans l'interface graphique
 
public class ViewSniper extends JLabel {
    private Image sniper;
    private ImageIcon iconsniper;

    public ViewSniper(Position p){
        super();
        iconsniper = new ImageIcon(getClass().getResource("../../Images/sniper1.png"));
        this.sniper = this.iconsniper.getImage();
        this.setIcon(iconsniper);
    }
          public Image getSniper(){
            return this.sniper;
   }





}
