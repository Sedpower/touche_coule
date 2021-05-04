package fr.sedpower.touche_coule;

import fr.sedpower.touche_coule.appli.Fenetre;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Fenetre fenetre = new Fenetre();
            }
        });
    }
}