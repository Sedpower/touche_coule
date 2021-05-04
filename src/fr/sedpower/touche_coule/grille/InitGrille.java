package fr.sedpower.touche_coule.grille;

import fr.sedpower.touche_coule.bateau.Bateau;

public class InitGrille {

    private InitCase[][] grille;

    public InitGrille(){
        grille = newGrille();
    }
    private InitCase[][] newGrille() {
        grille = new InitCase[10][10];
        for (int ord = 0; ord < grille.length; ord++) {
            for (int abs = 0; abs < grille[ord].length; abs++){
                grille[ord][abs] = new InitCase(ord,abs);
            }
        }
        return grille;
    }

    public InitCase getCase(int ord, int abs) {
        return grille[ord][abs];
    }

    public void ajoutBateau(Bateau bateau, InitCase caseGrille) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            for (int i = debut; i < fin; i++) {
                getCase(caseGrille.getOrd(),i).setOccupee();
                bateau.ajouterCase(caseGrille);

            }
        } else {
            debut = caseGrille.getOrd();
            fin = caseGrille.getOrd() + bateau.getTaille();
            for (int i = debut; i < fin; i++) {
                getCase(i, caseGrille.getAbs()).setOccupee();
                bateau.ajouterCase(caseGrille);
            }
        }
    }

    public boolean pasChevauche(Bateau bateau, InitCase caseGrille) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            for (int i = debut; i < fin; i++) {
                if ( getCase(caseGrille.getOrd(),i).estOccupee() ) {
                    return false;
                }
            }
            return true;
        } else {
            debut = caseGrille.getOrd();
            fin = caseGrille.getOrd() + bateau.getTaille();
            for (int i = debut; i < fin; i++) {
                if (getCase(i, caseGrille.getAbs()).estOccupee()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPossible(Bateau bateau, InitCase caseGrille) {
        if (bateau.getOrientation().equals("Horizontal")) {
            return bateau.getTaille() + caseGrille.getAbs() - 1 <= 9;
        } else {
            return bateau.getTaille() + caseGrille.getOrd() - 1 <= 9;
        }
    }

    public void previewBateau(Bateau bateau, InitCase caseGrille, boolean possible) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            try {
                for (int i = debut; i < fin; i++) {
                    if (possible) {
                        getCase(caseGrille.getOrd(), i).setIcon(InitCase.casePreviewPossibleImg);
                    } else {
                        getCase(caseGrille.getOrd(), i).setIcon(InitCase.casePreviewImpossibleImg);
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        } else {
            debut = caseGrille.getOrd();
            fin = caseGrille.getOrd() + bateau.getTaille();
            try {
                for (int i = debut; i < fin; i++) {
                    if (possible) {
                        getCase(i, caseGrille.getAbs()).setIcon(InitCase.casePreviewPossibleImg);
                    } else {
                        getCase(i, caseGrille.getAbs()).setIcon(InitCase.casePreviewImpossibleImg);
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
    }

    public void removePreviewBateau(Bateau bateau, InitCase caseGrille) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            try {
                for (int i = debut; i < fin; i++) {
                    if (getCase(caseGrille.getOrd(), i).estOccupee()) {
                        getCase(caseGrille.getOrd(), i).setIcon(InitCase.caseOccupeeImg);
                    } else {
                        getCase(caseGrille.getOrd(), i).setIcon(InitCase.caseVideImg);
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        } else {
            debut = caseGrille.getOrd();
            fin = caseGrille.getOrd() + bateau.getTaille();
            try {
                for (int i = debut; i < fin; i++) {
                    if (getCase(i, caseGrille.getAbs()).estOccupee()) {
                        getCase(i, caseGrille.getAbs()).setIcon(InitCase.caseOccupeeImg);
                    } else {
                        getCase(i, caseGrille.getAbs()).setIcon(InitCase.caseVideImg);
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
    }

    public InitCase[][] getGrille() {
        return this.grille;
    }
}