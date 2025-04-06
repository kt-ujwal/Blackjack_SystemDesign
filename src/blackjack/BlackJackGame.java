package blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame implements Game{
    private final int numPlayers;
    private Deck<Card> deck;
    private final List<Hand<Card>> hands = new ArrayList<>();
    private final List<GameObserver> observers = new ArrayList<>();
    private static final int HIT_UNTIL = 16;

    public BlackJackGame(int numPlayers, Deck<Card> deck) {
        this.numPlayers = numPlayers;
        this.deck = deck;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void initialize() {
        for (int i = 0; i < numPlayers; i++) {
            Hand<Card> hand = new Hand<>();
            hand.setScoringStrategy(new BlackjackScoringStrategy());
            hands.add(hand);
        }
    }

    @Override
    public void play() {
        for (Hand<Card> hand : hands) {
            hand.addCard(deck.dealCard());
            hand.addCard(deck.dealCard());
        }
    }


    @Override
    public List<Integer> getWinners() {
        int best = 0;
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < hands.size(); i++) {
            int score = hands.get(i).score();
            if (score > best && score <= 21) {
                best = score;
                winners.clear();
                winners.add(i);
            } else if (score == best) {
                winners.add(i);
            }
        }
        for (GameObserver observer : observers) {
            observer.onGameEnd(winners);
        }
        return winners;
    }
}
