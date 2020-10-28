package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetBasicHitRule() {
    return new BasicHitStrategy();
  }

  public IHitStrategy GetComplexHitRule() { return new ComplexHitStrategy();}

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}