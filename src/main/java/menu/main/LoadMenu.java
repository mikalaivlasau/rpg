package menu.main;

import menu.explore.ExploreMenu;
import saving.DefaultSaveService;
import saving.SaveService;

import java.io.IOException;

public class LoadMenu extends MainMenu {
	private SaveService saveService = new DefaultSaveService();

	@Override
	public void processMenu() {
		showMenu();
		selectedOption = scanner.next();
		switch (selectedOption) {
			case "1":
				clearConsole();
				System.out.println("Available slots:");
				saveService.listFilesForFolder();
				System.out.println(MENU_LINE_SEPARATOR);
				System.out.println("Enter name of available slot:");
				String filename = scanner.next();
				try {
					saveService.load(filename);
				} catch (IOException e) {
					clearConsole();
					System.out.println("Something went wrong. Please retry.");
					processMenu();
				}
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
