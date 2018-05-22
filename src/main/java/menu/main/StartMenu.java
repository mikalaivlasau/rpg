package menu.main;

import menu.GameMenu;

public class StartMenu extends MainMenu {

    @Override
    public void processMenu() {
        showMenu();
        selectedOption = scanner.next();
        switch (selectedOption) {
            case "1":
                clearConsole();
                GameMenu menu = new CreatePersonMenu();
                menu.processMenu();
                break;
            case "2":
                clearConsole();
                super.processMenu();
                break;
            default:
                clearConsole();
                processMenu();
                break;
        }

    }

    private void showMenu() {
        System.out.println("Start game menu");
        System.out.println(MENU_LINE_SEPARATOR);
        System.out.println("1. Create your character");
        System.out.println("2. Back to main menu");
    }
}
