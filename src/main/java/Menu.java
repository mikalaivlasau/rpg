import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private String selectedOption;
    private PersonService personService;

    public static void main(String[] args) {
        Menu menu = new Menu();
        clearConsole();
        menu.callMainMenu();
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void callMainMenu() {
        showMainMenu();
        scanner = new Scanner(System.in);
        selectedOption = scanner.next();
        switch (selectedOption) {
            case "1":
                clearConsole();
                showSubMenuOptions(1);
                break;
            case "2":
                clearConsole();
                showSubMenuOptions(2);
                break;
            case "3":
                clearConsole();
                exitGame();
                break;
            default:
                clearConsole();
                callMainMenu();
                break;
        }
    }

    public void showMainMenu() {
        System.out.println("Menu Menu");
        System.out.println("---------------------------");
        System.out.println("1. Start new game");
        System.out.println("2. Load game");
        System.out.println("3. Exit");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.print("Please select an option from 1-3: ");
        System.out.println("");
    }

    public void showSubMenuOptions(int mainMenuChoice) {
        switch (mainMenuChoice) {
            case 1:
                System.out.println("Start game options");
                System.out.println("---------------------------");
                System.out.println("1. Back to main menu");
                break;
            case 2:
                System.out.println("Load game options");
                System.out.println("---------------------------");
                System.out.println("1. Back to main menu");
                break;
        }

        scanner = new Scanner(System.in);
        selectedOption = scanner.next();
        switch (selectedOption) {
            case "1":
                clearConsole();
                callMainMenu();
                break;
            case "2":
                clearConsole();
                personService.createPerson();
                break;
            default:
                clearConsole();
                callMainMenu();
                break;
        }

    }

    public void exitGame() {
        System.out.println("Good bye!");
        System.exit(1);
    }

}
