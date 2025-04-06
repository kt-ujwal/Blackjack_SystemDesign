package blackjack;

public interface PlayableCard {
    int value();
    boolean isAvailable();
    void setUnavailable();
    void print();
}