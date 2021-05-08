package fr.sedpower.touche_coule.grille;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CaseDefense extends JLabel {

    public static ImageIcon caseVideImg = new ImageIcon("src/ressources/img/caseVideImg.png");
    public static ImageIcon caseVideTireeImg = new ImageIcon("src/ressources/img/caseVideTireeDefenseImg.png");
    public static ImageIcon caseOccupeeImg = new ImageIcon("src/ressources/img/caseOccupeeImg.png");
    public static ImageIcon caseOccupeeTireeImg = new ImageIcon("src/ressources/img/caseOccupeeTireeDefenseImg.png");

    private boolean tiree;
    private boolean occupee;
    private final int abs,ord;

    public CaseDefense(InitCase caseGrille) {
        if (caseGrille.estOccupee()) {
            this.setIcon(caseOccupeeImg);
        } else {
            this.setIcon(caseVideImg);
        }
        this.setBorder(new LineBorder(Color.BLACK));
        this.tiree = false;
        this.occupee = caseGrille.estOccupee();
        this.abs = caseGrille.getAbs();
        this.ord = caseGrille.getOrd();
    }

    public void setTiree() {
        tiree = true;
        if (occupee) {
            setIcon(caseOccupeeTireeImg);
        } else {
            setIcon(caseVideTireeImg);
        }
    }

    public boolean estOccupee() {
        return occupee;
    }

    public boolean estTiree() {
        return tiree;
    }

    public int getAbs() {
        return abs;
    }

    public int getOrd() {
        return ord;
    }
}