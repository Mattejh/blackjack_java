package BlackJack.view;

import BlackJack.model.rules.Factory.AbstractFactory;

public interface Visitor {
    void visitRules(AbstractFactory abstractFactory);
}
