import menu.GameMenu;
import menu.main.MainMenu;

import java.io.IOException;

public class LetThePartyBegin {

	public static void main(String[] args) throws IOException {

		MainMenu mainMenu = new MainMenu();
		GameMenu.clearConsole();
		mainMenu.printMainLogo();
		mainMenu.processMenu();

//        ExploreMenu menu = new ExploreMenu();
//        menu.processMenu();

	}

}
