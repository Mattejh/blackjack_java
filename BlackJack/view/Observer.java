package BlackJack.view;

import BlackJack.model.Card;
import BlackJack.model.Player;

import java.util.List;

public interface Observer {
    void update(Player observable, List<Card> args);
}
