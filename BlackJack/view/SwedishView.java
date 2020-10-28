package BlackJack.view;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.rules.*;

import java.util.LinkedList;
import java.util.List;

public class SwedishView implements IView {
    private Iterable<Card> a_PlayerHand = new LinkedList<>();
    private Iterable<Card> a_DealerHand = new LinkedList<>();

    public void DisplayWelcomeMessage() {

        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
        ;

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
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
        if (a_card.GetColor() == Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        } else {
            String colors[] =
                    {"Hjärter", "Spader", "Ruter", "Klöver"};
            String values[] =
                    {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }



    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("Slut: ");
        if (a_dealerIsWinner) {
            System.out.println("Croupiern Vann!");
        } else {
            System.out.println("Du vann!");
        }
    }

    public void DisplayPlayerHand(Player a_player) {
        DisplayHand(a_PlayerHand, a_player);
    }

    public void DisplayDealerHand(Dealer a_dealer) {
        DisplayHand(a_DealerHand, a_dealer);
    }

    private void DisplayHand(Iterable<Card> a_hand, Player a_player) {
        System.out.println(a_player.getPlayer() + " Har: ");
        for (Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + a_player.CalcScore());
        System.out.println("");

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

    @Override
    public void visitHitRule(IHitStrategy iHitStrategy) {
        if (iHitStrategy instanceof BasicHitStrategy) {
            System.out.print("Selected rules are basic ");
        }
        if (iHitStrategy instanceof ComplexHitStrategy) {
            System.out.print( "Selected rules are complex ");
        }

    }

    @Override
    public void visitNewGameRule(INewGameStrategy iNewGameStrategy) {
        if (iNewGameStrategy instanceof AmericanNewGameStrategy) {
            System.out.print("American rules\n\n");
        }
        if (iNewGameStrategy instanceof InternationalNewGameStrategy) {
            System.out.print("International rules\n\n");
        }
    }
}
