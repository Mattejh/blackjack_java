package BlackJack.model.rules.Factory;

import BlackJack.model.rules.AmericanNewGameStrategy;
import BlackJack.model.rules.ComplexHitStrategy;
import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.view.Visitor;

public class ComplexAmericanRuleFactory implements AbstractFactory {

    @Override
    public IHitStrategy createHitStrategy() {
        return new ComplexHitStrategy();
    }

    @Override
    public INewGameStrategy createNewGameStrategy() {
        return new AmericanNewGameStrategy();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRules(this);
    }
}
