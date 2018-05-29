package location.map.object;

import location.map.Coordinate;
import location.map.MapFieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern to store all map objects. Allows arrange the whole map with all map objects.
 */
public class CompositeMapObject extends MapObject {
	private List<MapObject> objects = new ArrayList<>();

	@Override
	public void arrange(MapFieldType[][] map) {
		for (MapObject object : objects) {
			object.arrange(map);
		}
	}

	public void addObject(MapObject location) {
		objects.add(location);
	}

	/**
	 * Gets the characters map object.
	 *
	 * @return person map object
	 */
	public PersonMapObject getPersonMapObject() {
		return (PersonMapObject) objects.stream()
				.filter(o -> o instanceof PersonMapObject)
				.findFirst()
				.orElse(null);
	}

	public void removeObject(MapObject location) {
		objects.remove(location);
	}

	/**
	 * Removes map object based on coordinate.
	 *
	 * @param coordinate of the map object
	 * @param composite  the composite map object
	 */
	public void removeObject(Coordinate coordinate, CompositeMapObject composite) {
		for (MapObject obj : composite.getObjects()) {
			if (obj instanceof CompositeMapObject) {
				removeObject(coordinate, (CompositeMapObject) obj);
			}
			if (!(obj instanceof PersonMapObject) && obj.getCoordinate().getX() == coordinate.getX() && obj
					.getCoordinate().getY() == coordinate.getY()) {
				composite.removeObject(obj);
				break;
			}
		}
	}

	/**
	 * Determines whether {@link PersonMapObject} is alone on the map.
	 *
	 * @return true if alone
	 */
	public boolean isEmpty() {
		boolean isEmpty = true;
		for (MapObject obj : objects) {
			if (obj instanceof CompositeMapObject) {
				if (!((CompositeMapObject) obj).getObjects().isEmpty()) {
					isEmpty = false;
					break;
				}
			}
		}
		return isEmpty;
	}

	public List<MapObject> getObjects() {
		return objects;
	}
}
