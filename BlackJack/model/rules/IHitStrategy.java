package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.view.Visitor;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
    boolean DealerWins(Dealer a_dealer, Player a_player);
}