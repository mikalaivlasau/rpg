import menu.main.MainMenu;

public class LetThePartyBegin {

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.clearConsole();
        mainMenu.printMainLogo();
        mainMenu.processMenu();
    }

}
