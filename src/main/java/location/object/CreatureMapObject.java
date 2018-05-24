package location.object;

import location.MapFieldType;

public class CreatureMapObject extends MapObject {
    public CreatureMapObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void map(MapFieldType[][] map) {
        map[y][x] = MapFieldType.CREATURE;
    }
}
