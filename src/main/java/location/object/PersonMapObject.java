package location.object;

import location.MapFieldType;

public class PersonMapObject extends MapObject{
    public PersonMapObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void map(MapFieldType[][] map) {
        map[y][x] = MapFieldType.PERSON;
    }
}
