package blackjack;

import java.util.List;

public interface Game {
    void initialize();
    void play();
    List<Integer> getWinners();
}
