package task1.library;

import task1.Book;

public class TestLibrary {

	public static void main(String[] args) {
		
		Book b1 = new Book();
		b1.setTitle("Signs by the Road");
		try {
			b1.setYear(1976);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Book b2 = new Book();
		b2.setTitle("Mansarda");
		try {
			b2.setYear(1960);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Library library = new Library();
		library.addBook(b1);
		library.addBook(b2);
		
		library.archiveBooks(2010);
	}
}
