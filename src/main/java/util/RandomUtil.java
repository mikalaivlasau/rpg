package util;

import location.map.Coordinate;

import java.util.Random;

public class RandomUtil {

	public static int getRandomValueInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	public static Coordinate getRandomCoordinate(int size) {
		return new Coordinate(getRandomValueInRange(1, size - 1), getRandomValueInRange(1, size - 1));
	}
}