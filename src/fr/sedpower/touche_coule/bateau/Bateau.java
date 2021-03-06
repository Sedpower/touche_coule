package fr.sedpower.touche_coule.bateau;

import fr.sedpower.touche_coule.grille.InitCase;

import java.util.ArrayList;
import java.util.List;

public class Bateau {

    private final int taille;
    private String orientation;
    private List<InitCase> casesBateau;

    public Bateau(int taille, String orientation) {
        this.taille = taille;
        this.orientation = orientation;
        this.casesBateau = new ArrayList<>();
    }

    public int getTaille() {
        return taille;
    }

    public String getOrientation() {
        return orientation;
    }

    public void ajouterCase(InitCase caseGrille) {
        casesBateau.add(caseGrille);
    }

    public void changeOrientation() {
        if (orientation.equals("Horizontal")) {
            orientation = "Vertical";
        } else {
            orientation = "Horizontal";
        }
    }

    public List<InitCase> getCases() {
        return casesBateau;
    }
}