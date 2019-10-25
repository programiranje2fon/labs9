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
	public void attribute_name() {
		assertTrue("There is no attribute \"name\" declared", TestUtil.doesFieldExist(Restaurant.class, "name"));
	}

	@Test
	public void attribute_name_visibility() {
		assertTrue("Attribute \"name\" is not private", TestUtil.hasFieldModifier(Restaurant.class, "name", Modifier.PRIVATE));
	}

	@Test
	public void attribute_rating() {
		assertTrue("There is no attribute \"rating\" declared", TestUtil.doesFieldExist(Restaurant.class, "rating"));
	}

	@Test
	public void attribute_rating_visibility() {
		assertTrue("Attribute \"rating\" is not private", TestUtil.hasFieldModifier(Restaurant.class, "rating", Modifier.PRIVATE));
	}

	@Test
	public void method_setName() {
		instance.setName("Madera");
		String nazivValue = (String) TestUtil.getFieldValue(instance, "name");
		assertEquals(
				"For the method argument \"Madera\", the attribute \"name\" should have this value",
				"Madera", nazivValue);
	}

	@Test
	public void method_setName_null() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("ERROR");

		instance.setName(null);
	}

	@Test
	public void method_getName() {
		instance.setName("Madera");
		String nazivValue = (String) TestUtil.getFieldValue(instance, "name");

		assertEquals("The method does not return the value of the attribute \"name\"", nazivValue, instance.getName());
	}

	@Test
	public void method_setRating_1() {
		instance.setRating(1);
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "rating");
		assertEquals(
				"For the method argument \"1\", the attribute \"rating\" should have this value",
				1, ocenaValue);
	}

	@Test
	public void method_setRating_3() {
		instance.setRating(3);
		int brojValue = (int) TestUtil.getFieldValue(instance, "rating");
		assertEquals(
				"For the method argument \"3\", the attribute \"rating\" should have this value",
				3, brojValue);
	}

	@Test
	public void method_setRating_5() {
		instance.setRating(5);
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "rating");
		assertEquals(
				"For the method argument  \"5\", the attribute \"rating\" should have this value",
				5, ocenaValue);
	}

	@Test
	public void method_setRating_aboveTheLimits() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("ERROR");

		instance.setRating(100);
	}

	@Test
	public void method_getRating() {
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "rating");

		assertEquals("The method does not return the value of the attribute \"rating\"", ocenaValue, instance.getRating());
	}
}
