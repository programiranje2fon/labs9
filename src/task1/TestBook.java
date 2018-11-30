package task1;

public class TestBook {

	public static void main(String[] args) {
		Book b1 = new Book();
		System.out.println(b1.getTitle().length());

		try {
			b1.setYear(2015);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
