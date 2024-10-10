package entites.View;


import entites.Position;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewTire extends JLabel{
     private Image tire;
      private ImageIcon icontire;

   public ViewTire(Position p){
           super();
           icontire = new ImageIcon(getClass().getResource("../../Images/tire.png"));
           this.tire = this.icontire.getImage();

        }

        public Image getTire(){
            return this.tire;
   }
}
