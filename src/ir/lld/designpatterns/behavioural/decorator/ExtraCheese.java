package ir.lld.designpatterns.behavioural.decorator;

public class ExtraCheese extends ToppingDecorator{

    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
            return this.basePizza.getCost() + 10;
    }
}
