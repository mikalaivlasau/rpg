package menu.main;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;
import menu.explore.ExploreMenu;
import saving.DefaultSaveService;
import saving.SaveService;

public class LoadMenu extends MainMenu {
	private SaveService saveService = new DefaultSaveService();
	private PersonService personService = new DefaultPersonService();

	@Override
	public void processMenu() {
		showMenu();
		selectedOption = scanner.next();
		switch (selectedOption) {
			case "1":
				System.out.println("Enter name of saved game:");
				String filename = scanner.next();
				saveService.load(filename);
				ExploreMenu menu = new ExploreMenu();
				menu.processMenu();
				break;
			case "2":
				super.processMenu();
				break;
			default:
				processMenu();
				break;
		}

	}

	private void showMenu() {
		System.out.println("Load game menu");
		System.out.println(MENU_LINE_SEPARATOR);
		System.out.println("1. Load the game");
		System.out.println("2. Back to main menu");

	}
}
