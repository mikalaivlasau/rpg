package location.map.service;

import character.Person;
import location.Location;
import location.map.Coordinate;

/**
 * Service to manage location.
 */
public interface LocationService {
	/**
	 * Generates random location.
	 *
	 * @param size of the location
	 * @return generated location
	 */
	Location generateLocation(int size);

	/**
	 * Saves new map object.
	 *
	 * @param coordinate of object
	 * @param person     to save
	 */
	void saveNewMapObject(Coordinate coordinate, Person person);

	/**
	 * Retrieves {@link Person} by {@link Coordinate}.
	 *
	 * @param coordinate to retrieve
	 * @return person
	 */
	Person getPersonByCoordinate(Coordinate coordinate);

	/**
	 * Removes {@link Person} by {@link Coordinate}.
	 *
	 * @param coordinate to remove
	 */
	void removePersonByCoordinate(Coordinate coordinate);
}
