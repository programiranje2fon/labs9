package task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantGuide {

	private List<Restaurant> restaurants;
	
	public RestaurantGuide() {
		restaurants = new ArrayList<>();
	}
	
	public void addAsFirst(Restaurant restaurant) {
		restaurants.add(0, restaurant);
	}
	
	public void printsRestaurantsWithRating(int rating) {
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getRating() == rating) {
				System.out.println(restaurant.getName());
			}
		}
	}
	
	public void removeBadRestaurants() {
		Iterator<Restaurant> iterator = restaurants.iterator();
		
		while (iterator.hasNext()) {
			Restaurant restaurant = (Restaurant) iterator.next();
			
			if (restaurant.getRating() == 1) {
				iterator.remove();
			}
		}
	}
}
