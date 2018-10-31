package task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import task2.Restaurant;
import test.TestUtil;

public class RestaurantTest {

	private Restaurant instance;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		instance = new Restaurant();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut name", TestUtil.doesFieldExist(Restaurant.class, "name"));
	}

	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut name nije privatan", TestUtil.hasFieldModifier(Restaurant.class, "name", Modifier.PRIVATE));
	}

	@Test
	public void atribut_ocena() {
		assertTrue("U klasi nije definisan atribut rating", TestUtil.doesFieldExist(Restaurant.class, "rating"));
	}

	@Test
	public void atribut_ocena_vidljivost() {
		assertTrue("Atribut rating nije privatan", TestUtil.hasFieldModifier(Restaurant.class, "rating", Modifier.PRIVATE));
	}

	@Test
	public void metoda_setNaziv() {
		instance.setName("Madera");
		String nazivValue = (String) TestUtil.getFieldValue(instance, "name");
		assertEquals(
				"Nakon poziva metode setName(String) sa prosledjenim argumentom \"Madera\", vrednost atributa name nema tu vrednost",
				"Madera", nazivValue);
	}

	@Test
	public void metoda_setNaziv_null() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("ERROR");

		instance.setName(null);
	}

	@Test
	public void metoda_getNaziv() {
		instance.setName("Madera");
		String nazivValue = (String) TestUtil.getFieldValue(instance, "name");

		assertEquals("Metoda getName() ne vraca vrednost atributa name", nazivValue, instance.getName());
	}

	@Test
	public void metoda_setBroj_1() {
		instance.setRating(1);
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "rating");
		assertEquals(
				"Nakon poziva metode setRating(int) sa prosledjenim argumentom \"1\", vrednost atributa rating nema tu vrednost",
				1, ocenaValue);
	}

	@Test
	public void metoda_setBroj_3() {
		instance.setRating(3);
		int brojValue = (int) TestUtil.getFieldValue(instance, "rating");
		assertEquals(
				"Nakon poziva metode setRating(int) sa prosledjenim argumentom \"3\", vrednost atributa rating nema tu vrednost",
				3, brojValue);
	}

	@Test
	public void metoda_setBroj_5() {
		instance.setRating(5);
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "rating");
		assertEquals(
				"Nakon poziva metode setRating(int) sa prosledjenim argumentom \"5\", vrednost atributa rating nema tu vrednost",
				5, ocenaValue);
	}

	@Test
	public void metoda_setBroj_vanGranice() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("ERROR");

		instance.setRating(100);
	}

	@Test
	public void metoda_getOcena() {
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "rating");

		assertEquals("Metoda getRating() ne vraca vrednost atributa rating", ocenaValue, instance.getRating());
	}
}
