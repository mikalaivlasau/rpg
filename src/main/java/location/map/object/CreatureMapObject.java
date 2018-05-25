package location.map.object;

import location.map.Coordinate;
import location.map.MapFieldType;

public class CreatureMapObject extends MapObject {
	public CreatureMapObject(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public void arrange(MapFieldType[][] map) {
		map[coordinate.getY()][coordinate.getX()] = MapFieldType.CREATURE;
	}
}
