package entites.View;

import entites.Mur;
import entites.Position;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

    public class ViewMur extends Mur{

        private Image mur;
        private ImageIcon iconMur;

        public ViewMur(Position p) {
           super(p);
           iconMur = new ImageIcon(getClass().getResource("../../Images/mur1.png"));
           this.mur = this.iconMur.getImage();


        }

        public Image getMur(){
            return this.mur;
        }
    }
