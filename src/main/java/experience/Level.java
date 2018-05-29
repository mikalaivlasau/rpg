package experience;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration indicating character's level.
 */
public enum Level {
	ONE(1, 0),
	TWO(2, 100),
	THREE(3, 250),
	FOUR(4, 450),
	FIVE(5, 700),
	SIX(6, 1000),
	SEVEN(7, 1350),
	EIGHT(8, 1750),
	NINE(9, 2200),
	TEN(10, 2700);

	private static final Map<Integer, Level> LEVEL_MAP = new HashMap<>();

	static {
		for (Level level : values()) {
			LEVEL_MAP.put(level.getLevelNumber(), level);
		}
	}

	private int levelNumber;
	private int exp;

	Level(int levelNumber, int exp) {
		this.levelNumber = levelNumber;
		this.exp = exp;
	}

	public static Level getByLevelNumber(int levelNumber) {
		return LEVEL_MAP.get(levelNumber);
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public int getExp() {
		return exp;
	}

}
