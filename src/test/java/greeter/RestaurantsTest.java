package greeter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RestaurantsTest {

    @Test
    void givenAValidNameANewRestaurantShouldBeSaved() {
        RestaurantDao restaurantDao = Mockito.mock(RestaurantDao.class);
        Restaurants restaurants = new Restaurants(restaurantDao);

        restaurants.createRestaurant("Panchos");

        Mockito.verify(restaurantDao).save(new Restaurant("Panchos"));
    }


}
