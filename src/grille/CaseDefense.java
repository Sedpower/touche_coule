package grille;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CaseDefense extends JLabel {

    private static ImageIcon resize(ImageIcon imageIcon) {
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg);  // transform it back
    }

    public static ImageIcon caseVideImg = resize(new ImageIcon("src/img/caseVideImg.png"));
    public static ImageIcon caseVideTireeImg = resize(new ImageIcon("src/img/caseVideTireeImg.png"));
    public static ImageIcon caseOccupeeImg = resize(new ImageIcon("src/img/caseOccupeeImg.png"));
    public static ImageIcon caseOccupeeTireeImg = resize(new ImageIcon("src/img/caseOccupeeTireeImg.png"));

    private JLabel bg;
    private boolean tiree;
    private boolean occupee;
    private final int abs,ord;

    public CaseDefense(CaseCliquable caseGrille) {
        if (caseGrille.estOccupee()) {
            this.setIcon(caseOccupeeTireeImg);
        } else {
            this.setIcon(caseVideTireeImg);
        }
        this.setBounds(0,0,50,50);
        this.setBorder(new LineBorder(Color.BLACK));
        this.tiree = false;
        this.occupee = caseGrille.estOccupee();
        this.abs = caseGrille.getAbs();
        this.ord = caseGrille.getOrd();
    }

    public void setTiree() {
        tiree = true;
    }
}