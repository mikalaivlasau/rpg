package menu.explore;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;
import menu.main.MainMenu;
import saving.DefaultSaveService;
import saving.SaveService;

public class EndLevelMenu extends ExploreMenu {
	private PersonService personService = new DefaultPersonService();
	private SaveService saveService = new DefaultSaveService();

	@Override
	public void processMenu() {
		clearConsole();
		Person person = personService.getPerson();

		System.out.println("Level has been completed!");
		System.out.println(MENU_LINE_SEPARATOR);
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

		System.out.println();
		System.out.println("1 - Next level");
		System.out.println("2 - Save game");
		System.out.println("3 - Go to Main menu");
		System.out.println(MENU_LINE_SEPARATOR);
		selectedOption = scanner.next();
		switch (selectedOption) {
			case "1":
				super.processMenu();
				break;
			case "2":
				System.out.println("Enter name of saving slot:");
				String filename = scanner.next();
				saveService.save(person, filename);
				processMenu();
				break;
			case "3":
				MainMenu mainMenu = new MainMenu();
				mainMenu.processMenu();
				break;
			default:
				processMenu();
				break;
		}

	}
}
