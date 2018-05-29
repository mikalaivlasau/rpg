package menu.explore;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;
import menu.main.MainMenu;
import menu.service.DefaultDisplayService;
import menu.service.DisplayService;
import saving.DefaultSaveService;
import saving.SaveService;

public class EndLevelMenu extends ExploreMenu {
	private PersonService personService = new DefaultPersonService();
	private SaveService saveService = new DefaultSaveService();
	private DisplayService displayService = new DefaultDisplayService();

	@Override
	public void processMenu() {
		clearConsole();
		DisplayService.printEndLevelLogo();
		Person person = personService.getPerson();
		displayService.drawStats(person);

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
