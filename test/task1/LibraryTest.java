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
	public void atribut_knjige() {
		assertTrue("U klasi nije definisan atribut books", TestUtil.doesFieldExist(Library.class, "books"));
	}
	
	@Test
	public void atribut_knjige_vidljivost() {
		assertTrue("Atribut books nije privatan", TestUtil.hasFieldModifier(Library.class, "books", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_knjige_tipLinkedList() {
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "books");
		
		assertTrue("Atribut books nije tipa LinkedList", LinkedList.class.isInstance(knjige));
	}
	
	@Test
	public void metoda_dodajKnjigu() {
		Book k1 = new Book();
		instance.addBook(k1);
		
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "books");
		
		assertTrue("Metoda nije dodala knjigu u listu books", knjige.contains(k1));
	}
	
	@Test
	public void metoda_daLiPostoji() {
		Book k1 = new Book();
		instance.addBook(k1);
		
		assertTrue("Metoda nije vratila TRUE za knjigu koja je dodata u listu books", instance.isItAvailable(k1));
	}
	
	@Test
	public void metoda_obrisiKnjigu() {
		Book k1 = new Book();
		instance.addBook(k1);
		instance.deleteBook(k1);
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "books");
		
		assertTrue("Metoda nije vratila TRUE za knjigu koja je dodata u listu books", !knjige.contains(k1));
	}
	
	@Test
	public void metoda_pretraziKnjige() {
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
		
		assertTrue("Za biblioteku sa knjigama: \"Legenda o Taboru\", \"Beleske jedne Ane\", \"Konte\", \"KO JE ALISA?\", metoda nije vratila listu sa knjigama \"Konte\" i \"KO JE ALISA?\"", pronadjeneKnjige.size() == 2 && pronadjeneKnjige.contains(k3) && pronadjeneKnjige.contains(k4));
	}
	
	@Test
	public void metoda_arhivirajKnjige() throws Exception {
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
		
		assertTrue("Za biblioteku sa knjigama sa godinama: \"2011\", \"2008\", \"2016\", \"2011\", metoda pozvana sa argumentom 2011 nije arhivirala knjige sa godinama \"2008\" i \"2011\"", knjige.size() == 1 && !knjige.contains(k1) && !knjige.contains(k2) && !knjige.contains(k4));
	}
}
