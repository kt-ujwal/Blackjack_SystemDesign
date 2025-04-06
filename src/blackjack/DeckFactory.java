package blackjack;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {
    public static Deck<Card> createStandardDeck() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (FaceValue fv : FaceValue.values()) {
                cards.add(new Card(suit, fv));
            }
        }
        return new Deck<>(cards);
    }
}
