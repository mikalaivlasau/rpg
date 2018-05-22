package menu;

import character.Thief;
import character.Warrior;
import character.Wizard;
import character.service.DefaultPersonService;
import character.service.PersonService;

public class CreatePersonMenu extends StartMenu {

    public PersonService personService = new DefaultPersonService();

    @Override
    public void processMenu() {
        System.out.println("Enter character's name:");
        String name = scanner.next();
        System.out.println("Choose character's class:");
        System.out.println("1 - Warrior");
        System.out.println("2 - Thief");
        System.out.println("3 - Wizard");
        selectedOption = scanner.next();
        switch (selectedOption) {
            case "1":
                clearConsole();
                personService.saveNewCharacter(new Warrior(name));
                break;
            case "2":
                clearConsole();
                personService.saveNewCharacter(new Thief(name));
                break;
            case "3":
                clearConsole();
                personService.saveNewCharacter(new Wizard(name));
                break;
            default:
                clearConsole();
                processMenu();
                break;
        }

    }

}
