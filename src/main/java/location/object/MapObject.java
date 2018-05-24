package location.object;

import location.MapFieldType;

public abstract class MapObject implements Movable {
    int x;
    int y;

    public abstract void map(MapFieldType[][] map);

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

    public void goNorth() {
        if (y > 0) y--;
    }

    public void goSouth(int size) {
        if (y < size) y++;
    }

    public void goEast(int size) {
        if (x < size) x++;
    }

    public void goWest() {
        if (x > 0) x--;
    }
}
