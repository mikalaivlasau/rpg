package location;

public class MapLocation implements Location {
    private MapFieldType[][] map;

    public MapLocation(int size) {
        map = new MapFieldType[size][size];
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
    public void draw() {
        for (MapFieldType[] array : map) {
            for (MapFieldType type : array) {
                System.out.print(type.getSign());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
