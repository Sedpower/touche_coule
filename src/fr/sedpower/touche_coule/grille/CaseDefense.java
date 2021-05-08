package fr.sedpower.touche_coule.grille;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CaseDefense extends JLabel {

    public static ImageIcon caseVideImg = resize(new ImageIcon("src/ressources/img/caseVideImg.png"));
    public static ImageIcon caseVideTireeImg = resize(new ImageIcon("src/ressources/img/caseVideTireeDefenseImg.png"));
    public static ImageIcon caseOccupeeImg = resize(new ImageIcon("src/ressources/img/caseOccupeeImg.png"));
    public static ImageIcon caseOccupeeTireeImg = resize(new ImageIcon("src/ressources/img/caseOccupeeDefenseTireeImg.png"));
    private static ImageIcon resize(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

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
}