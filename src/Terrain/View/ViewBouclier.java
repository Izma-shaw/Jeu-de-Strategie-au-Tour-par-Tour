
package Terrain.View;

import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Permet de representer l'affichage d'un bouclier au niveau de l'interface graphique
 
public class ViewBouclier extends JLabel{
    private Image bouclier;
    private ImageIcon iconbouclier;

     public ViewBouclier(Position p){
           iconbouclier = new ImageIcon(getClass().getResource("../../Images/bouclier1.png"));
           this.bouclier = this.iconbouclier.getImage();
           this.setIcon(iconbouclier);
        }

        public Image getBouclier(){
            return this.bouclier;
   }

}
