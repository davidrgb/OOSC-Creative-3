package model;

public class Ace extends Card {

    public Ace(Hand hand) {
        super(11, hand);
    }

    @Override
    public void addCard() {
        if (getHand().getValue() + 11 > 21) {
            setValue(1);
        }
        super.addCard();
    }

    @Override
    public String render() {
        return "A";
    }
}
