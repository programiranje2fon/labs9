package task2;

public class TestRestorants {

	public static void main(String[] args) {
		
		Restaurant r1 = new Restaurant();
		r1.setName("Blue Hill");
		r1.setRating(4);
		
		Restaurant r2 = new Restaurant();
		r2.setName("Per Se");
		r2.setRating(1);
		
		Restaurant r3 = new Restaurant();
		r3.setName("Daniel");
		r3.setRating(4);
		
		RestaurantGuide guide = new RestaurantGuide();
		guide.addAsFirst(r1);
		guide.addAsFirst(r2);
		guide.addAsFirst(r3);
		
		guide.printsRestaurantsWithRating(4);
		
		guide.removeBadRestaurants();
	}

}
