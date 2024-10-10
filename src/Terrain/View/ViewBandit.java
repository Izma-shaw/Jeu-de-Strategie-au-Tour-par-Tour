
package Terrain.View;
import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Permet de représenter l'affichage d'un Fighter Bandit dans l'interface graphique

public class ViewBandit extends JLabel{
    private Image Bandit;
    private ImageIcon iconBandit;

    public ViewBandit(Position p){
        iconBandit = new ImageIcon(getClass().getResource("../../Images/Bandit2.png"));
        this.Bandit = this.iconBandit.getImage();
        this.setIcon(iconBandit);
    }
          public Image getBandit(){
            return this.Bandit;
   }


}
