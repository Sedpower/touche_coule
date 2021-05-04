package grille;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class CaseCliquable extends JButton {

    public static Color caseVideColor = new Color(173,216,230);
    public static Color caseOccupeeColor = new Color(150,150,150);
    private boolean occupee;
    private final int abs,ord;

    public CaseCliquable(int ord, int abs) {
        super("");
        this.ord = ord;
        this.abs = abs;
        this.occupee = false;
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(caseVideColor);
    }

    public boolean estOccupee() {
        return occupee;
    }

    public void setOccupee() {
        occupee = true;
        setBackground(caseOccupeeColor);
    }

    public int getAbs() {
        return abs;
    }

    public int getOrd() {
        return ord;
    }
}