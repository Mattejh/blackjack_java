package BlackJack.model;

import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.view.Visitor;

public class Dealer extends Player {

  private final String dealer = "Dealer";
  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;

  public Dealer() {

    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }

  public void setNewGameRule(INewGameStrategy m_newGameRule) {
    this.m_newGameRule = m_newGameRule;
  }

  public void setHitRule(IHitStrategy m_hitRule) {
    this.m_hitRule = m_hitRule;
  }

  public INewGameStrategy getNewGameRule() {
    return m_newGameRule;
  }

  public IHitStrategy getHitRule() {
    return m_hitRule;
  }

  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver(a_player)) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() <= g_maxScore && !IsGameOver(a_player)) {
      m_newGameRule.Round(m_deck, a_player, true);
      if (m_hitRule.DoHit(this)) {
        m_newGameRule.Round(m_deck, this, true);
      }
      return true;
    }
    return false;
  }

  public boolean Stand() {
    if (m_deck != null) {
      ShowHand();
      for (Card c: GetHand()) {
        GetHand();
        c.Show(true);
      }

      while (m_hitRule.DoHit(this)) {
        m_hitRule.DoHit(this);
        m_newGameRule.Round(m_deck,this,true);

      }
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_hitRule.DealerWins(this, a_player);
  }

  public boolean IsGameOver(Player a_player) {
    this.ShowHand();

    if ((this.CalcScore() > g_maxScore || a_player.CalcScore() > g_maxScore) && m_deck != null) {
      return true;
    }
    if ((this.CalcScore() == g_maxScore || a_player.CalcScore() == g_maxScore) && m_deck != null) {
      return true;
    }
    return m_deck != null && !m_hitRule.DoHit(this);
  }

  @Override
  public String getPlayer() {
    return dealer;
  }

}