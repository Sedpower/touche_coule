package fr.sedpower.touche_coule.bateau;

import fr.sedpower.touche_coule.controle.JeuControle;
import fr.sedpower.touche_coule.grille.CaseDefense;
import fr.sedpower.touche_coule.grille.GrilleDefense;
import fr.sedpower.touche_coule.grille.InitCase;

import java.util.ArrayList;
import java.util.List;

public class BateauDefense {

    private final int taille;
    private String orientation;
    private List<CaseDefense> casesBateau;

    public BateauDefense(Bateau initBateau, GrilleDefense grille) {
        taille = initBateau.getTaille();
        orientation = initBateau.getOrientation();
        casesBateau = new ArrayList<>();
        List<InitCase> initBateauCases = initBateau.getCases();
        for (InitCase initCase : initBateauCases) {
            casesBateau.add(grille.getCase(initCase.getOrd(), initCase.getAbs()));
        }
    }

    public boolean estEn(int ord, int abs) {
        for (CaseDefense caseGrille : casesBateau) {
            if (caseGrille.getAbs() == abs && caseGrille.getOrd() == ord) {
                return true;
            }
        }
        return false;
    }

    public boolean estCoule() {
        for (CaseDefense caseBt : casesBateau) {
            if (!caseBt.estTiree()) {
                return false;
            }
        }
        return true;
    }
}
