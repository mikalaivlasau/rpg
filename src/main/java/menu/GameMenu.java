package menu;

import java.util.Scanner;

/**
 * Abstract game menu.
 */
public abstract class GameMenu {

	protected static final String MENU_LINE_SEPARATOR = "---------------------------";
	protected Scanner scanner = new Scanner(System.in);
	protected String selectedOption;

	/**
	 * Clears console.
	 */
	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	/**
	 * Processes menu.
	 */
	public abstract void processMenu();
}
