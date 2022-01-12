package pizza;

import pizza.decorators.JalapenoDecorator;

public class OrderSystem {

    public static void main(String[] args) {

        Pizza pizza = new Margherita();

        Pizza decoratedPizza = new JalapenoDecorator(new JalapenoDecorator(pizza));

        System.out.println("Ingredients : " + pizza.getIngredients());
        System.out.println("Price: " + pizza.getCost());

        System.out.println("Ingredients : " + decoratedPizza.getIngredients());
        System.out.println("Price: " + decoratedPizza.getCost());

    }
}
