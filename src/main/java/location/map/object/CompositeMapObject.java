package location.map.object;

import location.map.Coordinate;
import location.map.MapFieldType;

import java.util.ArrayList;
import java.util.List;

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

	public PersonMapObject getPersonMapObject() {
		return (PersonMapObject) objects.stream()
				.filter(o -> o instanceof PersonMapObject)
				.findFirst()
				.orElse(null);
	}

	public void removeObject(MapObject location) {
		objects.remove(location);
	}

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
