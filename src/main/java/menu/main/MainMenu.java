package menu.main;

import menu.GameMenu;
import menu.service.DisplayService;

public class MainMenu extends GameMenu {

	@Override
	public void processMenu() {
		GameMenu.clearConsole();
		DisplayService.printMainLogo();
		showMenu();
		selectedOption = scanner.next();
		switch (selectedOption) {
			case "1":
				clearConsole();
				StartMenu startMenu = new StartMenu();
				startMenu.processMenu();
				break;
			case "2":
				clearConsole();
				LoadMenu loadMenu = new LoadMenu();
				loadMenu.processMenu();
				break;
			case "3":
				clearConsole();
				exitGame();
				break;
			default:
				clearConsole();
				processMenu();
				break;
		}
	}

	private void showMenu() {
		System.out.println("Main menu");
		System.out.println(MENU_LINE_SEPARATOR);
		System.out.println("1. Start new game");
		System.out.println("2. Load game");
		System.out.println("3. Exit");
		System.out.println(MENU_LINE_SEPARATOR);
		System.out.println();
		System.out.print("Please select an option from 1-3: ");
		System.out.println();
	}

	private void exitGame() {
		System.out.println("Good bye!");
		System.exit(1);
	}
}
