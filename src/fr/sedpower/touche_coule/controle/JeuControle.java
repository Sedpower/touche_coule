package fr.sedpower.touche_coule.controle;

import fr.sedpower.touche_coule.appli.Fenetre;
import fr.sedpower.touche_coule.appli.JeuPanel;
import fr.sedpower.touche_coule.bateau.Bateau;
import fr.sedpower.touche_coule.grille.GrilleDefense;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class JeuControle implements ActionListener, MouseListener {

    private Fenetre fenetre;
    private GrilleDefense grilleDefense;
    /*private GrilleAttaque grilleAttaque;*/
    private JeuPanel jeuPanel;

    public JeuControle(Fenetre fenetre, GrilleDefense grilleDefense, List<Bateau> bateauxJoueur, /* GrilleAttaque grilleAttaque,*/ JeuPanel jeuPanel) {
        this.fenetre = fenetre;
        this.grilleDefense = grilleDefense;
        /*this.grilleAttaque = grilleAttaque;*/
        this.jeuPanel = jeuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
