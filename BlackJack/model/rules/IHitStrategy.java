package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
    boolean DealerWins(Dealer a_dealer, Player a_player);
}