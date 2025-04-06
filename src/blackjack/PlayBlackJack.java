package blackjack;

import java.util.List;

public class PlayBlackJack {
    public static void run() {
        Deck<Card> deck = DeckFactory.createStandardDeck();
        BlackJackGame game = new BlackJackGame(3, deck);

        game.addObserver(winners -> System.out.println("Winners: " + winners));

        game.initialize();
        game.play();

        System.out.println("Final Scores:");
        game.getWinners();
    }
}
