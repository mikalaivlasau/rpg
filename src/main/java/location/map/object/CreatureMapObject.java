package location.map.object;

import character.Person;
import location.map.Coordinate;
import location.map.MapFieldType;

/**
 * Map object represents creature.
 */
public class CreatureMapObject extends MapObject {
	private Person creature;

	public CreatureMapObject(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public void arrange(MapFieldType[][] map) {
		map[coordinate.getY()][coordinate.getX()] = MapFieldType.CREATURE;
	}

	public Person getCreature() {
		return creature;
	}

	public void setCreature(Person creature) {
		this.creature = creature;
	}
}
