package pizza;

public class Margherita implements Pizza {


    @Override
    public int getCost() {
        return 60;
    }

    @Override
    public String getIngredients() {
        return "Cheese, Tomato sauce";
    }
}
