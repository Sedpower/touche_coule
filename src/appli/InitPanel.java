package appli;

import controle.InitControle;
import grille.*;

import javax.swing.*;
import java.awt.*;

public class InitPanel extends JPanel {

    private Grille grille;
    private JRadioButton vertical, horizontal;
    private JPanel grillePanel, orientationPanel, infoPanel;
    private JLabel info;
    private ButtonGroup g;
    private InitControle initControle;

    public InitPanel(Fenetre fenetre) {
        this.setLayout(new BorderLayout());
        ///////////////// Panel de la grille joueur /////////////////
        grillePanel = new JPanel(new GridLayout(10, 10));
        grillePanel.setPreferredSize(new Dimension(600,600));
        grille = new Grille();
        initControle = new InitControle(fenetre, grille, this);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Case caseGrille = grille.getCase(i, j);
                caseGrille.addActionListener(initControle);
                caseGrille.addMouseListener(initControle);
                grillePanel.add(caseGrille);
            }
        }
        this.add(grillePanel, BorderLayout.CENTER);

        ///////////////// Panel de l'orientation du bateau /////////////////
        orientationPanel = new JPanel(new FlowLayout());
        horizontal = new JRadioButton("Horizontal", true);
        vertical = new JRadioButton("Vertical");
        horizontal.addActionListener(initControle);
        vertical.addActionListener(initControle);
        g = new ButtonGroup();
        g.add(horizontal);
        g.add(vertical);
        orientationPanel.add(horizontal);
        orientationPanel.add(vertical);
        this.add(orientationPanel, BorderLayout.NORTH);

        ///////////////// Panel de l'info action /////////////////
        infoPanel = new JPanel(new FlowLayout());
        info = new JLabel(InitControle.getAction());
        infoPanel.add(info);
        this.add(infoPanel, BorderLayout.SOUTH);
    }

    public void setInfo() {
        info.setText(InitControle.getAction());
        horizontal.setSelected(true);
        info.setForeground(Color.black);
    }

    public void setError(String erreur) {
        info.setText(erreur);
        info.setForeground(Color.RED);
    }

    public void removeListener() {
        horizontal.removeActionListener(initControle);
        vertical.removeActionListener(initControle);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Case caseGrille = grille.getCase(i, j);
                caseGrille.removeMouseListener(initControle);
                caseGrille.removeActionListener(initControle);
            }
        }
    }
}
