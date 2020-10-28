package BlackJack.view;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

// extends ensures all view classes must have observer methods
public interface IView extends Observer {
  void DisplayWelcomeMessage();
  int GetInput();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Player a_player);
  void DisplayDealerHand(Dealer a_player);
  void DisplayGameOver(boolean a_dealerIsWinner);
}