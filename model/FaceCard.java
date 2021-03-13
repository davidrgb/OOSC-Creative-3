package model;

public class FaceCard extends Card {

    private String rank;
    
    public FaceCard(int value, Hand hand, boolean isAce) {
        super(10, hand, isAce);
        switch (value) {
            case 11:
                rank = "J";
                break;
            case 12:
                rank = "Q";
                break;
            case 13:
                rank = "K";
                break;
        }
    }

    @Override
    public String render() {
        return rank;
    }
}
