package menu.main;

import menu.GameMenu;

public class MainMenu extends GameMenu {

    @Override
    public void processMenu() {
        showMenu();
        selectedOption = scanner.next();
        switch (selectedOption) {
            case "1":
                clearConsole();
                StartMenu startMenu = new StartMenu();
                startMenu.processMenu();
                break;
            case "2":
                clearConsole();
                LoadMenu loadMenu = new LoadMenu();
                loadMenu.processMenu();
                break;
            case "3":
                clearConsole();
                exitGame();
                break;
            default:
                clearConsole();
                processMenu();
                break;
        }
    }

    private void showMenu() {
        System.out.println("Main menu");
        System.out.println(MENU_LINE_SEPARATOR);
        System.out.println("1. Start new game");
        System.out.println("2. Load game");
        System.out.println("3. Exit");
        System.out.println(MENU_LINE_SEPARATOR);
        System.out.println();
        System.out.print("Please select an option from 1-3: ");
        System.out.println();
    }

    private void exitGame() {
        System.out.println("Good bye!");
        System.exit(1);
    }

    public void printMainLogo() {
        System.out.println("          .                                                      .");
        System.out.println("        .n                   .                 .                  n.");
        System.out.println("  .   .dP                  dP                   9b                 9b.    .");
        System.out.println(" 4    qXb         .       dX                     Xb       .        dXp     t");
        System.out.println("dX.    9Xb      .dXb    __                         __    dXb.     dXP     .Xb");
        System.out.println("9XXb._       _.dXXXXb dXXXXbo.                 .odXXXXb dXXXXb._       _.dXXP");
        System.out.println(" 9XXXXXXXXXXXXXXXXXXXVXXXXXXXXOo.           .oOXXXXXXXXVXXXXXXXXXXXXXXXXXXXP");
        System.out.println("  `9XXXXXXXXXXXXXXXXXXXXX'~   ~`OOO8b   d8OOO'~   ~`XXXXXXXXXXXXXXXXXXXXXP'");
        System.out.println("    `9XXXXXXXXXXXP' `9XX'   DIE    `98v8P'  HUMAN   `XXP' `9XXXXXXXXXXXP'");
        System.out.println("        ~~~~~~~       9X.          .db|db.          .XP       ~~~~~~~");
        System.out.println("                        )b.  .dbo.dP'`v'`9b.odb.  .dX(");
        System.out.println("                      ,dXXXXXXXXXXXb     dXXXXXXXXXXXb.");
        System.out.println("                     dXXXXXXXXXXXP'   .   `9XXXXXXXXXXXb");
        System.out.println("                    dXXXXXXXXXXXXb   d|b   dXXXXXXXXXXXXb");
        System.out.println("                    9XXb'   `XXXXXb.dX|Xb.dXXXXX'   `dXXP");
        System.out.println("                     `'      9XXXXXX(   )XXXXXXP      `'");
        System.out.println("                              XXXX X.`v'.X XXXX");
        System.out.println("                              XP^X'`b   d'`X^XX");
        System.out.println("                              X. 9  `   '  P )X");
        System.out.println("                              `b  `       '  d'");
        System.out.println("                               `             '");
    }
}
