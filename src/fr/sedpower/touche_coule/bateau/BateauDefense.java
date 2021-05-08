package fr.sedpower.touche_coule.bateau;

import fr.sedpower.touche_coule.grille.CaseDefense;
import fr.sedpower.touche_coule.grille.InitCase;

import java.util.ArrayList;
import java.util.List;

public class BateauDefense {

    private final int taille;
    private String orientation;
    private boolean coule;
    private List<CaseDefense> casesBateau;

    public BateauDefense(Bateau initBateau) {
        taille = initBateau.getTaille();
        orientation = initBateau.getOrientation();
        coule = false;
        casesBateau = new ArrayList<>();

        List<InitCase> initBateauCases = initBateau.getCases();
        for (InitCase initCase : initBateauCases) {
            casesBateau.add(new CaseDefense(initCase));
        }
    }
}
