package BlackJack.model.rules.Factory;

import BlackJack.model.rules.BasicHitStrategy;
import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.InternationalNewGameStrategy;
import BlackJack.view.Visitor;

public class BasicInternationalRuleFactory implements AbstractFactory {

    @Override
    public IHitStrategy createHitStrategy() {
        return new BasicHitStrategy();
    }

    @Override
    public INewGameStrategy createNewGameStrategy() {
        return new InternationalNewGameStrategy();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRules(this);
    }
}
