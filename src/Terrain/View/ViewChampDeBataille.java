
package Terrain.View;
import Terrain.playerArme.MineVisible;
import Terrain.playerArme.MineInvisible;
import Terrain.playerArme.BombeVisible;
import Terrain.playerArme.Bouclier;
import Terrain.playerArme.BombeInvisible;
import Terrain.Plateau;
import Terrain.Sniper;
import Terrain.Bandit;
import Terrain.Soldier;
import entites.View.ViewExplosionMine;
import entites.View.ViewTire;
import entites.View.ViewMur;
import entites.View.ViewExplosion;
import entites.View.ViewCaseVide;
import entites.ExplosionMine;
import entites.Explosion;
import entites.Tire;
import entites.Pastille;
import entites.Mur;
import entites.Position;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ViewChampDeBataille extends JPanel {

    private Plateau champdebataille;


    public ViewChampDeBataille(Plateau champdebataille){
        this.champdebataille = champdebataille;
    }



    public Plateau getChampdebataille() {
        return champdebataille;
    }

     @Override
    public void paint(Graphics g){
        int x=0,y=0;
        for(int i=0;i<champdebataille.getHeight();i++){

            for(int j=0;j<champdebataille.getHeight();j++){

                if(champdebataille.getContenue(new Position(i,j))==null){

                   g.drawImage(new ViewCaseVide(new Position(i,j)).getCaseVide(), x, y, this);
                   x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof Mur){

                    g.drawImage(new ViewMur(new Position(i,j)).getMur(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof Pastille){
                    g.drawImage(new ViewPastille(new Position(i,j)).getPastille(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof Soldier){
                    g.drawImage(new ViewSoldier(new Position(i,j)).getSoldier(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof Bandit){
                    g.drawImage(new ViewBandit(new Position(i,j)).getBandit(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof Sniper){
                    g.drawImage(new ViewSniper(new Position(i,j)).getSniper(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof BombeVisible){
                    g.drawImage(new ViewBombe(new Position(i,j)).getBombe(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof MineVisible){
                    g.drawImage(new ViewMine(new Position(i,j)).getMine(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof BombeInvisible){
                    g.drawImage(new ViewBombe(new Position(i,j)).getBombe(),x,y,this);
                    x+=48;
                }
                else if(champdebataille.getContenue(new Position(i,j)) instanceof MineInvisible){
                    g.drawImage(new ViewMine(new Position(i,j)).getMine(),x,y,this);
                    x+=48;
                }
                else if (champdebataille.getContenue(new Position(i,j)) instanceof Explosion){
                    g.drawImage(new ViewExplosion(new Position(i,j)).getExplosion(), x, y, this);

                    x+=48;
                }
                else if (champdebataille.getContenue(new Position(i,j)) instanceof Tire){
                    g.drawImage(new ViewTire(new Position(i,j)).getTire(), x, y, this);

                    x+=48;
                }
                 else if (champdebataille.getContenue(new Position(i,j)) instanceof ExplosionMine){
                    g.drawImage(new ViewExplosionMine(new Position(i,j)).getExplosionMine(), x, y, this);

                    x+=48;
                }
                 else if(champdebataille.getContenue(new Position(i,j)) instanceof Bouclier){
                    g.drawImage(new ViewBouclier(new Position(i,j)).getBouclier(), x, y, this);

                    x+=48;
                 }
            }
            y+=48;x=0;
        }
    }
}
