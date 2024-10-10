package Terrain.View;

import javax.swing.JOptionPane;

public class FenetreDialogue {
    static public int launch() {
    String[] choix = {"Avec Interface graphique", "Avec Console", "Quitter"};
    JOptionPane jop = new JOptionPane();
    int option = jop.showOptionDialog(null,
      "Choisossez un type d'execution!",
      "Jeu Strategie",
      JOptionPane.YES_NO_CANCEL_OPTION,
      JOptionPane.INFORMATION_MESSAGE,
      null,
      choix,
      choix[2]);
      return option;
  }
    static public String nombreFighter(){
        JOptionPane jop = new JOptionPane();
         String nbcom;
         nbcom =jop.showInputDialog(null, "Veuillez entrer le nombre de Fighters!", "NOMBRE DE Fighter !",JOptionPane.QUESTION_MESSAGE);
         return nbcom;
    }
    static public int Information(String pseudo){
        String info = "Felicitaion "+pseudo+" a gagne!!!";
        JOptionPane pane = new JOptionPane();
        String[] choix = {"Recommencer","Terminer"};
        int option = pane.showOptionDialog(null,info,"Jeu Strategie",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,choix,choix[0]);

        return option;
    }
}
