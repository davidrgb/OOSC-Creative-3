package model;

public class Ace extends Card {

    //private boolean swapped;

    public Ace(Hand hand, boolean isAce) {
        super(11, hand, isAce);
    }

    /*@Override
    public void addCard() {
        /*if (getValue() == 11) {
            swapped = false;
        }
        else {
            swapped = true;
        }
        //swap();
        super.addCard();
    }*/

    /*@Override
    public boolean swap() {
        if (!swapped) {
            if (getHand().getValue() + 11 > 21) {
                System.out.println("BEFORE: " + getValue());
                setValue(1);
                swapped = true;
                System.out.println("AFTER: " + getValue());
            }
            else {
                swapped = false;
            }
        }
        return swapped;
    }*/

    @Override
    public String render() {
        return "A";
    }
}
