package location.map.service;

import character.Person;
import character.Skeleton;
import location.Location;
import location.map.Coordinate;
import location.map.MapLocation;
import location.map.object.CompositeMapObject;
import location.map.object.CreatureMapObject;
import location.map.object.MapObject;
import location.map.object.PersonMapObject;
import location.map.object.TreasureMapObject;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapLocationService implements LocationService {
	private static final Map<String, Person> STORAGE = new HashMap<>();
	private List<Coordinate> coordinateList = new ArrayList<>();

	@Override
	public Location generateLocation(int size) {
		MapObject personMapObject = new PersonMapObject(getUniqueRandomCoordinate(size));

		CreatureMapObject creature1 = new CreatureMapObject(getUniqueRandomCoordinate(size));
		Person creaturePerson1 = new Skeleton();
		creature1.setCreature(creaturePerson1);
		saveNewCreature(creature1);

		CreatureMapObject creature2 = new CreatureMapObject(getUniqueRandomCoordinate(size));
		Person creaturePerson2 = new Skeleton();
		creature2.setCreature(creaturePerson2);
		saveNewCreature(creature2);

		CompositeMapObject creatures = new CompositeMapObject();
		creatures.addObject(creature1);
		creatures.addObject(creature2);

		MapObject treasure = new TreasureMapObject(getUniqueRandomCoordinate(size));

		CompositeMapObject treasures = new CompositeMapObject();
		treasures.addObject(treasure);

		CompositeMapObject allObjects = new CompositeMapObject();
		allObjects.addObject(personMapObject);
		allObjects.addObject(creatures);
		allObjects.addObject(treasure);

		return new MapLocation(size, allObjects);
	}

	@Override
	public void saveNewCreature(CreatureMapObject creatureMapObject) {
		STORAGE.put(creatureMapObject.getCoordinate().toString(), creatureMapObject.getCreature());
	}

	@Override
	public Person getCreature(Coordinate coordinate) {
		return STORAGE.get(coordinate.toString());
	}

	private Coordinate getUniqueRandomCoordinate(int size) {
		Coordinate randomCoordinate = RandomUtil.getRandomCoordinate(size);
		if (coordinateList.contains(randomCoordinate)) {
			getUniqueRandomCoordinate(size);
		}
		coordinateList.add(randomCoordinate);
		return randomCoordinate;
	}
}
