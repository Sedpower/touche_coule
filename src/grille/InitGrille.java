package grille;

import bateau.Bateau;

import java.awt.*;

public class InitGrille {

    private CaseCliquable[][] grille;

    public InitGrille(){
        grille = newGrille();
    }
    private CaseCliquable[][] newGrille() {
        grille = new CaseCliquable[10][10];
        for (int ord = 0; ord < grille.length; ord++) {
            for (int abs = 0; abs < grille[ord].length; abs++){
                grille[ord][abs] = new CaseCliquable(ord,abs);
            }
        }
        return grille;
    }

    public CaseCliquable getCase(int ord, int abs) {
        return grille[ord][abs];
    }

    public void ajoutBateau(Bateau bateau, CaseCliquable caseGrille) {
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

    public boolean pasChevauche(Bateau bateau, CaseCliquable caseGrille) {
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

    public boolean isPossible(Bateau bateau, CaseCliquable caseGrille) {
        if (bateau.getOrientation().equals("Horizontal")) {
            return bateau.getTaille() + caseGrille.getAbs() - 1 <= 9;
        } else {
            return bateau.getTaille() + caseGrille.getOrd() - 1 <= 9;
        }
    }

    public void previewBateau(Bateau bateau, CaseCliquable caseGrille, boolean possible) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            try {
                for (int i = debut; i < fin; i++) {
                    if (possible) {
                        getCase(caseGrille.getOrd(), i).setBackground(new Color(0,150,0));
                    } else {
                        getCase(caseGrille.getOrd(), i).setBackground(new Color(150,0,0));
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
                        getCase(i, caseGrille.getAbs()).setBackground(new Color(0,150,0));
                    } else {
                        getCase(i, caseGrille.getAbs()).setBackground(new Color(150,0,0));
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
    }

    public void removePreviewBateau(Bateau bateau, CaseCliquable caseGrille) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            try {
                for (int i = debut; i < fin; i++) {
                    if (getCase(caseGrille.getOrd(), i).estOccupee()) {
                        getCase(caseGrille.getOrd(), i).setBackground(CaseCliquable.caseOccupeeColor);
                    } else {
                        getCase(caseGrille.getOrd(), i).setBackground(CaseCliquable.caseVideColor);
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
                        getCase(i, caseGrille.getAbs()).setBackground(CaseCliquable.caseOccupeeColor);
                    } else {
                        getCase(i, caseGrille.getAbs()).setBackground(CaseCliquable.caseVideColor);
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
    }

    public CaseCliquable[][] getGrille() {
        return this.grille;
    }
}