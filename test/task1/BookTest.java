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
	public void attribute_title() {
		assertTrue("There is no attribute \"title\" declared", TestUtil.doesFieldExist(Book.class, "title"));
	}
	
	@Test
	public void attribute_title_visibility() {
		assertTrue("Attribute \"title\" is not private", TestUtil.hasFieldModifier(Book.class, "title", Modifier.PRIVATE));
	}
	
	@Test
	public void attribute_title_defaultValue() {
		String nazivValue = (String) TestUtil.getFieldValue(instance, "title");
		assertEquals("The default value of the attribute \"title\" should be an empty String", "", nazivValue);
	}
	
	@Test
	public void attribute_year() {
		assertTrue("There is no attribute \"year\" declared", TestUtil.doesFieldExist(Book.class, "year"));
	}
	
	@Test
	public void attribute_year_visibility() {
		assertTrue("Attribute \"year\" is not private", TestUtil.hasFieldModifier(Book.class, "year", Modifier.PRIVATE));
	}
	
	@Test
	public void method_setTitle() {
		instance.setTitle("Na Drini cuprija");
		String naziv = (String) TestUtil.getFieldValue(instance, "title");
		assertEquals("After passing an argument \"Na Drini cuprija\", the attribute \"title\" does not have this value", "Na Drini cuprija", naziv);
	}
	
	@Test
	public void method_setTitle_null() {
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Title cannot be NULL");
	    
	    instance.setTitle(null);
	}
	
	@Test
	public void method_getTitle() {
		String naziv = (String) TestUtil.getFieldValue(instance, "title");

		assertEquals("The method does not return the value od the attribute \"title\"", naziv, instance.getTitle());
	}
	
	@Test
	public void method_setYear() throws Exception {
		instance.setYear(2010);
		int godina = (int) TestUtil.getFieldValue(instance, "year");
		assertEquals("When the method argument is \"2010\", the attribute \"year\" does not have this value", 2010, godina);
	}
	
	@Test
	public void method_setYear_bellowLimits() throws Exception {
		expectedEx.expect(Exception.class);
	    expectedEx.expectMessage("Year is not in the appropriate range");
	    
		instance.setYear(1900);
	}
	
	@Test
	public void method_setYear_aboveLimits() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage("Year is not in the appropriate range");
		
		GregorianCalendar sada = new GregorianCalendar();
		
		instance.setYear(sada.get(GregorianCalendar.YEAR + 1));
	}
	
	@Test
	public void method_getYear() {
		int godina = (int) TestUtil.getFieldValue(instance, "year");

		assertEquals("The method does not return the value od the attribute \"year\"", godina, instance.getYear());
	}
	
	@Test
	public void method_equals() throws Exception {
		instance.setTitle("Zapisi o Goji");
		instance.setYear(1961);
		
		Book k1 = new Book();
		k1.setTitle("Zapisi o Goji");
		k1.setYear(1961);
		
		assertEquals("When the argument is a book with the same title and year, the method should return true", k1, instance);
	}
	
}
