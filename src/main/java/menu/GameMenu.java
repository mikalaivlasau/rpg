package menu;

import java.util.Scanner;

public abstract class GameMenu {

	protected static final String MENU_LINE_SEPARATOR = "---------------------------";
	protected Scanner scanner = new Scanner(System.in);
	protected String selectedOption;

	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public abstract void processMenu();
}
