package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;
import BlackJack.view.Visitor;

public interface INewGameStrategy {
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
    void Round(Deck a_deck, Player a_player, boolean show);
}