package location;

import location.map.Coordinate;
import location.map.MapFieldType;
import location.map.MapLocation;
import location.map.object.CompositeMapObject;
import location.map.object.CreatureMapObject;
import location.map.object.MapObject;
import location.map.object.PersonMapObject;
import location.map.object.TreasureMapObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MapLocationTest {

	private MapLocation mapLocation;

	private MapObject personMapObject;

	@Before
	public void setUp() {
		personMapObject = new PersonMapObject(new Coordinate(1, 1));

		MapObject creature1 = new CreatureMapObject(new Coordinate(3, 3));
		MapObject creature2 = new CreatureMapObject(new Coordinate(3, 1));

		CompositeMapObject creatures = new CompositeMapObject();
		creatures.addObject(creature1);
		creatures.addObject(creature2);

		MapObject treasure = new TreasureMapObject(new Coordinate(3, 2));

		CompositeMapObject treasures = new CompositeMapObject();
		treasures.addObject(treasure);

		CompositeMapObject allObjects = new CompositeMapObject();
		allObjects.addObject(personMapObject);
		allObjects.addObject(creatures);
		allObjects.addObject(treasure);

		mapLocation = new MapLocation(5, allObjects);
	}

	@Test
	public void testMapShouldExist() {
		assertNotNull(mapLocation.getMap());
	}

	@Test
	public void testMapWidthShouldBeConfigurable() {
		assertEquals(5, mapLocation.getMap().length);
	}

	@Test
	public void testMapHeightShouldBeConfigurable() {
		assertEquals(5, mapLocation.getMap()[0].length);
		assertEquals(5, mapLocation.getMap()[1].length);
		assertEquals(5, mapLocation.getMap()[2].length);
		assertEquals(5, mapLocation.getMap()[3].length);
		assertEquals(5, mapLocation.getMap()[4].length);
	}

	@Test
	public void testMapShouldBeSquare() {
		assertEquals(mapLocation.getMap()[0].length, mapLocation.getMap().length);
	}

	@Test
	public void testMapShouldBeFilled() {
		for (MapFieldType[] array : mapLocation.getMap()) {
			for (MapFieldType type : array) {
				assertNotNull(type);
			}
		}
	}

	@Test
	public void testMapShouldBePopulatedByOnePerson() {
		int count = 0;
		mapLocation.populate();
		for (MapFieldType[] array : mapLocation.getMap()) {
			for (MapFieldType type : array) {
				if (MapFieldType.PERSON.equals(type)) count++;
			}
		}
		assertEquals(1, count);
	}

	@Test
	public void testMapShouldBePopulatedByCreatures() {
		int count = 0;
		mapLocation.populate();
		for (MapFieldType[] array : mapLocation.getMap()) {
			for (MapFieldType type : array) {
				if (MapFieldType.CREATURE.equals(type)) count++;
			}
		}
		assertEquals(2, count);
	}

	@Test
	public void testMapShouldBePopulatedByTreasures() {
		int count = 0;
		mapLocation.populate();
		for (MapFieldType[] array : mapLocation.getMap()) {
			for (MapFieldType type : array) {
				if (MapFieldType.TREASURE.equals(type)) count++;
			}
		}
		assertEquals(1, count);
	}

	@Test
	public void testPersonShouldGo4Directions() {
		assertEquals(1, personMapObject.getCoordinate().getX());
		assertEquals(1, personMapObject.getCoordinate().getY());
		personMapObject.move(Direction.EAST, mapLocation);
		assertEquals(2, personMapObject.getCoordinate().getX());
		assertEquals(1, personMapObject.getCoordinate().getY());
		personMapObject.move(Direction.SOUTH, mapLocation);
		assertEquals(2, personMapObject.getCoordinate().getX());
		assertEquals(2, personMapObject.getCoordinate().getY());
		personMapObject.move(Direction.WEST, mapLocation);
		assertEquals(1, personMapObject.getCoordinate().getX());
		assertEquals(2, personMapObject.getCoordinate().getY());
		personMapObject.move(Direction.NORTH, mapLocation);
		assertEquals(1, personMapObject.getCoordinate().getX());
		assertEquals(1, personMapObject.getCoordinate().getY());
	}

	@Test
	public void testPersonShouldNotGoOutTheMap() {
		personMapObject.move(Direction.NORTH, mapLocation);
		assertEquals(1, personMapObject.getCoordinate().getX());
		assertEquals(1, personMapObject.getCoordinate().getY());
	}

	@Test
	public void testPreviousPlaceShouldBeEmpty() {
		mapLocation.populate();
		personMapObject.move(Direction.EAST, mapLocation);
		mapLocation.populate();
		assertEquals(MapFieldType.EMPTY, mapLocation.getMap()[1][1]);
	}
}
