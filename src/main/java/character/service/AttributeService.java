package character.service;

import character.Person;

/**
 * Service for managing attributes.
 */
public interface AttributeService {

	/**
	 * Calculates final amount of person attributes and set it to the person.
	 *
	 * @param person with attributes
	 */
	void calculate(Person person);
}
