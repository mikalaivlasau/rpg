package menu.service;

import character.Person;

/**
 * Service to display text information on console.
 */
public interface DisplayService {

	/**
	 * Draw stats table of the character and creature. Displays logs of the fight.
	 *
	 * @param person   the character
	 * @param creature the enemy
	 */
	void drawFightStatsAndLogs(Person person, Person creature);

	/**
	 * Adds fight log.
	 *
	 * @param log to add
	 */
	void addFightLog(String log);
}
