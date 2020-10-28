package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.Factory.ComplexAmericanRuleFactory;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    IView v = new SimpleView(); //new SwedishView();
    Game g = new Game(new ComplexAmericanRuleFactory());
    PlayGame ctrl = new PlayGame(v,g);
    
    while (ctrl.Play());
  }
}