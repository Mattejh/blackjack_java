package BlackJack.model.rules.Factory;

import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;

public interface AbstractFactory {
    IHitStrategy createHitStrategy();
    INewGameStrategy createNewGameStrategy();
}
