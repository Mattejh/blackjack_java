package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;

class InternationalNewGameStrategy extends AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Round(a_deck, a_player, true);
    Round(a_deck, a_dealer, true);
    Round(a_deck, a_player, true);
    return true;
  }
}