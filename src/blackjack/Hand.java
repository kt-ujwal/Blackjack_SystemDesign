package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand <T extends PlayableCard> {
    protected List<T> cards = new ArrayList<T>();
    protected ScoringStrategy scoringStrategy;

    public void setScoringStrategy(ScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }

    public int score(){
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void removeCard(T card) {
        cards.remove(card);
    }

    public void print() {
        for (T card : cards) {
            card.print();
        }
    }

    public List<T> getCards() {
        return cards;
    }
}
