package entites.View;


import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewExplosionMine extends JLabel{
       private Image explosionmine;
      private ImageIcon iconexplosionmine;

   public ViewExplosionMine(Position p){
           super();
           iconexplosionmine = new ImageIcon(getClass().getResource("../../Images/explosionmine.png"));
           this.explosionmine = this.iconexplosionmine.getImage();

        }



        public Image getExplosionMine(){
            return this.explosionmine;
   }
}
