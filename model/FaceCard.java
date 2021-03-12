package model;

public class FaceCard extends Card {

    private String rank;
    
    public FaceCard(int value, Hand hand) {
        super(10, hand);
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
