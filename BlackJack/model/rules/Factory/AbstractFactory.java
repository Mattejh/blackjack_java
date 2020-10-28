package BlackJack.model.rules.Factory;

import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.view.Visitor;

public interface AbstractFactory {
    IHitStrategy createHitStrategy();
    INewGameStrategy createNewGameStrategy();
    void accept(Visitor visitor);
}
