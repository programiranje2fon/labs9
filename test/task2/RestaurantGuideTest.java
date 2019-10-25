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
	public void attribute_restaurants() {
		assertTrue("There is no attribute \"restaurants\" declared", TestUtil.doesFieldExist(RestaurantGuide.class, "restaurants"));
	}
	
	@Test
	public void attribute_restaurants_visibility() {
		assertTrue("Attribute \"restaurants\" is not private", TestUtil.hasFieldModifier(RestaurantGuide.class, "restaurants", Modifier.PRIVATE));
	}
	
	@Test
	public void attribute_restaurants_typeArrayList() {
		List<?> restorani = (List<?>) TestUtil.getFieldValue(instance, "restaurants");
		
		assertTrue("Attribute \"restaurants\" is not an ArrayList", ArrayList.class.isInstance(restorani));
	}
	
	@Test
	public void method_addAsFirst() {
		Restaurant r1 = new Restaurant();
		instance.addAsFirst(r1);
		
		Restaurant r2 = new Restaurant();
		instance.addAsFirst(r2);
		
		ArrayList<?> restorani = (ArrayList<?>) TestUtil.getFieldValue(instance, "restaurants");
		
		assertTrue("When the method is called twice, the first restaurant added should be at the second position (index = 1) in the list \"restaurants\"", restorani.get(0).equals(r2));
		assertTrue("When the method is called twice, the second restaurant should be at the first position (index = 0) in the list \"restaurants\"", restorani.get(1).equals(r1));
	}
	
	@Test
	public void method_printsRestaurantsWithRating() {
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
		
		assertEquals("When the guide contains the following restaurants: \"Salon 5\" (rating 5), \"Casa Nova\" (rating 1), \"Ciribu Ciriba\" (rating 3), \"Radost\" (rating 5), for the method argument \"5\", the method should print:\n" + ocekivaniIspis, ispis, ocekivaniIspis);
	}
	
	@Test
	public void method_removeBadRestaurants() {
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
		
		assertFalse("When the guide contains the following restaurants: \"Salon 5\" (rating 5), \"Casa Nova\" (rating 1), \"Ciribu Ciriba\" (rating 3), \"Radost\" (rating 5), the method should return the restaurant \"Casa Nova\" (rating 1) from the list \"restaurants\"", restorani.contains(r2));
	}

}
