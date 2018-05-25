package location.map;

import location.Location;
import location.map.object.CompositeMapObject;

import java.util.Arrays;

public class MapLocation implements Location {
	private MapFieldType[][] map;
	private CompositeMapObject mapObject;

	public MapLocation(int size, CompositeMapObject mapObject) {
		this.map = new MapFieldType[size][size];
		this.mapObject = mapObject;
		cleanMap();
	}

	@Override
	public void populate() {
		cleanMap();
		mapObject.arrange(map);
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
	public MapFieldType checkField(int x, int y) {
		return map[y][x];
	}

	private void cleanMap() {
		for (MapFieldType[] array : map) {
			Arrays.fill(array, MapFieldType.WALL);
		}
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				map[i][j] = MapFieldType.EMPTY;
			}
		}
	}

	public MapFieldType[][] getMap() {
		return map;
	}

	public CompositeMapObject getMapObject() {
		return mapObject;
	}
}
