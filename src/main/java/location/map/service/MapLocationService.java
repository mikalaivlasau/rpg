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
		saveNewMapObject(creature1.getCoordinate(), creaturePerson1);

		CreatureMapObject creature2 = new CreatureMapObject(getUniqueRandomCoordinate(size));
		Person creaturePerson2 = new Skeleton();
		saveNewMapObject(creature2.getCoordinate(), creaturePerson2);

		CompositeMapObject creatures = new CompositeMapObject();
		creatures.addObject(creature1);
		creatures.addObject(creature2);

		MapObject treasure = new TreasureMapObject(getUniqueRandomCoordinate(size));

		CompositeMapObject treasures = new CompositeMapObject();
		treasures.addObject(treasure);

		CompositeMapObject allObjects = new CompositeMapObject();
		allObjects.addObject(personMapObject);
		allObjects.addObject(creatures);
		allObjects.addObject(treasures);

		return new MapLocation(size, allObjects);
	}

	@Override
	public void saveNewMapObject(Coordinate coordinate, Person person) {
		STORAGE.put(coordinate.toString(), person);
	}

	@Override
	public Person getPersonByCoordinate(Coordinate coordinate) {
		return STORAGE.get(coordinate.toString());
	}

	public void removePersonByCoordinate(Coordinate coordinate) {
		STORAGE.remove(coordinate.toString());
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
