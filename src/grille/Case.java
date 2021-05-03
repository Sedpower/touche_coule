package grille;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Case extends JButton {

    public static Color caseVideColor = new Color(173,216,230);
    public static Color caseOccupeeColor = new Color(150,150,150);
    private boolean tiree;
    private boolean occupee;
    private int abs,ord;

    public Case(int ord, int abs) {
        super("");
        this.ord = ord;
        this.abs = abs;
        this.occupee = false;
        this.tiree = false;
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(caseVideColor);
    }

    public boolean estTiree() {
        return tiree;
    }

    public boolean estOccupee() {
        return occupee;
    }

    public void setTiree() {
        tiree = true;
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
