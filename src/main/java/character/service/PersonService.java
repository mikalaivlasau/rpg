package character.service;

import character.Person;

/**
 * Service for managing {@link Person}.
 */
public interface PersonService {

	/**
	 * Save's just created character.
	 *
	 * @param person to save
	 * @return saved person
	 */
	Person saveNewCharacter(Person person);

	/**
	 * Retrieves existing character.
	 *
	 * @return person
	 */
	Person getPerson();

	/**
	 * Removes {@link Person}.
	 */
	void removePerson();
}
