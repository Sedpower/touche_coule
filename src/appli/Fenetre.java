package appli;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private CardLayout cl = new CardLayout();
    private JPanel principal = new JPanel();
    public InitPanel initPanel;

    public Fenetre() {
        super("Création de la partie");
        this.setSize(900, 900);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        principal.setLayout(cl);
        initPanel = new InitPanel(this);
        principal.add(initPanel);
        cl.show(principal, "Panel d'initiation de la grille de la partie");

        this.add(principal);
        this.setVisible(true);
    }

    public void setPanel(JPanel panel) {
        principal.add(panel,"Panel de jeu");
        cl.show(principal, "Panel de jeu");
    }

    public void changeSize(Dimension dimension) {
        this.setSize(dimension);
    }

    public void removeInit() {
        initPanel.removeListener();
        this.remove(initPanel);
    }
}