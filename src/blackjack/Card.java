package blackjack;

public class Card implements PlayableCard{
    protected Suit suit;
    protected FaceValue faceValue;
    private boolean available = true;

    public Card(Suit suit, FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public int value(){
        return faceValue.getValue();
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setUnavailable() {
        this.available = false;
    }

    public void print() {
        System.out.println(faceValue + " of " + suit);
    }

}
