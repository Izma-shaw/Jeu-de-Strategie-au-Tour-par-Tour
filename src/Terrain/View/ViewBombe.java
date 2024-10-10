
package Terrain.View;

import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Represente la View pour une bombe dans l'interface graphique
 
public class ViewBombe extends JLabel{
   private Image bombe;
   private ImageIcon iconbombe;

   public ViewBombe(Position p){
           super();
           iconbombe = new ImageIcon(getClass().getResource("../../Images/bombe1.png"));
           this.bombe = this.iconbombe.getImage();
           this.setIcon(iconbombe);
        }

        public Image getBombe(){
            return this.bombe;
   }

}
