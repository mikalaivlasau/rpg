package location.map.object;

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

	public void removeObject(int x, int y, CompositeMapObject composite) {
		for (MapObject obj : composite.getObjects()) {
			if (!(obj instanceof PersonMapObject)
					&& obj.getCoordinate().getX() == x && obj.getCoordinate().getY() == y) {
				composite.removeObject(obj);
				break;
			}
			if (obj instanceof CompositeMapObject) {
				removeObject(x, y, (CompositeMapObject) obj);
			}
		}
	}

	public List<MapObject> getObjects() {
		return objects;
	}
}
