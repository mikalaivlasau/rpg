package menu.service;

import character.Person;
import location.map.MapFieldType;
import menu.GameMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Default implementation of {@link DisplayService}.
 */
public class DefaultDisplayService implements DisplayService {
	private static final int FIGHT_LOG_DELAY = 1500;
	private List<String> fightLogs = new ArrayList<>();

	@Override
	public void drawFightStatsAndLogs(Person person, Person creature) {
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
			TimeUnit.MILLISECONDS.sleep(FIGHT_LOG_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addFightLog(String log) {
		fightLogs.add(log);
	}

	@Override
	public void drawStats(Person person) {
		System.out.println("Well done! Level has been completed!");
		System.out.println(GameMenu.MENU_LINE_SEPARATOR);
		String nameFormat = "| %-22s |%n";
		String statsFormat = "| %-15s | %-4d |%n";
		System.out.format("+------------------------+%n");
		System.out.format(nameFormat, person.getName() + " level " + person.getLevel().getLevelNumber());
		System.out.format("+-----------------+------+%n");
		System.out.format(statsFormat, "HP", person.getHealth());
		System.out.format(statsFormat, "Strength", person.getStrength());
		System.out.format(statsFormat, "Agility", person.getAgility());
		System.out.format(statsFormat, "Stamina", person.getStamina());
		System.out.format("+-----------------+------+%n");
		System.out.format(statsFormat, "Attack", person.getAttack());
		System.out.format(statsFormat, "Defense", person.getDefense());
		System.out.format("+-----------------+------+%n%n");
	}

	@Override
	public void drawMapLegend() {
		System.out.println(GameMenu.MENU_LINE_SEPARATOR);
		System.out.println("Controls: w, a, s, d.");
		String legendFormat = "Legend: %s - you, %s - wall, %s - creature, %s - treasure.%n";
		System.out.format(legendFormat, MapFieldType.PERSON.getSign(), MapFieldType.WALL.getSign(),
				MapFieldType.CREATURE.getSign(), MapFieldType.TREASURE.getSign());
		System.out.println(GameMenu.MENU_LINE_SEPARATOR);
	}
}
