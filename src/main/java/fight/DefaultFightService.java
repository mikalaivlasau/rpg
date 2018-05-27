package fight;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;
import experience.DefaultExperienceService;
import experience.ExperienceService;
import location.map.Coordinate;
import location.map.service.LocationService;
import location.map.service.MapLocationService;
import menu.GameMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefaultFightService implements FightService {
	private PersonService personService = new DefaultPersonService();
	private LocationService locationService = new MapLocationService();
	private ExperienceService experienceService = new DefaultExperienceService();
	private List<String> fightLogs = new ArrayList<>();
	private boolean isPersonWin;

	@Override
	public boolean fight(Coordinate coordinate) {
		Person person = personService.getPerson();
		Person creature = locationService.getCreature(coordinate);
		processFight(person, creature);
		return isPersonWin;
	}

	private void drawFightStatsAndLogs(Person person, Person creature) {
		GameMenu.clearConsole();

		String nameFormat = "| %-22s || %22s |%n";

		String statsFormat = "| %-15s | %-4d || %4d | %15s |%n";

		System.out.format("+------------------------++------------------------+%n");
		System.out.format(nameFormat, person.getName(), creature.getName());
		System.out.format("+-----------------+------++------+-----------------+%n");

		System.out.format(statsFormat, "HP", person.getHealth(), creature.getHealth(), "HP");

		System.out.format(statsFormat, "Strength", person.getStrength(), creature.getStrength(), "Strength");
		System.out.format(statsFormat, "Agility", person.getAgility(), creature.getAgility(), "Agility");
		System.out.format(statsFormat, "Stamina", person.getStamina(), creature.getStamina(), "Stamina");
		System.out.format("+-----------------+------++------+-----------------+%n");
		System.out.format(statsFormat, "Attack", person.getAttack(), creature.getAttack(), "Attack");
		System.out.format(statsFormat, "Defense", person.getDefense(), creature.getDefense(), "Defense");
		System.out.format("+-----------------+------++------+-----------------+%n%n");

		System.out.println(creature.getName() + ": Die human!");

		fightLogs.forEach(System.out::println);

		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void processFight(Person person, Person creature) {
		drawFightStatsAndLogs(person, creature);
		do {
			attack(person, creature);
			drawFightStatsAndLogs(person, creature);
			if (creature.isAlive()) {
				attack(creature, person);
				drawFightStatsAndLogs(person, creature);
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

	private void attack(Person attacker, Person defender) {
		int damage = Math.max(0, attacker.getAttack() - defender.getDefense());
		int health = Math.max(0, defender.getHealth() - damage);
		defender.setHealth(health);

		fightLogs.add(attacker.getName() + "'s attack does " + damage + " damage!");
	}
}
