package appli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import bateau.*;
import grille.*;

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
        initPanel = new InitPanel();
        principal.add(initPanel);
        cl.show(principal, "principal");

        this.add(principal);
        this.setVisible(true);
    }

    public void setPanel(JPanel panel) {

    }
}
