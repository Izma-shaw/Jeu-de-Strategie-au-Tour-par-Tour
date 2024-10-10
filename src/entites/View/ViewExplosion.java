package entites.View;


import entites.Explosion;
import entites.Contenue;
import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewExplosion extends JLabel{
      private Image explosion;
      private ImageIcon iconexplosion;

   public ViewExplosion(Position p){
           super();
           iconexplosion = new ImageIcon(getClass().getResource("../../Images/explosion.png"));
           this.explosion = this.iconexplosion.getImage();

        }

        public Image getExplosion(){
            return this.explosion;
   }

}
