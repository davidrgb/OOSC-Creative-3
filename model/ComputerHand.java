package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import model.Game.State;

public class ComputerHand extends Hand {

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final int INNER_OFFSET = 10;

    public ComputerHand(Game game) {
        super(game);
    }

    @Override
    public void draw() {
        if (getValue() < 17) {
            super.draw();
        }
    }

    @Override
    public void checkHand() {
        if (getValue() > 21) {
            checkSwap();
            if (getValue() > 21) getGame().setState(State.WIN);
        }
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 32));
        
        final int X_OFFSET = 50;
        final int Y_OFFSET = 15;
        for (int i = 0; i < getCards().size(); i++) {
            int cardXLocation = X_OFFSET + ((CARD_WIDTH + INNER_OFFSET) * i); // Calculates x location with offsets
            int cardYLocation = Y_OFFSET; // Calculates y location with offsets

            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card

            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card outline
            
            String rank = getCards().get(i).render(); // Stores card rank
            int rankWidth = g2.getFontMetrics().stringWidth(rank);
            if (i != 1 || getGame().getState() != State.PLAYING) g2.drawString(rank, cardXLocation + (CARD_WIDTH / 2) - (rankWidth / 2), cardYLocation + (CARD_HEIGHT / 2) + (8));
        }
    }
}
