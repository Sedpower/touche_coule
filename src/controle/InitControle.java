package controle;

import appli.InitPanel;
import appli.Fenetre;
import bateau.Bateau;
import grille.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class InitControle implements ActionListener, MouseListener {

    private Fenetre fenetre;
    private Grille grille;
    private InitPanel initPanel;
    private static List<String> info = new ArrayList<>();
    private static List<Bateau> bateaux = new ArrayList<>();
    private static int action;

    public InitControle(Fenetre fenetre, Grille grille, InitPanel initPanel) {
        this.initPanel = initPanel;
        this.fenetre = fenetre;
        this.grille = grille;
        action = -1;
        info.add("Positionnez votre Porte-avion (5 cases)");
        info.add("Positionnez votre Croiseur (4 cases)");
        info.add("Positionnez votre Sous-marin (3 cases)");
        info.add("Positionnez votre Contre-torpilleur (3 cases)");
        info.add("Positionnez votre Torpilleur (2 cases)");
        bateaux.add(new Bateau(5, "Horizontal"));
        bateaux.add(new Bateau(4, "Horizontal"));
        bateaux.add(new Bateau(3, "Horizontal"));
        bateaux.add(new Bateau(3, "Horizontal"));
        bateaux.add(new Bateau(2, "Horizontal"));
    }

    public static String getAction() {
        action += 1;
        return info.get(action);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Bateau bateau = bateaux.get(action);
        if (e.getSource() instanceof Case) {
            Case caseGrille = (Case)e.getSource();
            if ( grille.isPossible(bateau, caseGrille) ) {
                if ( grille.pasChevauche(bateau, caseGrille) ){
                    grille.ajoutBateau(bateau, caseGrille);
                    initPanel.setInfo();
                } else {
                    initPanel.setError("Le bateau en chevauche un autre");
                }
            } else {
                initPanel.setError("Le bateau sort de la grille de jeu");
            }
        } else {
            bateaux.get(action).changeOrientation();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Case caseGrille = (Case) e.getComponent();
        if (caseGrille.estOccupee()) {
            caseGrille.setBackground(Case.caseOccupeeHoverColor);
        } else {
            caseGrille.setBackground(Case.caseVideHoverColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Case caseGrille = (Case) e.getComponent();
        if (caseGrille.estOccupee()) {
            caseGrille.setBackground(Case.caseOccupeeColor);
        } else {
            caseGrille.setBackground(Case.caseVideColor);
        }
    }
}