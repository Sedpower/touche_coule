package fr.sedpower.touche_coule.grille;

public class GrilleDefense {

    private CaseDefense[][] grilleDefense;

    public GrilleDefense(InitGrille initGrille) {
        initGrilleToGrilleDefense(initGrille);
    }

    private void initGrilleToGrilleDefense(InitGrille initGrille) {
        InitCase[][] caseInitGrille = initGrille.getGrille();
        grilleDefense = new CaseDefense[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grilleDefense[i][j] = new CaseDefense(caseInitGrille[i][j]);
            }
        }
    }

    public CaseDefense getCase(int ord, int abs) {
        return grilleDefense[ord][abs];
    }
}
