package entites.View;

import entites.CaseVide;
import entites.Position;
import java.awt.Color;
import java.awt.Container;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuComponent;
import java.awt.MenuContainer;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCaseVide extends CaseVide{


        private Image casevide;
        private ImageIcon iconcasevide;

        public ViewCaseVide(Position p) {
           super(p);

           iconcasevide = new ImageIcon(getClass().getResource("../../Images/casevide1.png"));
           this.casevide = this.iconcasevide.getImage();

        }

        public Image getCaseVide(){
            return this.casevide;
        }
        public void setImage(Image img){
            this.casevide=img;
        }

    }
