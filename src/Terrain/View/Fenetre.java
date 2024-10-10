
package Terrain.View;

import Terrain.Plateau;
import javax.swing.JFrame;

public class Fenetre  extends JFrame {
    ViewPrincipale ViewBomberman;
    Plateau champdebataille;

    public Fenetre(ViewPrincipale ViewBomberman,Plateau champdebataille){


        this.setTitle("TERRAIN");

        this.champdebataille=champdebataille;

        this.ViewBomberman=ViewBomberman;

        this.setContentPane(this.ViewBomberman);

        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        champdebataille.addObserver(ViewBomberman);

        this.setVisible(true);
    }

}
