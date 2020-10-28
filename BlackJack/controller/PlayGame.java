package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.view.IView;
import BlackJack.view.Visitor;

public class PlayGame implements Visitable {
    private IView a_view;
    private Game a_game;

    public PlayGame(IView a_view, Game a_game) {
        this.a_game = a_game;
        this.a_view = a_view;
        this.a_game.getPlayer().addObserver(a_view);
        this.a_game.getDealer().addObserver(a_view);
    }

    public boolean Play() {
        a_view.DisplayWelcomeMessage();
        accept(a_view);

        a_view.DisplayPlayerHand(a_game.getPlayer());
        a_view.DisplayDealerHand(a_game.getDealer());

        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }

        int input = a_view.GetInput();

        if (input == 'p') {
             a_game.NewGame();
        } else if (input == 'h') {
            a_game.Hit();
        } else if (input == 's') {
            a_game.Stand();
        }

        return input != 'q';
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitHitRule(a_game.getDealer().getHitRule());
        visitor.visitNewGameRule(a_game.getDealer().getNewGameRule());
    }
}