package location.object;

import location.MapFieldType;

public class TreasureMapObject extends MapObject {
    public TreasureMapObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void map(MapFieldType[][] map) {
        map[y][x] = MapFieldType.TREASURE;
    }
}
