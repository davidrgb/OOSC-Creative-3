package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameCanvas extends JPanel {
    
    private GamePanel panel;

    public GameCanvas (GamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(600, 300));
        setBackground(Color.green);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        panel.render(g2);
    }
}
