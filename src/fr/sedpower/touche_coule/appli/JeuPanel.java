package fr.sedpower.touche_coule.appli;

import fr.sedpower.touche_coule.bateau.Bateau;
import fr.sedpower.touche_coule.controle.JeuControle;
import fr.sedpower.touche_coule.grille.CaseDefense;
import fr.sedpower.touche_coule.grille.GrilleDefense;
import fr.sedpower.touche_coule.grille.InitGrille;
import fr.sedpower.touche_coule.joueur.IA;
import fr.sedpower.touche_coule.joueur.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JeuPanel extends JPanel {

    private JPanel maGrillePanel, advGrillePanel, grillesPanel, infoPanel;
    private JLabel info;
    private GrilleDefense grilleDefense;
    private JeuControle jeuControle;

    public JeuPanel(Fenetre fenetre, Joueur joueur, IA ia) {
        this.setLayout(new BorderLayout());
        fenetre.changeSize(new Dimension(1100, 600));
        ///////////////// Panel des grilles fr.sedpower.touche_coule.joueur /////////////////
        grillesPanel = new JPanel(new FlowLayout());

        maGrillePanel = new JPanel(new GridLayout(10, 10));
        maGrillePanel.setPreferredSize(new Dimension(500,500));

        advGrillePanel = new JPanel(new GridLayout(10, 10));
        advGrillePanel.setPreferredSize(new Dimension(500, 500));

        grilleDefense = joueur.getGrille();
        // TODO Grille attaque

        jeuControle = new JeuControle(fenetre, joueur, this);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CaseDefense caseGrilleDefense = grilleDefense.getCase(i, j);
                maGrillePanel.add(caseGrilleDefense);
                //caseGrilleDefense.addActionListener(jeuControle);*/
                //caseGrilleDefense.addMouseListener(jeuControle);
                // TODO Grille attaque
            }
        }
        for(int i = 0; i<100;i++) {
            advGrillePanel.add(new JButton("test"));
        }
        //advGrillePanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        //maGrillePanel.setBorder(new EmptyBorder(0, 0, 0, 20));
        grillesPanel.add(maGrillePanel);
        grillesPanel.add(advGrillePanel);
        this.add(grillesPanel, BorderLayout.CENTER);

        infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setPreferredSize(new Dimension(0, 50));
        info = new JLabel("");
        infoPanel.add(info, new GridBagConstraints());
        this.add(infoPanel, BorderLayout.SOUTH);

    }
}