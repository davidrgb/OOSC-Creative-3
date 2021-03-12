package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ComputerHand extends Hand {

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final int INNER_OFFSET = 10;
    private final int RANK_OFFSET = 5;

    public ComputerHand() {
        super();
    }

    @Override
    public void draw() {
        if (getValue() < 17) {
            super.draw();
        }
    }

    @Override
    public void render(Graphics2D g2) {
        //g2.setColor(Color.black);
        g2.setFont(new Font("Courier New", Font.BOLD, 20));
        
        final int X_OFFSET = 50;
        final int Y_OFFSET = 100;
        for (int i = 0; i < getCards().size(); i++) {
            int cardXLocation = X_OFFSET + ((CARD_WIDTH + INNER_OFFSET) * i); // Calculates x location with offsets
            int cardYLocation = Y_OFFSET; // Calculates y location with offsets

            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card

            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card outline
            
            if (i < 1) {
                String rank = getCards().get(i).render(); // Stores card rank
                g2.drawString(rank, cardXLocation + RANK_OFFSET, cardYLocation + RANK_OFFSET); // Upper rank
                g2.drawString(rank, cardXLocation + CARD_WIDTH - RANK_OFFSET, cardYLocation + CARD_HEIGHT - RANK_OFFSET); // Lower rank
            }
        }
    }
}
