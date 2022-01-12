package pizza.decorators;

import pizza.Pizza;

public class JalapenoDecorator extends PizzaDecorator{

    public JalapenoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return 10 + pizza.getCost();
    }

    @Override
    public String getIngredients() {
        return pizza.getIngredients() + ", Jalapeno";
    }
}
