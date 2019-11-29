package task1.library;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import task1.Book;

public class Library {

	private List<Book> books = new LinkedList<>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public boolean isItAvailable(Book book) {
		return books.contains(book);
	}
	
	public void deleteBook(Book book) {
		books.remove(book);
	}
	
	public List<Book> searchBooks(String sampleText) {
		List<Book> booksWithTitle = new LinkedList<>();
		
		for (Book book : books) {
			if (book.getTitle().toLowerCase().startsWith(sampleText.toLowerCase())) {
				booksWithTitle.add(book);
			}
		}
		
		return booksWithTitle;
	}
	
	public void archiveBooks(int year) {
		Iterator<Book> iterator = books.iterator();
		
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			
			if (book.getYear() <= year) {
				iterator.remove();
			}
		}
	}
}
