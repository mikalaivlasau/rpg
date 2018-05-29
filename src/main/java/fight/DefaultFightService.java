package fight;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;
import experience.DefaultExperienceService;
import experience.ExperienceService;
import location.map.Coordinate;
import location.map.service.LocationService;
import location.map.service.MapLocationService;
import menu.service.DefaultDisplayService;
import menu.service.DisplayService;
import util.RandomUtil;

/**
 * Default implementation of {@link FightService}.
 */
public class DefaultFightService implements FightService {
	private PersonService personService = new DefaultPersonService();
	private LocationService locationService = new MapLocationService();
	private ExperienceService experienceService = new DefaultExperienceService();
	private DisplayService displayService = new DefaultDisplayService();
	private boolean isPersonWin;

	@Override
	public boolean fight(Coordinate coordinate) {
		Person person = personService.getPerson();
		Person creature = locationService.getPersonByCoordinate(coordinate);
		processFight(person, creature);
		return isPersonWin;
	}

	/**
	 * Processes fight till someone is dead. Redraws fight stats, HP and logs after each step. If character wins,
	 * gives him experience.
	 *
	 * @param person   the character
	 * @param creature the enemy
	 */
	private void processFight(Person person, Person creature) {
		displayService.drawFightStatsAndLogs(person, creature);
		do {
			attack(person, creature);
			displayService.drawFightStatsAndLogs(person, creature);
			if (creature.isAlive()) {
				attack(creature, person);
				displayService.drawFightStatsAndLogs(person, creature);
			}
		} while (person.isAlive() && creature.isAlive());

		if (person.isAlive()) {
			System.out.println(person.getName() + " survived!");
			experienceService.processExperience(person, creature.getExperience());
			isPersonWin = true;
		} else if (creature.isAlive()) {
			System.out.println(person.getName() + " is dead!");
			isPersonWin = false;
		}
	}

	/**
	 * Makes an attack. Calculates damage based on attack and defense with a bit of random.
	 *
	 * @param attacker attacks
	 * @param defender defends
	 */
	private void attack(Person attacker, Person defender) {
		if (isAttackSuccessful(attacker.getAgility(), defender.getAgility())) {
			int sum = attacker.getAttack() + defender.getDefense();
			int randomValue = RandomUtil.getRandomValueInRange(1, sum);
			int damage = Math.max(0, randomValue - defender.getDefense());
			int remainingHealth = Math.max(0, defender.getHealth() - damage);
			defender.setHealth(remainingHealth);
			displayService.addFightLog(attacker.getName() + "'s attack does " + damage + " damage!");
		} else {
			displayService.addFightLog("Wow! " + attacker.getName() + " missed");
		}


	}

	/**
	 * Checks if attacker missed or hit based on agility with a bit of random.
	 *
	 * @param attackerAgility agility of attacker
	 * @param defenderAgility agility of defender
	 * @return is attack successful
	 */
	private boolean isAttackSuccessful(int attackerAgility, int defenderAgility) {
		int agilitySum = attackerAgility + defenderAgility;
		int randomValue = RandomUtil.getRandomValueInRange(1, agilitySum);
		return randomValue > defenderAgility;
	}
}
