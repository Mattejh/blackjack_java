package BlackJack.model.rules.Factory;

import BlackJack.model.rules.*;
import BlackJack.view.Visitor;

public class BasicAmericanRuleFactory implements AbstractFactory {


    @Override
    public IHitStrategy createHitStrategy() {
        return new BasicHitStrategy();
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
