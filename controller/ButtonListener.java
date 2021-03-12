package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
    }
}
