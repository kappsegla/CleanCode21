package greeter;

public class Restaurants {
    private RestaurantDao restaurantDao;

    public Restaurants(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public void createRestaurant(String name) {
        Restaurant restaurant = new Restaurant(name);
        restaurantDao.save(restaurant);
    }
}

