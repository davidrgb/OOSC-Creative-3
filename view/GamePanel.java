package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ButtonListener;
import model.Game;

public class GamePanel {
    
    private JFrame window;

    private GameCanvas canvas;

    private Game game;

    private JButton drawButton;
    private JButton holdButton;
    private JButton newGameButton;

    public GamePanel (JFrame window) {
        this.window = window;
    }

    public void init() {
        Container container = window.getContentPane();

        game = new Game();

        canvas = new GameCanvas(this);
        container.add(BorderLayout.CENTER, canvas);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,3));

        drawButton = new JButton("Draw");
        holdButton = new JButton("Hold");
        newGameButton = new JButton("New Game");

        ButtonListener listener = new ButtonListener(this);

        drawButton.addActionListener(listener);
        holdButton.addActionListener(listener);
        newGameButton.addActionListener(listener);

        controlPanel.add(drawButton);
        controlPanel.add(holdButton);
        controlPanel.add(newGameButton);

        container.add(BorderLayout.SOUTH, controlPanel);
    }

    public JButton getDrawButton() {
        return drawButton;
    }

    public JButton getHoldButton() {
        return holdButton;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public Game getGame() {
        return game;
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public void render(Graphics2D g2) {
        game.render(g2);
    }
}
