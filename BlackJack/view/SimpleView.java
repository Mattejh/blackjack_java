package BlackJack.view;

import BlackJack.model.*;
import BlackJack.model.rules.*;
import BlackJack.model.rules.Factory.*;

import java.util.LinkedList;
import java.util.List;

public class SimpleView implements IView {
    private Iterable<Card> a_PlayerHand = new LinkedList<>();
    private Iterable<Card> a_DealerHand = new LinkedList<>();

    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
        ;
        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public int GetInput() {
        try {
            int c = System.in.read();
            while (c == '\r' || c == '\n') {
                c = System.in.read();
            }
            return c;
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

    public void DisplayCard(Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Player a_player) {
        DisplayHand(a_PlayerHand, a_player);
    }

    public void DisplayDealerHand(Dealer a_dealer) {
        DisplayHand(a_DealerHand ,a_dealer);
    }

    private void DisplayHand(Iterable<Card> a_hand, Player a_player) {
        System.out.println(a_player.getPlayer() + " Has: ");
        // wait(1000);
        for (Card c : a_hand) {
          //  wait(1000);
            DisplayCard(c);
        }
        // wait(500);
        System.out.println("Score: " + a_player.CalcScore());
        System.out.println("");

    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }

    }

    @Override
    public void update(Player observable, List<Card> args) {
        if (observable instanceof Dealer) {
            this.a_DealerHand =  args;
        }
        else {
            this.a_PlayerHand = args;
        }
    }
    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitRules(AbstractFactory abstractFactory) {
        if (abstractFactory instanceof BasicAmericanRuleFactory) {
            System.out.println("Selected rules are basic American rules\n");
        }
        if (abstractFactory instanceof ComplexAmericanRuleFactory) {
            System.out.println("Selected rules are complex American rules\n");
        }
        if (abstractFactory instanceof BasicInternationalRuleFactory) {
            System.out.println("Selected rules are basic International rules\n");
        }
        if (abstractFactory instanceof ComplexInternationalRuleFactory) {
            System.out.println("Selected rules are complex International rules\n");
        }
    }
}
