package fr.sedpower.touche_coule.bateau;

import fr.sedpower.touche_coule.grille.CaseAttaque;
import fr.sedpower.touche_coule.grille.CaseDefense;
import fr.sedpower.touche_coule.grille.InitCase;

import java.util.ArrayList;
import java.util.List;

public class BateauAttaque {

    private final int taille;
    private String orientation;
    private boolean coule;
    private List<CaseAttaque> casesBateau;

    public BateauAttaque(int taille, String orientation) {
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

    public void ajouterCase(CaseAttaque caseGrille) {
        casesBateau.add(caseGrille);
    }

    public List<CaseAttaque> getCases() {
        return casesBateau;
    }
}
