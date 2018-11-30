package task1;

import java.util.GregorianCalendar;

public class Book {

	private String title = "";
	private int year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null) {
			throw new RuntimeException("Title cannot be NULL");
		} else {
			this.title = title;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) throws Exception {
		GregorianCalendar now = new GregorianCalendar();

		if (year >= 1950 && year <= now.get(GregorianCalendar.YEAR)) {
			this.year = year;
		} else {
			throw new Exception("Year is not in the appropriate range");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)) {
			return false;
		}

		Book b1 = (Book) obj;

		return this.title.equals(b1.title) && this.year == b1.year;
	}
}
