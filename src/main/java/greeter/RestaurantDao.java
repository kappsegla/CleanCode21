package greeter;

import java.util.List;

public interface RestaurantDao {
    List<Restaurant> getAll();

    void save(Restaurant restaurant);
}
