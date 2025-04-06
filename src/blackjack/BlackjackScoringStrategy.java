package blackjack;

public class BlackjackScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(Hand<?> hand) {
        int score = 0;
        int aceCount = 0;

        for (PlayableCard card : hand.getCards()) {
            score += card.value();
            if (((Card)card).faceValue == FaceValue.ACE) aceCount++;
        }

        // Consider Ace as 11 if it doesn't bust
        while (aceCount > 0 && score + 10 <= 21) {
            score += 10;
            aceCount--;
        }

        return score;
    }
}
