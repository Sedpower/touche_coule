package fr.sedpower.touche_coule.grille;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class InitCase extends JButton {

    private static ImageIcon resize(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
    public static ImageIcon caseVideImg = resize(new ImageIcon("src/ressources/img/caseVideImg.png"));
    public static ImageIcon caseOccupeeImg = resize(new ImageIcon("src/ressources/img/caseOccupeeImg.png"));
    public static ImageIcon casePreviewImpossibleImg = resize(new ImageIcon("src/ressources/img/casePreviewImpossibleImg.png"));
    public static ImageIcon casePreviewPossibleImg = resize(new ImageIcon("src/ressources/img/casePreviewPossibleImg.png"));
    private boolean occupee;
    private final int abs, ord;

    public InitCase(int ord, int abs) {
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
        setIcon(caseOccupeeImg);
    }

    public int getAbs() {
        return abs;
    }

    public int getOrd() {
        return ord;
    }
}