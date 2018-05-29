package experience;

import character.Person;

/**
 * Service to manage experience.
 */
public interface ExperienceService {

	/**
	 * Processes experience received by {@link Person}. Sends character to new level when it is reached.
	 *
	 * @param person     received experience
	 * @param experience to process
	 */
	void processExperience(Person person, int experience);

}
