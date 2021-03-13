package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Game;

public class GameCanvas extends JPanel {
    
    private GamePanel panel;

    public GameCanvas (GamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(600, 350));
        setBackground(Color.green);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        panel.render(g2);

        Game.State state = panel.getGame().getState();

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Courier New", Font.BOLD, 36));
        final int X_OFFSET = 50;
        final int Y_OFFSET = 185;

        if (state == Game.State.WIN) {
            g2.drawString("YOU WIN", X_OFFSET, Y_OFFSET);
        }
        else if (state == Game.State.LOSS) {
            g2.drawString("YOU LOSE", X_OFFSET, Y_OFFSET);
        }
        else if (state == Game.State.TIE) {
            g2.drawString("YOU TIE", X_OFFSET, Y_OFFSET);
        }
    }
}
