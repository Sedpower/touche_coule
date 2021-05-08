package fr.sedpower.touche_coule.grille;

import fr.sedpower.touche_coule.bateau.Bateau;
import fr.sedpower.touche_coule.bateau.BateauAttaque;

public class GrilleAttaque {

    private CaseAttaque[][] grille;

    public GrilleAttaque(){
        grille = newGrille();
    }
    private CaseAttaque[][] newGrille() {
        grille = new CaseAttaque[10][10];
        for (int ord = 0; ord < grille.length; ord++) {
            for (int abs = 0; abs < grille[ord].length; abs++){
                grille[ord][abs] = new CaseAttaque(ord,abs);
            }
        }
        return grille;
    }

    public CaseAttaque getCase(int ord, int abs) {
        return grille[ord][abs];
    }

    public void ajoutBateau(BateauAttaque bateau, CaseAttaque caseGrille) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            for (int i = debut; i < fin; i++) {
                getCase(caseGrille.getOrd(),i).setOccupee();
                bateau.ajouterCase(getCase(caseGrille.getOrd(),i));

            }
        } else {
            debut = caseGrille.getOrd();
            fin = caseGrille.getOrd() + bateau.getTaille();
            for (int i = debut; i < fin; i++) {
                getCase(i, caseGrille.getAbs()).setOccupee();
                bateau.ajouterCase(getCase(i, caseGrille.getAbs()));
            }
        }
    }
}
