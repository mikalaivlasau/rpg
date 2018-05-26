import character.Person;
import character.Warrior;
import character.service.DefaultPersonService;
import character.service.PersonService;
import fight.DefaultFightService;
import fight.FightService;
import menu.GameMenu;
import menu.explore.ExploreMenu;
import menu.main.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LetThePartyBegin {

	public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        GameMenu.clearConsole();
        mainMenu.printMainLogo();
        mainMenu.processMenu();

//        ExploreMenu menu = new ExploreMenu();
//        menu.processMenu();


	}

}
