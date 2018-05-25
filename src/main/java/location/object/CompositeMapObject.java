package location.object;

import location.MapFieldType;

import java.util.ArrayList;
import java.util.List;

public class CompositeMapObject extends MapObject {
    private List<MapObject> objects = new ArrayList<>();

    public void addObject(MapObject location) {
        objects.add(location);
    }

    public List<MapObject> getObjects() {
        return objects;
    }

    public void removeObject(MapObject location) {
        objects.remove(location);
    }

    public void removeObject(int x, int y, CompositeMapObject composite) {
        for (MapObject obj : composite.getObjects()) {
            if (!(obj instanceof PersonMapObject) && obj.getX() == x && obj.getY() == y) {
                composite.removeObject(obj);
                break;
            }
            if (obj instanceof CompositeMapObject) {
                removeObject(x, y, (CompositeMapObject) obj);
            }
        }
    }

    @Override
    public void map(MapFieldType[][] map) {
        for (MapObject object : objects) {
            object.map(map);
        }
    }
}
