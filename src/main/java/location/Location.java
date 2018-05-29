package location;

import location.map.Coordinate;
import location.map.MapFieldType;

/**
 * The location.
 */
public interface Location {

	/**
	 * Populates with objects.
	 */
	void populate();

	/**
	 * Displays on the screen.
	 */
	void draw();

	/**
	 * Checks the field.
	 *
	 * @param coordinate of the field
	 * @return field type of the field
	 */
	MapFieldType checkField(Coordinate coordinate);
}
