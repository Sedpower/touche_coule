package fr.sedpower.touche_coule.controle;

import fr.sedpower.touche_coule.appli.*;
import fr.sedpower.touche_coule.bateau.*;
import fr.sedpower.touche_coule.grille.*;
import fr.sedpower.touche_coule.joueur.*;

import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class InitControle implements ActionListener, MouseListener {

    private Fenetre fenetre;
    private InitGrille grille;
    private InitPanel initPanel;
    private static List<String> info = new ArrayList<>();
    private static List<Bateau> bateaux = new ArrayList<>();
    private static int action;

    public InitControle(Fenetre fenetre, InitGrille grille, InitPanel initPanel) {
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
        if (e.getSource() instanceof InitCase) {
            InitCase caseGrille = (InitCase)e.getSource();
            if ( grille.isPossible(bateau, caseGrille) ) {
                if ( grille.pasChevauche(bateau, caseGrille) ){
                    grille.ajoutBateau(bateau, caseGrille);
                    try {
                        initPanel.setInfo();
                    } catch (IndexOutOfBoundsException except) {
                        fenetre.removeInit();
                        Joueur joueur = new Joueur(grille, bateaux);
                        IA ia = new IA(random(), joueur.getGrille());
                        fenetre.setPanel(new JeuPanel(fenetre, joueur, ia));
                    }
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

    private int random() {
        Random random = new Random();
        return random.nextInt(21);
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
        InitCase caseGrille = (InitCase) e.getComponent();
        Bateau bateau = bateaux.get(action);
        if ( grille.isPossible(bateau, caseGrille) && grille.pasChevauche(bateau, caseGrille) ) {
            grille.previewBateau(bateau, caseGrille, true);
        } else {
            grille.previewBateau(bateau, caseGrille, false);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        InitCase caseGrille = (InitCase) e.getComponent();
        Bateau bateau = bateaux.get(action);
        grille.removePreviewBateau(bateau, caseGrille);
    }
}