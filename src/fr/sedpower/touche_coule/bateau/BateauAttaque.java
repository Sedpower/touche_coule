package fr.sedpower.touche_coule.bateau;

import fr.sedpower.touche_coule.grille.CaseAttaque;
import fr.sedpower.touche_coule.grille.CaseDefense;
import fr.sedpower.touche_coule.grille.InitCase;

import java.util.ArrayList;
import java.util.List;

public class BateauAttaque {

    private final int taille;
    private String orientation;
    private List<CaseAttaque> casesBateau;

    public BateauAttaque(int taille, String orientation) {
        this.taille = taille;
        this.orientation = orientation;
        this.casesBateau = new ArrayList<>();
    }

    public boolean estCoule() {
        for (CaseAttaque caseBt : casesBateau) {
            if (!caseBt.estTiree()) {
                return false;
            }
        }
        return true;
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

    public boolean estEn(int ord, int abs) {
        for (CaseAttaque caseGrille : casesBateau) {
            if (caseGrille.getAbs() == abs && caseGrille.getOrd() == ord) {
                return true;
            }
        }
        return false;
    }
}
