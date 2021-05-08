package fr.sedpower.touche_coule.controle;

import fr.sedpower.touche_coule.appli.Fenetre;
import fr.sedpower.touche_coule.appli.JeuPanel;
import fr.sedpower.touche_coule.bateau.Bateau;
import fr.sedpower.touche_coule.grille.CaseAttaque;
import fr.sedpower.touche_coule.grille.CaseDefense;
import fr.sedpower.touche_coule.grille.GrilleDefense;
import fr.sedpower.touche_coule.grille.InitCase;
import fr.sedpower.touche_coule.joueur.IA;
import fr.sedpower.touche_coule.joueur.Joueur;

import javax.swing.*;
import java.awt.*;
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
        int ord = caseGrille.getOrd();
        int abs = caseGrille.getAbs();
        if (caseGrille.estOccupee()) {
            caseGrille.setTiree();
            caseGrille.setIcon(CaseAttaque.caseOccupeeTireeImg);
            if (ia.getBateau(ord, abs).estCoule()) {
                jeuPanel.setInfoActionJoueur("Touché coulé !");
            } else  {
                jeuPanel.setInfoActionJoueur("Touché !");
            }
        } else {
            caseGrille.setTiree();
            caseGrille.setIcon(CaseAttaque.caseVideTireeImg);
            jeuPanel.setInfoActionJoueur("Tir dans l'eau...");
        }
        caseGrille.removeActionListener(this);
        if (ia.perdu()) {
            JOptionPane.showMessageDialog(new Frame(), "Vous avez gagné");
            System.exit(0);
        }
        CaseDefense caseTireeIA = ia.jouer();
        ord = caseTireeIA.getOrd();
        abs = caseTireeIA.getAbs();
        if (caseTireeIA.estOccupee()) {
            caseTireeIA.setTiree();
            caseTireeIA.setIcon(CaseAttaque.caseOccupeeTireeImg);
            if (joueur.getBateau(ord, abs).estCoule()) {
                jeuPanel.setInfoActionIA("Touché coulé !");
            } else  {
                jeuPanel.setInfoActionIA("Touché !");
            }
        } else {
            caseTireeIA.setTiree();
            caseTireeIA.setIcon(CaseAttaque.caseVideTireeImg);
            jeuPanel.setInfoActionIA("Tir dans l'eau...");
        }
        if (joueur.perdu()) {
            JOptionPane.showMessageDialog(new Frame(), "Vous avez perdu");
            System.exit(0);
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

