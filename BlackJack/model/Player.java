package BlackJack.model;

import BlackJack.view.Observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player implements Observable {

  private List<Card> m_hand;
  protected List<BlackJack.view.Observer> observers;
  private final String player = "Player";
  protected final int g_maxScore = 21;

  public Player() {
    observers = new ArrayList<>();
    m_hand = new LinkedList<Card>();
    System.out.println("Hello List World");
  }

  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand);
    notifyObserver();
  }

  public Iterable<Card> GetHand()
  {
    return m_hand;
  }

  public void ClearHand()
  {
    m_hand.clear();
    notifyObserver();
  }

  public void ShowHand()
  {
    for(Card c : GetHand())
    {
      c.Show(true);
    }
  }

  public int CalcScore()
  {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do thisCavett check at compile time in java ?!
    // cardScores[13] = {...};
    int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";


    int score = 0;

    for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += cardScores[c.GetValue().ordinal()];
        }
    }

    if (score > g_maxScore)
    {
        for(Card c : GetHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }

    return score;
  }

    public String getPlayer() {
        return player;
    }

    public void addObserver(BlackJack.view.Observer o) {
      observers.add(o);
    }

    public void notifyObserver() {
      for (Observer observer : observers) {
        observer.update(this, m_hand);
      }
    }
}
