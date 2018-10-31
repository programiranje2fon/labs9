package task2;

public class Restaurant {

	private String name;
	private int rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			throw new RuntimeException("ERROR");
		}
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if (rating >= 1 && rating <= 5) {
			this.rating = rating;
		} else {
			throw new RuntimeException("ERROR");
		}
	}

}
