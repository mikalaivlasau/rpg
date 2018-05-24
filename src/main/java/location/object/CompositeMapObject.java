package location.object;

import location.MapFieldType;

import java.util.ArrayList;
import java.util.List;

public class CompositeMapObject extends MapObject {
    private List<MapObject> objects = new ArrayList<>();

    public void addObject(MapObject location) {
        objects.add(location);
    }

    public void removeObject(MapObject location) {
        objects.remove(location);
    }

    @Override
    public void map(MapFieldType[][] map) {
        for (MapObject object : objects) {
            object.map(map);
        }
    }
}
