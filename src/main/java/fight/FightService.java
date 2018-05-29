package fight;

import location.map.Coordinate;

/**
 * Service for managing fights between character and mobs.
 */
public interface FightService {

	/**
	 * Processes fight.
	 *
	 * @param coordinate of battle
	 * @return true if character has won
	 */
	boolean fight(Coordinate coordinate);

}
