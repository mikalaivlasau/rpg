package location;

import location.object.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class MapLocationTest {

    @InjectMocks
    private MapLocation mapLocation = new MapLocation(3);

    @Before
    public void setUp() throws Exception {
        MapObject person = new PersonMapObject(0, 0);

        MapObject creature1 = new CreatureMapObject(2, 2);
        MapObject creature2 = new CreatureMapObject(2, 0);

        CompositeMapObject creatures = new CompositeMapObject();
        creatures.addObject(creature1);
        creatures.addObject(creature2);

        MapObject treasure = new TreasureMapObject(2, 1);

        CompositeMapObject treasures = new CompositeMapObject();
        treasures.addObject(treasure);

        CompositeMapObject allObjects = new CompositeMapObject();
        allObjects.addObject(person);
        allObjects.addObject(creatures);
        allObjects.addObject(treasure);

        mapLocation.setCompositeMapObject(allObjects);
    }

    @Test
    public void testMapShouldExist() {
        assertNotNull(mapLocation.getMap());
    }

    @Test
    public void testMapWidthShouldBeConfigurable() {
        assertEquals(3, mapLocation.getMap().length);
    }

    @Test
    public void testMapHeightShouldBeConfigurable() {
        assertEquals(3, mapLocation.getMap()[0].length);
        assertEquals(3, mapLocation.getMap()[1].length);
        assertEquals(3, mapLocation.getMap()[2].length);
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
}
