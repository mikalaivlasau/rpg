package location.map.object;

import location.map.Coordinate;
import location.map.MapFieldType;

/**
 * Map object represents character.
 */
public class PersonMapObject extends MapObject {
	public PersonMapObject(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public void arrange(MapFieldType[][] map) {
		map[coordinate.getY()][coordinate.getX()] = MapFieldType.PERSON;
	}
}
