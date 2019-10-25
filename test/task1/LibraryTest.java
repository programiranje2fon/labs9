package task1;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import task1.Book;
import task1.library.Library;
import test.TestUtil;

public class LibraryTest {

	private Library instance;

	@Before
	public void setUp() throws Exception {
		instance = new Library();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void attribute_books() {
		assertTrue("There is no attribute \"books\" declared", TestUtil.doesFieldExist(Library.class, "books"));
	}
	
	@Test
	public void attribute_books_visibility() {
		assertTrue("Attribute \"books\" is not private", TestUtil.hasFieldModifier(Library.class, "books", Modifier.PRIVATE));
	}
	
	@Test
	public void attribute_books_type() {
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "books");
		
		assertTrue("Attribute \"books\" is not a LinkedList", LinkedList.class.isInstance(knjige));
	}
	
	@Test
	public void method_addBook() {
		Book k1 = new Book();
		instance.addBook(k1);
		
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "books");
		
		assertTrue("The method does not add a book to the list", knjige.contains(k1));
	}
	
	@Test
	public void method_isItAvailable() {
		Book k1 = new Book();
		instance.addBook(k1);
		
		assertTrue("When passing as argument a book that is already in the list, the method should return \"true\"", instance.isItAvailable(k1));
	}
	
	@Test
	public void method_deleteBook() {
		Book k1 = new Book();
		instance.addBook(k1);
		instance.deleteBook(k1);
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "books");
		
		assertTrue("The method does not remove a book (that was alreay in the list) from the list", !knjige.contains(k1));
	}
	
	@Test
	public void method_searchBooks() {
		Book k1 = new Book();
		k1.setTitle("Legenda o Taboru");
		instance.addBook(k1);
		
		Book k2 = new Book();
		k2.setTitle("Beleske jedne Ane");
		instance.addBook(k2);
		
		Book k3 = new Book();
		k3.setTitle("Konte");
		instance.addBook(k3);
		
		Book k4 = new Book();
		k4.setTitle("KO JE ALISA?");
		instance.addBook(k4);
		
		List<Book> pronadjeneKnjige = instance.searchBooks("ko");
		
		assertTrue("When the librray is composed of the foolowing books: \"Legenda o Taboru\", \"Beleske jedne Ane\", \"Konte\", \"KO JE ALISA?\", the method should return a list with the foolowing books: \"Konte\" and \"KO JE ALISA?\"", pronadjeneKnjige.size() == 2 && pronadjeneKnjige.contains(k3) && pronadjeneKnjige.contains(k4));
	}
	
	@Test
	public void method_archiveBooks() throws Exception {
		Book k1 = new Book();
		k1.setYear(2011);
		instance.addBook(k1);
		
		Book k2 = new Book();
		k2.setYear(2008);
		instance.addBook(k2);
		
		Book k3 = new Book();
		k3.setYear(2016);
		instance.addBook(k3);
		
		Book k4 = new Book();
		k4.setYear(2011);
		instance.addBook(k4);
		
		instance.archiveBooks(2011);
		
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "books");
		
		assertTrue("When the librray is composed of the books with the following release years: \"2011\", \"2008\", \"2016\", \"2011\", when passing as argument 2011, the method should have archived the books with years \"2008\" and \"2011\"", knjige.size() == 1 && !knjige.contains(k1) && !knjige.contains(k2) && !knjige.contains(k4));
	}
}
