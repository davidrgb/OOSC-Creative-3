package model;

import java.awt.Graphics2D;

public class Game {
    
    public enum State {
        PLAYING, WIN, LOSS
    }

    private State state = State.PLAYING;

    private Hand player;
    private ComputerHand computer;

    public Game() {
        player = new Hand();
        computer = new ComputerHand();
    }

    public void render(Graphics2D g2) {
        player.render(g2);
        computer.render(g2);
    }
}
