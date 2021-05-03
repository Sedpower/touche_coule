package grille;

import bateau.Bateau;

import java.awt.*;

public class Grille {

    private Case[][] grille;

    public Grille(){
        grille = newGrille();
    }
    private Case[][] newGrille() {
        grille = new Case[10][10];
        for (int ord = 0; ord < grille.length; ord++) {
            for (int abs = 0; abs < grille[ord].length; abs++){
                grille[ord][abs] = new Case(ord,abs);
            }
        }
        return grille;
    }

    public Case getCase(int ord, int abs) {
        return grille[ord][abs];
    }

    public void ajoutBateau(Bateau bateau, Case caseGrille) {
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

    public boolean pasChevauche(Bateau bateau, Case caseGrille) {
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

    public boolean isPossible(Bateau bateau, Case caseGrille) {
        if (bateau.getOrientation().equals("Horizontal")) {
            return bateau.getTaille() + caseGrille.getAbs() - 1 <= 9;
        } else {
            return bateau.getTaille() + caseGrille.getOrd() - 1 <= 9;
        }
    }

    public void previewBateau(Bateau bateau, Case caseGrille, boolean possible) {
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

    public void removePreviewBateau(Bateau bateau, Case caseGrille) {
        int debut;
        int fin;
        if ( bateau.getOrientation().equals("Horizontal") ) {
            debut = caseGrille.getAbs();
            fin = caseGrille.getAbs() + bateau.getTaille();
            try {
                for (int i = debut; i < fin; i++) {
                    if (getCase(caseGrille.getOrd(), i).estOccupee()) {
                        getCase(caseGrille.getOrd(), i).setBackground(Case.caseOccupeeColor);
                    } else {
                        getCase(caseGrille.getOrd(), i).setBackground(Case.caseVideColor);
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
                        getCase(i, caseGrille.getAbs()).setBackground(Case.caseOccupeeColor);
                    } else {
                        getCase(i, caseGrille.getAbs()).setBackground(Case.caseVideColor);
                    }
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
    }

    public Case[][] getGrille() {
        return this.grille;
    }
}





