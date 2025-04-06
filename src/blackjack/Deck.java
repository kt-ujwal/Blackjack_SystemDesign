package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck <T extends Card>{
    private List<T> cards;
    private int dealtIndex = 0;
    public Deck(List<T> cards) {
        this.cards = cards;
        this.shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void setDeckOfCards(ArrayList<T> cards) {
        this.cards = cards;
    }
    public int remainingCards() {
        return cards.size() - dealtIndex;
    }


    public T dealCard(){
        if(remainingCards() == 0){
            return null;
        }
        T card = cards.get(dealtIndex);
        dealtIndex++;
        card.setUnavailable();
        return card;
    }

}
