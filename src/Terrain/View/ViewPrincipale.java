
package Terrain.View;

import Terrain.FighterGroupeImpl;
import Terrain.FighterGroupe;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class ViewPrincipale  extends JPanel  implements Observer{


   private ViewChampDeBataille p;
   private JTable table;
   private FighterGroupeToTableModelAdapter modelAdapter;
   private JPanel right,north,south,left;
   FighterGroupe gc;

    public ViewPrincipale(ViewChampDeBataille p){

        this.p = p;
         gc = new FighterGroupeImpl();

        for(int i=0;i<p.getChampdebataille().getNbFighters();i++){
            gc.add(p.getChampdebataille().getFighter()[i]);
        }
        modelAdapter = new FighterGroupeToTableModelAdapter(gc);

        table = new JTable(modelAdapter);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setSize(100, 100);
        table.setGridColor(Color.BLACK);
        table.setBackground(Color.WHITE);

        this.setLayout(new BorderLayout(10,25));

        init();
    }

    public void updateTable(){
        modelAdapter.gc = new FighterGroupeImpl();
        for(int i=0;i<p.getChampdebataille().getNbFighters();i++){
            modelAdapter.gc.add(p.getChampdebataille().getFighter()[i]);
        }


    }
    public void init(){

        north = new JPanel();
        south = new JPanel();
        right = new JPanel();
        left = new JPanel();
        left.setSize(100,100);

        south.setBackground(Color.RED);
        north.setBackground(Color.RED);
        right.setBackground(Color.RED);
        right.setLayout(new GridLayout(2,1));

        JPanel panel1 = new JPanel();
        table.getSelectionModel().addSelectionInterval(0, 0);
        table.setFont(new Font("Calibri", Font.PLAIN, 16));
        table.setRowSelectionAllowed(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBackground(Color.BLACK);

        panel1.add(table.getTableHeader());
        panel1.add(scroll);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);
        panel2.setLayout(new GridLayout(4,4));

        JLabel l0 = new JLabel("LEGENDE");
        l0.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,15));
        panel2.add(l0);
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));
        panel2.add(new JLabel(""));


        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel l6 = new JLabel();
        JLabel l7 = new JLabel();
        JLabel l8 = new JLabel();
        JLabel l9 = new JLabel();

        l1.setIcon(new ImageIcon(getClass().getResource("../../Images/bandit2.png")));
        l2.setIcon(new ImageIcon(getClass().getResource("../../Images/sniper1.png")));
        l3.setIcon(new ImageIcon(getClass().getResource("../../Images/soldier2.png")));
        l4.setIcon(new ImageIcon(getClass().getResource("../../Images/pastille1.png")));
        l5.setIcon(new ImageIcon(getClass().getResource("../../Images/bombe1.png")));
        l6.setIcon(new ImageIcon(getClass().getResource("../../Images/bouclier1.png")));
        l7.setIcon(new ImageIcon(getClass().getResource("../../Images/mine1.png")));
        l8.setIcon(new ImageIcon(getClass().getResource("../../Images/explosion.png")));
        l9.setIcon(new ImageIcon(getClass().getResource("../../Images/explosionmine.png")));

        panel2.add(l1);
        panel2.add(new JLabel("Bandit"));

        panel2.add(l2);
        panel2.add(new JLabel("Sniper"));

        panel2.add(l3);
        panel2.add(new JLabel("Soldier"));

        panel2.add(l4);
        panel2.add(new JLabel("Pastille"));

        panel2.add(l5);
        panel2.add(new JLabel("Bombe"));

        panel2.add(l6);
        panel2.add(new JLabel("Bouclier"));

        panel2.add(l7);
        panel2.add(new JLabel("Mine"));

        panel2.add(l8);
        panel2.add(new JLabel("Explosion"));

        panel2.add(l9);
        panel2.add(new JLabel("Explosion Mine"));

        right.add(panel1);
        right .add(panel2);


        right.setPreferredSize(new Dimension(450,450));

        north.add(new JLabel("JEU DE STRATEGIE - tour par tour"));
        this.add(p,BorderLayout.CENTER);
        this.add(right,BorderLayout.EAST);
        this.add(north,BorderLayout.NORTH);
        this.add(south,BorderLayout.SOUTH);
        this.add(left,BorderLayout.WEST);

    }

    @Override
    public void update(Observable o, Object arg) {

       table.getSelectionModel().clearSelection();
       table.getSelectionModel().addSelectionInterval(p.getChampdebataille().getIdplayerCourant(), p.getChampdebataille().getIdplayerCourant());
       updateTable();

       repaint();

    }


}
