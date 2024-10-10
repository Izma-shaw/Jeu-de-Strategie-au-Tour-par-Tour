package Terrain.View;

import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Permet de représenter l'affichage d'une mine au niveau de l'interface graphique
 
public class ViewMine extends JLabel{
    private Image mine;
    private ImageIcon iconmine;

     public ViewMine(Position p){
           iconmine = new ImageIcon(getClass().getResource("../../Images/mine1.png"));
           this.mine = this.iconmine.getImage();
           this.setIcon(iconmine);
        }

        public Image getMine(){
            return this.mine;
   }
}
