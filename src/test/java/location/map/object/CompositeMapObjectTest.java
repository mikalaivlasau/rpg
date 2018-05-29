package location.map.object;

import location.map.Coordinate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompositeMapObjectTest {

	private CompositeMapObject compositeMapObject = new CompositeMapObject();
	private MapObject personMapObject;

	@Before
	public void setUp() {
		personMapObject = new PersonMapObject(new Coordinate(1, 1));

		CreatureMapObject creature1 = new CreatureMapObject(new Coordinate(2, 2));
		CreatureMapObject creature2 = new CreatureMapObject(new Coordinate(3, 3));

		CompositeMapObject creatures = new CompositeMapObject();
		creatures.addObject(creature1);
		creatures.addObject(creature2);

		MapObject treasure = new TreasureMapObject(new Coordinate(4, 4));

		CompositeMapObject treasures = new CompositeMapObject();
		treasures.addObject(treasure);

		compositeMapObject.addObject(personMapObject);
		compositeMapObject.addObject(creatures);
		compositeMapObject.addObject(treasures);
	}

	@Test
	public void testGetPersonMapObject() {
		assertEquals(personMapObject, compositeMapObject.getPersonMapObject());
	}

	@Test
	public void testRemoveObject() {
		compositeMapObject.removeObject(new Coordinate(2, 2), compositeMapObject);
		int creatureSize = ((CompositeMapObject) compositeMapObject.getObjects().get(1)).getObjects().size();
		assertEquals(1, creatureSize);
	}

	@Test
	public void testRemoveObjectExceptPerson() {
		compositeMapObject.removeObject(new Coordinate(1, 1), compositeMapObject);
		assertEquals(personMapObject, compositeMapObject.getPersonMapObject());
	}

	@Test
	public void testNotEmpty() {
		assertFalse(compositeMapObject.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		compositeMapObject.removeObject(new Coordinate(2, 2), compositeMapObject);
		compositeMapObject.removeObject(new Coordinate(3, 3), compositeMapObject);
		compositeMapObject.removeObject(new Coordinate(4, 4), compositeMapObject);
		assertTrue(compositeMapObject.isEmpty());
	}
}