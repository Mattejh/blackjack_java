package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;
import BlackJack.view.Visitor;

public class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Round(a_deck, a_player, true);
    Round(a_deck, a_dealer, true);
    Round(a_deck,a_player, true);
    Round(a_deck, a_dealer, a_dealer.CalcScore() >= 17);
    return true;
  }

  public void Round(Deck a_deck, Player a_player, boolean show) {
    Card c;
    c = a_deck.GetCard();
    c.Show(show);
    a_player.DealCard(c);
  }
}