package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import model.Game;

public class GamePanel {
    
    private JFrame window;

    private GameCanvas canvas;

    private Game game;

    public GamePanel (JFrame window) {
        this.window = window;
    }

    public void init() {
        Container container = window.getContentPane();

        game = new Game();

        canvas = new GameCanvas(this);
        container.add(BorderLayout.CENTER, canvas);
    }

    public void render(Graphics2D g2) {
        game.render(g2);
    }
}
