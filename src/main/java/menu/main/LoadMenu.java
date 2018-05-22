package menu.main;

public class LoadMenu extends MainMenu {

    @Override
    public void processMenu() {
        showMenu();
        scanner.next();
        super.processMenu();
    }

    private void showMenu() {
        System.out.println("Load game menu");
        System.out.println(MENU_LINE_SEPARATOR);
        System.out.println("1. Load the game");
        System.out.println("2. Back to main menu");
    }
}
