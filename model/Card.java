package model;

import java.awt.Font;
import java.awt.Graphics2D;

public class Card {

    private int value;
    private Hand hand;
    private boolean isAce;

    public Card(int value, Hand hand, boolean isAce) {
        this.value = value;
        this.hand = hand;
        this.isAce = isAce;
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

    public boolean getIsAce() {
        return isAce;
    }

    public void addCard() {
        hand.setValue(this);
    }

    public boolean swap() {
        hand.setValue(this);
        return false;
    }

    public String render() {
        return "" + value;
    }
}
