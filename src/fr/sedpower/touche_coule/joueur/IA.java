package fr.sedpower.touche_coule.joueur;

import fr.sedpower.touche_coule.bateau.Bateau;
import fr.sedpower.touche_coule.bateau.BateauAttaque;
import fr.sedpower.touche_coule.bateau.BateauDefense;
import fr.sedpower.touche_coule.grille.CaseDefense;
import fr.sedpower.touche_coule.grille.GrilleAttaque;
import fr.sedpower.touche_coule.grille.GrilleDefense;
import fr.sedpower.touche_coule.grille.InitGrille;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IA {

    private List<CaseDefense> grilleJoueur;

    private GrilleAttaque grille;
    private List<BateauAttaque> bateaux;

    public IA(int rand, GrilleDefense grilleJoueur) {
        BateauAttaque hPorteAvion = new BateauAttaque(5, "Horizontal");
        BateauAttaque hCroiseur = new BateauAttaque(4, "Horizontal");
        BateauAttaque hSousMarin = new BateauAttaque(3, "Horizontal");
        BateauAttaque hContreTorpilleur = new BateauAttaque(3, "Horizontal");
        BateauAttaque hTorpilleur = new BateauAttaque(2, "Horizontal");
        BateauAttaque vPorteAvion = new BateauAttaque(5, "Vertical");
        BateauAttaque vCroiseur = new BateauAttaque(4, "Vertical");
        BateauAttaque vSousMarin = new BateauAttaque(3, "Vertical");
        BateauAttaque vContreTorpilleur = new BateauAttaque(3, "Vertical");
        BateauAttaque vTorpilleur = new BateauAttaque(2, "Vertical");

        this.grilleJoueur = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.grilleJoueur.add(grilleJoueur.getCase(i, j));
            }
        }

        bateaux = new ArrayList<>();
        grille = new GrilleAttaque();
        switch (rand){
            case 0 :
                creerBateau(4, "Horizontal", 0, 5);
                creerBateau(3, "Horizontal", 2, 3);
                creerBateau(2, "Horizontal", 5, 2);
                creerBateau(5, "Vertical", 5, 1);
                creerBateau(3, "Vertical", 6, 8);
                break;
            case 1 :
                creerBateau(3, "Horizontal", 0, 1);
                creerBateau(4, "Horizontal", 8, 5);
                creerBateau(3, "Vertical", 2, 7);
                creerBateau(5, "Vertical", 2, 4);
                creerBateau(2, "Vertical", 6, 1);
                break;
            case 2 :
                creerBateau(5, "Horizontal", 1, 1);
                creerBateau(4, "Horizontal", 4, 2);
                creerBateau(3, "Vertical", 6, 2);
                creerBateau(2, "Vertical", 7, 7);
                creerBateau(3, "Vertical", 2, 9);
                break;
            case 3 :
                creerBateau(5, "Horizontal", 9, 2);
                creerBateau(3, "Horizontal", 7, 6);
                creerBateau(3, "Horizontal", 4, 5);
                creerBateau(4, "Vertical", 4, 1);
                creerBateau(2, "Vertical", 1, 8);
                break;
            case 4 :
                creerBateau(3, "Horizontal", 1, 3);
                creerBateau(5, "Horizontal", 3, 3);
                creerBateau(4, "Horizontal", 9, 5);
                creerBateau(2, "Vertical", 6, 2);
                creerBateau(3, "Vertical", 6, 8);
                break;
            case 5 :
                creerBateau(3, "Horizontal", 2, 5);
                creerBateau(2, "Vertical", 1, 1);
                creerBateau(5, "Vertical", 4, 0);
                creerBateau(3, "Vertical", 6, 5);
                creerBateau(4, "Vertical", 4, 8);
                break;
            case 6 :
                creerBateau(3, "Horizontal", 1, 3);
                creerBateau(3, "Horizontal", 4, 1);
                creerBateau(2, "Horizontal", 8, 0);
                creerBateau(4, "Vertical", 5, 5);
                creerBateau(5, "Vertical", 2, 8);
                break;
            case 7 :
                creerBateau(4, "Horizontal", 1, 1);
                creerBateau(5, "Horizontal", 5, 0);
                creerBateau(2, "Horizontal", 8, 1);
                creerBateau(3, "Vertical", 6, 7);
                creerBateau(3, "Vertical", 1, 9);
                break;
            case 8 :
                creerBateau(4, "Horizontal", 2, 5);
                creerBateau(2, "Horizontal", 4, 6);
                creerBateau(3, "Horizontal", 7, 5);
                creerBateau(3, "Vertical", 0, 2);
                creerBateau(5, "Vertical", 4, 2);
                break;
            case 9 :
                creerBateau(3, "Horizontal", 1, 1);
                creerBateau(5, "Horizontal", 4, 3);
                creerBateau(3, "Horizontal", 7, 1);
                creerBateau(4, "Vertical", 0, 7);
                creerBateau(2, "Vertical", 7, 8);
                break;
            case 10 :
                creerBateau(2, "Horizontal", 1, 3);
                creerBateau(5, "Horizontal", 8, 4);
                creerBateau(3, "Vertical", 2, 1);
                creerBateau(3, "Vertical", 4, 4);
                creerBateau(4, "Vertical", 0, 8);
                break;
            case 11 :
                creerBateau(3, "Horizontal", 1, 1);
                creerBateau(4, "Horizontal", 1, 6);
                creerBateau(3, "Horizontal", 5, 6);
                creerBateau(5, "Vertical", 3, 2);
                creerBateau(2, "Vertical", 7, 5);
                break;
            case 12 :
                creerBateau(3, "Horizontal", 1, 4);
                creerBateau(4, "Horizontal", 3, 1);
                creerBateau(2, "Vertical", 5, 1);
                creerBateau(3, "Vertical", 6, 4);
                creerBateau(5, "Vertical", 3, 9);
                break;
            case 13 :
                creerBateau(3, "Horizontal", 0, 5);
                creerBateau(3, "Horizontal", 6, 5);
                creerBateau(5, "Vertical", 2, 2);
                creerBateau(2, "Vertical", 8, 5);
                creerBateau(4, "Vertical", 2, 8);
                break;
            case 14 :
                creerBateau(4, "Horizontal", 9, 2);
                creerBateau(3, "Horizontal", 7, 6);
                creerBateau(2, "Vertical", 1, 2);
                creerBateau(3, "Vertical", 5, 1);
                creerBateau(5, "Vertical", 1, 6);
                break;
            case 15 :
                creerBateau(5, "Horizontal", 1, 5);
                creerBateau(3, "Horizontal", 3, 1);
                creerBateau(2, "Horizontal", 8, 6);
                creerBateau(4, "Vertical", 5, 1);
                creerBateau(3, "Vertical", 4, 5);
                break;
            case 16 :
                creerBateau(5, "Horizontal", 2, 2);
                creerBateau(3, "Horizontal", 5, 1);
                creerBateau(3, "Vertical", 3, 8);
                creerBateau(4, "Vertical", 6, 7);
                creerBateau(2, "Vertical", 8, 2);
                break;
            case 17 :
                creerBateau(4, "Horizontal", 1, 1);
                creerBateau(3, "Horizontal", 4, 4);
                creerBateau(3, "Vertical", 6, 4);
                creerBateau(5, "Vertical", 2, 8);
                creerBateau(2, "Vertical", 0, 9);
                break;
            case 18 :
                creerBateau(3, "Horizontal", 2, 0);
                creerBateau(5, "Horizontal", 1, 3);
                creerBateau(2, "Horizontal", 7, 1);
                creerBateau(4, "Vertical", 6, 5);
                creerBateau(3, "Vertical", 4, 8);
                break;
            case 19 :
                creerBateau(4, "Horizontal", 1, 4);
                creerBateau(3, "Horizontal", 8, 1);
                creerBateau(3, "Vertical", 2, 1);
                creerBateau(2, "Vertical", 6, 7);
                creerBateau(5, "Vertical", 2, 9);
                break;
            case 20 :
                creerBateau(3, "Horizontal", 2, 7);
                creerBateau(4, "Horizontal", 6, 2);
                creerBateau(5, "Horizontal", 9, 2);
                creerBateau(2, "Vertical", 8, 0);
                creerBateau(3, "Vertical", 0, 3);
                break;
        }
    }

    private void creerBateau(int taille, String orientation, int ord, int abs) {
        BateauAttaque bateau = new BateauAttaque(taille, orientation);
        grille.ajoutBateau(bateau, grille.getCase(ord, abs));
        bateaux.add(bateau);
    }

    public GrilleAttaque getGrille() {
        return grille;
    }

    public void jouer() {
        Random random = new Random();
        int index = random.nextInt(grilleJoueur.size());
        grilleJoueur.get(index).setTiree();
        grilleJoueur.remove(index);
    }
}
