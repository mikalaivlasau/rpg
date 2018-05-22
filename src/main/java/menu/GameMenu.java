package menu;

import java.util.Scanner;

public abstract class GameMenu {

    Scanner scanner = new Scanner(System.in);
    String selectedOption;

    public abstract void processMenu();

    public void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
