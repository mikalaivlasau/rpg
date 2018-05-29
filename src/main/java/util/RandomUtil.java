package util;

import location.map.Coordinate;

import java.util.Random;

/**
 * Util class for generating random values.
 */
public class RandomUtil {

	/**
	 * Generates random value for provided range.
	 *
	 * @param min range value
	 * @param max range value
	 * @return random value
	 */
	public static int getRandomValueInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	/**
	 * Generates random {@link Coordinate} based on map size.
	 *
	 * @param size of the map
	 * @return random coordinate
	 */
	public static Coordinate getRandomCoordinate(int size) {
		return new Coordinate(getRandomValueInRange(1, size - 2), getRandomValueInRange(1, size - 2));
	}
}