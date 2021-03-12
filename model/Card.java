package model;

import java.awt.Font;
import java.awt.Graphics2D;

public class Card {

    private int value;
    private Hand hand;

    public Card(int value, Hand hand) {
        this.value = value;
        this.hand = hand;
        addCard();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Hand getHand() {
        return hand;
    }

    public void addCard() {
        hand.setValue(this);
    }

    public String render() {
        return "" + value;
    }
}
