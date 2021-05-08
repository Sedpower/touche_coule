package fr.sedpower.touche_coule.joueur;

import fr.sedpower.touche_coule.bateau.Bateau;
import fr.sedpower.touche_coule.bateau.BateauDefense;
import fr.sedpower.touche_coule.grille.GrilleDefense;
import fr.sedpower.touche_coule.grille.InitGrille;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private GrilleDefense grille;
    private List<BateauDefense> bateaux;

    public Joueur(InitGrille initGrille, List<Bateau> bateaux) {
        grille = new GrilleDefense(initGrille);
        this.bateaux = new ArrayList<>();
        for (Bateau bateau : bateaux) {
            this.bateaux.add(new BateauDefense(bateau));
        }
    }

    public GrilleDefense getGrille() {
        return grille;
    }

}
