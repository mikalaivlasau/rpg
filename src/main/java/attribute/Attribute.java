package attribute;

/**
 * Attack and defense attributes belong to character.
 */
public interface Attribute {

	/**
	 * Calculate the value brought by attribute.
	 *
	 * @return calculated amount
	 */
	int calculate();
}
