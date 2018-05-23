package location.object;

import location.MapFieldType;

public class CreatureMapObject implements MapObject {
    private int x;
    private int y;

    public CreatureMapObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void map(MapFieldType[][] map) {
        map[x][y] = MapFieldType.CREATURE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
