package menu;

public class LoadMenu extends MainMenu {

    @Override
    public void processMenu() {
        showMenu();
    }

    private void showMenu() {
        System.out.println("Load game menu");
        System.out.println("---------------------------");
        System.out.println("1. Load the game");
        System.out.println("2. Back to main menu");
    }
}
