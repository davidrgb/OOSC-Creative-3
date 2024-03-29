package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.Random;

import model.Game.State;

public class Hand {

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final int INNER_OFFSET = 10;
    
    private static final int NUM_OF_RANKS = 13;

    private ArrayList<Card> cards = new ArrayList<>();
    private int value;

    private Game game;
    
    public Hand(Game game) {
        this.game = game;

        value = 0;

        draw();
        draw();
    }

    public void draw() {
        if (game.getState() == State.PLAYING || game.getState() == State.HOLD) {
            Random rand = new Random();
            int value = rand.nextInt(NUM_OF_RANKS) + 1;

            if (value > 10) {
                cards.add(new FaceCard(value, this, false));
            }
            else if (value > 1) {
                cards.add(new Card(value, this, false));
            }
            else {
                cards.add(new Ace(this, true));
            }

            checkHand();
        }
    }

    public void checkHand() {
        if (value > 21) {
            checkSwap();
            if (value > 21) game.setState(State.LOSS);
            else if (value == 21) game.setState(State.WIN);
        }
        else if (value == 21) {
            game.setState(State.WIN);
        }
    }

    public void checkSwap() {
        value = 0;
        for (Card c: cards) {
            if (!c.getIsAce()) {
                c.addCard();
            }
        }
        aceCalculation();
    }

    public void aceCalculation() {
        int aceValue = 21 - value;
        int aces = 0;
        for (Card c: cards) {
            if (c.getIsAce()) {
                aces++;
            }
        }
        for (Card c: cards) {
            if (c.getIsAce()) {
                if ((11 + (aces - 1)) <= aceValue) {
                    c.setValue(11);
                    aceValue = aceValue - 11;
                }
                else {
                    c.setValue(1);
                    --aceValue;
                }
                c.addCard();
            }
        }
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

    public Game getGame() {
        return game;
    }

    public void render(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 32));
        
        final int X_OFFSET = 50;
        final int Y_OFFSET = 215;
        for (int i = 0; i < cards.size(); i++) {
            int cardXLocation = X_OFFSET + ((CARD_WIDTH + INNER_OFFSET) * i); // Calculates x location with offsets
            int cardYLocation = Y_OFFSET; // Calculates y location with offsets

            g2.setColor(Color.white);
            g2.fillRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card

            g2.setColor(Color.black);
            g2.drawRect(cardXLocation, cardYLocation, CARD_WIDTH, CARD_HEIGHT); // Draws card outline
            
            String rank = cards.get(i).render(); // Stores card rank
            int rankWidth = g2.getFontMetrics().stringWidth(rank);
            g2.drawString(rank, cardXLocation + (CARD_WIDTH / 2) - (rankWidth / 2), cardYLocation + (CARD_HEIGHT / 2) + (8));
        }
    }
}
