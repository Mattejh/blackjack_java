package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.view.Visitor;

public class ComplexHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;
    private final int g_maxScore = 21;

    @Override
    public boolean DoHit(Player a_dealer) {
        if (a_dealer.CalcScore() < g_hitLimit) {
            return true;

        }
        else if (a_dealer.CalcScore() == g_hitLimit) {
            for (Card c : a_dealer.GetHand()) {
                if (c.GetValue() == Card.Value.Ace) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean DealerWins(Dealer a_dealer, Player a_player) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        }
        if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        }
        if (a_dealer.CalcScore() == a_player.CalcScore() && a_dealer.CalcScore() <= g_maxScore) {
            return true;
        }
        if (a_dealer.CalcScore() > a_player.CalcScore() && a_dealer.CalcScore() <= g_maxScore) {
            return true;
        }

        return false;
    }
}
