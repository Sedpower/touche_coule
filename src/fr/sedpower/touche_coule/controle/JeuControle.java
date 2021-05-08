package fr.sedpower.touche_coule.controle;

import fr.sedpower.touche_coule.appli.Fenetre;
import fr.sedpower.touche_coule.appli.JeuPanel;
import fr.sedpower.touche_coule.bateau.Bateau;
import fr.sedpower.touche_coule.grille.CaseAttaque;
import fr.sedpower.touche_coule.grille.GrilleDefense;
import fr.sedpower.touche_coule.grille.InitCase;
import fr.sedpower.touche_coule.joueur.IA;
import fr.sedpower.touche_coule.joueur.Joueur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class JeuControle implements ActionListener, MouseListener {

    private Fenetre fenetre;
    private Joueur joueur;
    private IA ia;
    private JeuPanel jeuPanel;

    public JeuControle(Fenetre fenetre, Joueur joueur, IA ia, JeuPanel jeuPanel) {
        this.fenetre = fenetre;
        this.joueur = joueur;
        this.ia = ia;
        this.jeuPanel = jeuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CaseAttaque caseGrille = (CaseAttaque)e.getSource();
        if (caseGrille.estOccupee()) {
            caseGrille.setTiree();
            caseGrille.setIcon(CaseAttaque.caseOccupeeTireeImg);
        } else {
            caseGrille.setTiree();
            caseGrille.setIcon(CaseAttaque.caseVideTireeImg);
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
        CaseAttaque caseGrille = (CaseAttaque)e.getSource();
        if (!caseGrille.estTiree()) {
            caseGrille.setIcon(CaseAttaque.caseVideHoverImg);
        } else {
            if (caseGrille.estOccupee()) {
                caseGrille.setIcon(CaseAttaque.caseOccupeeTireeHoverImg);
            } else {
                caseGrille.setIcon(CaseAttaque.caseVideTireeHoverImg);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        CaseAttaque caseGrille = (CaseAttaque)e.getSource();
        if (!caseGrille.estTiree()) {
            caseGrille.setIcon(CaseAttaque.caseVideImg);
        } else {
            if (caseGrille.estOccupee()) {
                caseGrille.setIcon(CaseAttaque.caseOccupeeTireeImg);
            } else {
                caseGrille.setIcon(CaseAttaque.caseVideTireeImg);
            }
        }
    }
}

