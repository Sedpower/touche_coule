package appli;

import javax.swing.*;
import java.awt.*;

public class JeuPanel extends JPanel {

    private JPanel maGrillePanel, advGrillePanel;
    private Fenetre fenetre;

    public JeuPanel(Fenetre fenetre) {
        this.fenetre = fenetre;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(100, 100));
        maGrillePanel = new JPanel(new GridLayout(10, 10));
        advGrillePanel = new JPanel(new GridLayout(10, 10));
        maGrillePanel.setPreferredSize(new Dimension(400,400));
        advGrillePanel.setPreferredSize(new Dimension(500, 500));
        for(int i = 0; i<100;i++) {
            maGrillePanel.add(new JButton("test"));
            advGrillePanel.add(new JButton("test"));
        }
        this.add(maGrillePanel);
        this.add(advGrillePanel);
    }
}
