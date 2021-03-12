import javax.swing.JFrame;

import view.GamePanel;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(500, 200);
        window.setTitle("Blackjack");

        var panel = new GamePanel(window);
        panel.init();

        window.pack();
        window.setVisible(true);
    }
}
