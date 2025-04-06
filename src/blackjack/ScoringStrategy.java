package blackjack;

public interface ScoringStrategy {
    int calculateScore(Hand<?> hand);
}
