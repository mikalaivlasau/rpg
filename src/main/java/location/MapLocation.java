package location;

import location.object.CompositeMapObject;

public class MapLocation implements Location {
    private MapFieldType[][] map;
    private CompositeMapObject mapObject;

    public MapLocation(int size, CompositeMapObject mapObject) {
        this.map = new MapFieldType[size][size];
        this.mapObject = mapObject;
        clearMap();
    }

    private void clearMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = MapFieldType.EMPTY;
            }
        }
    }

    public MapFieldType[][] getMap() {
        return map;
    }

    @Override
    public void populate() {
        clearMap();
        mapObject.map(map);
    }

    @Override
    public void draw() {
        for (MapFieldType[] array : map) {
            for (MapFieldType type : array) {
                System.out.print(type.getSign());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isCellBusy(int x, int y) {
        if (MapFieldType.EMPTY.equals(map[y][x])) {
            return false;
        } else {
            mapObject.removeObject(x, y, mapObject);
            return true;
        }
    }
}
