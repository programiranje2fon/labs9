package task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import task1.Book;
import test.TestUtil;

public class BookTest {

	private Book instance;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		instance = new Book();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut title", TestUtil.doesFieldExist(Book.class, "title"));
	}
	
	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut title nije privatan", TestUtil.hasFieldModifier(Book.class, "title", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_naziv_pocetnaVrednost() {
		String nazivValue = (String) TestUtil.getFieldValue(instance, "title");
		assertEquals("Pocetna vrednost atributa title nije prazan string", "", nazivValue);
	}
	
	@Test
	public void atribut_godina() {
		assertTrue("U klasi nije definisan atribut year", TestUtil.doesFieldExist(Book.class, "year"));
	}
	
	@Test
	public void atribut_godina_vidljivost() {
		assertTrue("Atribut year nije privatan", TestUtil.hasFieldModifier(Book.class, "year", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setNaziv() {
		instance.setTitle("Na Drini cuprija");
		String naziv = (String) TestUtil.getFieldValue(instance, "title");
		assertEquals("Nakon poziva metode setTitle(String) sa prosledjenim argumentom \"Na Drini cuprija\", vrednost atributa title nema tu vrednost", "Na Drini cuprija", naziv);
	}
	
	@Test
	public void metoda_setNaziv_null() {
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Title cannot be NULL");
	    
	    instance.setTitle(null);
	}
	
	@Test
	public void metoda_getNaziv() {
		String naziv = (String) TestUtil.getFieldValue(instance, "title");

		assertEquals("Metoda getTitle() ne vraca vrednost atributa title", naziv, instance.getTitle());
	}
	
	@Test
	public void metoda_setGodina() throws Exception {
		instance.setYear(2010);
		int godina = (int) TestUtil.getFieldValue(instance, "year");
		assertEquals("Nakon poziva metode setYear(int) sa prosledjenim argumentom \"2010\", vrednost atributa year nema tu vrednost", 2010, godina);
	}
	
	@Test
	public void metoda_setGodina_ispodOpsega() throws Exception {
		expectedEx.expect(Exception.class);
	    expectedEx.expectMessage("Year is not in the appropriate range");
	    
		instance.setYear(1900);
	}
	
	@Test
	public void metoda_setGodina_iznadOpsega() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage("Year is not in the appropriate range");
		
		GregorianCalendar sada = new GregorianCalendar();
		
		instance.setYear(sada.get(GregorianCalendar.YEAR + 1));
	}
	
	@Test
	public void metoda_getGodina() {
		int godina = (int) TestUtil.getFieldValue(instance, "year");

		assertEquals("Metoda getYear() ne vraca vrednost atributa year", godina, instance.getYear());
	}
	
}
