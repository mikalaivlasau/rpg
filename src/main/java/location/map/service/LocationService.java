package location.map.service;

import character.Person;
import location.Location;
import location.map.Coordinate;
import location.map.object.CreatureMapObject;

public interface LocationService {
	Location generateLocation(int size);

	void saveNewCreature(CreatureMapObject creatureMapObject);

	Person getCreature(Coordinate coordinate);
}
