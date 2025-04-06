package blackjack;

import java.util.List;

public interface GameObserver {
    void onGameEnd(List<Integer> winners);
}
