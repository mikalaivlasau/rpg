import menu.GameMenu;
import menu.main.MainMenu;
import menu.service.DisplayService;

public class LetThePartyBegin {

	public static void main(String[] args) {

		MainMenu mainMenu = new MainMenu();
		GameMenu.clearConsole();
		DisplayService.printMainLogo();
		mainMenu.processMenu();

	}

}
