package location.map;

/**
 * Enumeration of field types and their drawable signs.
 */
public enum MapFieldType {
	EMPTY("."),
	PERSON("X"),
	CREATURE("@"),
	TREASURE("~"),
	WALL("+");

	private final String sign;

	MapFieldType(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}
}
