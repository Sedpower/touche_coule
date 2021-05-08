package fr.sedpower.touche_coule.grille;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CaseAttaque extends JButton {

    public static ImageIcon caseVideImg = new ImageIcon("src/ressources/img/caseVideImg.png");
    public static ImageIcon caseVideHoverImg = new ImageIcon("src/ressources/img/caseVideHoverImg.png");
    public static ImageIcon caseVideTireeImg = new ImageIcon("src/ressources/img/caseVideTireeAttaqueImg.png");
    public static ImageIcon caseVideTireeHoverImg = new ImageIcon("src/ressources/img/caseVideTireeAttaqueHoverImg.png");
    public static ImageIcon caseOccupeeTireeImg = new ImageIcon("src/ressources/img/caseOccupeeTireeAttaqueImg.png");
    public static ImageIcon caseOccupeeTireeHoverImg = new ImageIcon("src/ressources/img/caseOccupeeTireeAttaqueHoverImg.png");

    int ord, abs;
    boolean occupee, tiree;

    public CaseAttaque(int ord, int abs) {
        super("");
        this.ord = ord;
        this.abs = abs;
        occupee = false;
        setBorder(new LineBorder(Color.BLACK));
        setIcon(caseVideImg);
    }

    public boolean estOccupee() {
        return occupee;
    }

    public void setOccupee() {
        occupee = true;
    }

    public boolean estTiree() {
        return tiree;
    }

    public void setTiree() {
        tiree = true;
        if (estOccupee()) {
            setIcon(caseOccupeeTireeImg);
        } else {
            setIcon(caseVideTireeImg);
        }
    }

    public int getAbs() {
        return abs;
    }

    public int getOrd() {
        return ord;
    }
}