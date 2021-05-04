package bateau;

import grille.CaseCliquable;

import java.util.ArrayList;
import java.util.List;

public class Bateau {

    private final int taille;
    private String orientation;
    private boolean coule;
    private List<CaseCliquable> casesBateau;

    public Bateau(int taille, String orientation) {
        this.taille = taille;
        this.orientation = orientation;
        this.coule = false;
        this.casesBateau = new ArrayList<>();
    }

    public boolean estCoule() {
        return this.coule;
    }

    public int getTaille() {
        return taille;
    }

    public String getOrientation() {
        return orientation;
    }

    public void ajouterCase(CaseCliquable caseGrille) {
        casesBateau.add(caseGrille);
    }

    public void changeOrientation() {
        if (orientation.equals("Horizontal")) {
            orientation = "Vertical";
        } else {
            orientation = "Horizontal";
        }
    }
}