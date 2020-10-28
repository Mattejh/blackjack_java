package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.view.Visitor;

public class BasicHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;
    private final int g_maxScore = 21;

    @Override
    public boolean DoHit(Player a_dealer) {
        return a_dealer.CalcScore() < g_hitLimit;
    }

    @Override
    public boolean DealerWins(Dealer a_dealer, Player a_player) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        }
        else if (a_dealer.CalcScore() == a_player.CalcScore() && a_dealer.CalcScore() < g_maxScore) {
            return true;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();
    }
}