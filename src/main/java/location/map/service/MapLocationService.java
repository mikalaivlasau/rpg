package location.map.service;

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
import java.util.List;


public class MapLocationService implements LocationService {
	private List<Coordinate> coordinateList = new ArrayList<>();

	@Override
	public Location generateLocation(int size) {
		MapObject personMapObject = new PersonMapObject(getUniqueRandomCoordinate(size));

		MapObject creature1 = new CreatureMapObject(getUniqueRandomCoordinate(size));
		MapObject creature2 = new CreatureMapObject(getUniqueRandomCoordinate(size));

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

	private Coordinate getUniqueRandomCoordinate(int size) {
		Coordinate randomCoordinate = RandomUtil.getRandomCoordinate(size);
		if (coordinateList.contains(randomCoordinate)) {
			getUniqueRandomCoordinate(size);
		}
		coordinateList.add(randomCoordinate);
		return randomCoordinate;
	}
}
