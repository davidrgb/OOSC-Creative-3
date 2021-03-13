package model;

public class Ace extends Card {

    public Ace(Hand hand, boolean isAce) {
        super(11, hand, isAce);
    }

    @Override
    public String render() {
        return "A";
    }
}
