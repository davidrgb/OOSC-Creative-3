package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Game.State;
import view.GamePanel;

public class ButtonListener implements ActionListener {
    
    private GamePanel panel;

    public ButtonListener(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getDrawButton()) {
            panel.getGame().draw();
            panel.getCanvas().repaint();
        }
        else if (button == panel.getHoldButton()) {
            panel.getGame().setState(State.HOLD);
            panel.getGame().comDraw();
            panel.getCanvas().repaint();
        }
        else if (button == panel.getNewGameButton()) {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var gamePanel = new GamePanel(window);
            gamePanel.init();
            window.pack();
            window.revalidate();
        }
        if (panel.getGame().getState() != State.PLAYING) {
            panel.getDrawButton().setEnabled(false);
            panel.getHoldButton().setEnabled(false);
        }
    }
}
