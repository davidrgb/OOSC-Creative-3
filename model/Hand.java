package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.Random;

public class Hand {

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final int INNER_OFFSET = 10;
    private final int RANK_OFFSET = 5;
    
    private static final int NUM_OF_RANKS = 13;

    private ArrayList<Card> cards = new ArrayList<>();
    private int value;
    private boolean bust;
    
    public Hand() {
        draw();
        draw();

        bust = false;
    }

    public void draw() {
        Random rand = new Random();
        int value = rand.nextInt(NUM_OF_RANKS);

        if (value > 10) {
            cards.add(new FaceCard(value, this));
        }
        else if (value > 1) {
            cards.add(new Card(value, this));
        }
        else {
            cards.add(new Ace(this));
        }
    }

    public void checkHand() {
        if (value > 21) {
            bust = true;
        }
        else if (value == 21) {
            //WIN
        }
        // LESS THAN 21 BUT HOLD
        // LESS THAN 21
    }

    public void setValue(Card card) {
        value += card.getValue();
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void render(Graphics2D g2) {
        //g2.setColor(Color.black);
        g2.setFont(new Font("Courier New", Font.BOLD, 20));
        
        final int X_OFFSET = 50;
        final int Y_OFFSET = 400;
        for (int i = 0; i < cards.size(); i++) {
            int cardXLocation = X_OFFSET + ((CARD_WIDTH + INNER_OFFSET) * i); // Calculates x location with offsets
            int cardYLocation = Y_OFFSET; // Calculates y location with offsets

            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card

            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card outline
            
            String rank = cards.get(i).render(); // Stores card rank
            g2.drawString(rank, cardXLocation + RANK_OFFSET, cardYLocation + RANK_OFFSET); // Upper rank
            g2.drawString(rank, cardXLocation + CARD_WIDTH - RANK_OFFSET, cardYLocation + CARD_HEIGHT - RANK_OFFSET); // Lower rank
        }
    }
}
