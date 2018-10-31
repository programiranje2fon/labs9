package task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import task2.Restaurant;
import task2.RestaurantGuide;
import test.TestUtil;

public class RestaurantGuideTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	private RestaurantGuide instance;

	@Before
	public void setUp() throws Exception {
		instance = new RestaurantGuide();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void atribut_restorani() {
		assertTrue("U klasi nije definisan atribut restaurants", TestUtil.doesFieldExist(RestaurantGuide.class, "restaurants"));
	}
	
	@Test
	public void atribut_restorani_vidljivost() {
		assertTrue("Atribut restaurants nije privatan", TestUtil.hasFieldModifier(RestaurantGuide.class, "restaurants", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_restorani_tipArrayList() {
		List<?> restorani = (List<?>) TestUtil.getFieldValue(instance, "restaurants");
		
		assertTrue("Atribut restaurants nije tipa ArrayList", ArrayList.class.isInstance(restorani));
	}
	
	@Test
	public void metoda_dodajNaPocetak() {
		Restaurant r1 = new Restaurant();
		instance.addAsFirst(r1);
		
		Restaurant r2 = new Restaurant();
		instance.addAsFirst(r2);
		
		ArrayList<?> restorani = (ArrayList<?>) TestUtil.getFieldValue(instance, "restaurants");
		
		assertTrue("Nakon dodavanja dva restorana u vodic, prvi restoran nije na drugom mestu u nizu restorani", restorani.get(0).equals(r2));
		assertTrue("Nakon dodavanja dva restorana u vodic, drugi restoran nije na prvom mestu u nizu restorani", restorani.get(1).equals(r1));
	}
	
	@Test
	public void metoda_ispisiRestoraneSaOcenom() {
		Restaurant r1 = new Restaurant();
		r1.setName("Salon 5");
		r1.setRating(5);
		instance.addAsFirst(r1);
		
		Restaurant r2 = new Restaurant();
		r2.setName("Casa Nova");
		r2.setRating(1);
		instance.addAsFirst(r2);
		
		Restaurant r3 = new Restaurant();
		r3.setName("Ciribu Ciriba");
		r3.setRating(3);
		instance.addAsFirst(r3);
		
		Restaurant r4 = new Restaurant();
		r4.setName("Radost");
		r4.setRating(5);
		instance.addAsFirst(r4);
		
		instance.printsRestaurantsWithRating(5);
		
		String ispis = outContent.toString();
		String ocekivaniIspis = "Radost" + System.lineSeparator() + "Salon 5" + System.lineSeparator();
		
		assertEquals("Za restorane u vodicu: \"Salon 5\" (ocena 5), \"Casa Nova\" (ocena 1), \"Ciribu Ciriba\" (ocena 3), \"Radost\" (ocena 5), ispisiRestoraneSaOcenom() sa prosledjenim parametrom \"5\" nije ispisao:\n" + ocekivaniIspis, ispis, ocekivaniIspis);
	}
	
	@Test
	public void metoda_obrisiLoseRestorane() {
		Restaurant r1 = new Restaurant();
		r1.setName("Salon 5");
		r1.setRating(5);
		instance.addAsFirst(r1);
		
		Restaurant r2 = new Restaurant();
		r2.setName("Casa Nova");
		r2.setRating(1);
		instance.addAsFirst(r2);
		
		Restaurant r3 = new Restaurant();
		r3.setName("Ciribu Ciriba");
		r3.setRating(3);
		instance.addAsFirst(r3);
		
		Restaurant r4 = new Restaurant();
		r4.setName("Radost");
		r4.setRating(5);
		instance.addAsFirst(r4);
		
		instance.removeBadRestaurants();
		
		ArrayList<?> restorani = (ArrayList<?>) TestUtil.getFieldValue(instance, "restaurants");
		
		assertFalse("Za restorane u vodicu: \"Salon 5\" (ocena 5), \"Casa Nova\" (ocena 1), \"Ciribu Ciriba\" (ocena 3), \"Radost\" (ocena 5), obrisiLoseRestorane() nije uklonila restoran \"Casa Nova\" (ocena 1) iz liste restorani", restorani.contains(r2));
	}
	
	
}
