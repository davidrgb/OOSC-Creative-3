package model;

import java.util.ArrayList;

public class Deck {
    
    public static final ArrayList<Card> deck = new ArrayList();

    static {
        /*deck.add(new Ace());
        for (int i = 2; i <= 10; i++) {
            deck.add(new Card(i));
        }
        for (int i = 11; i <= 13; i++){
            deck.add(new FaceCard(i));
        }*/
    }
}
