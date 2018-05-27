package location.map.service;

import character.Person;
import location.Location;
import location.map.Coordinate;

public interface LocationService {
	Location generateLocation(int size);

	void saveNewMapObject(Coordinate coordinate, Person person);

	Person getPersonByCoordinate(Coordinate coordinate);

	void removePersonByCoordinate(Coordinate coordinate);
}
