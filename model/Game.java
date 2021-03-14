package model;

import java.awt.Graphics2D;

public class Game {
    
    public enum State {
        PLAYING, HOLD, WIN, LOSS, TIE
    }

    private State state = State.PLAYING;

    private Hand player;
    private ComputerHand computer;

    public Game() {
        player = new Hand(this);
        computer = new ComputerHand(this);
    }

    public void draw() {
        player.draw();
    }

    public void comDraw() {
        while (state == State.HOLD) {
            computer.draw();
            if (computer.getValue() > 21) {
                state = State.WIN;
            }
            else if (computer.getValue() > player.getValue()) {
                state = State.LOSS;
            }
            else if (computer.getValue() == player.getValue() && computer.getValue() >= 17) {
                state = State.TIE;
            }
            else if (computer.getValue() >= 17) {
                state = State.WIN;
            }
        }
    }

    public void render(Graphics2D g2) {
        player.render(g2);
        computer.render(g2);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void compareHands() {
        if (player.getValue() > computer.getValue()) {
            setState(State.WIN);
        }
        else if (computer.getValue() > player.getValue()) {
            setState(State.LOSS);
        }
        else {
            setState(State.TIE);
        }
    }
}
