import character.Person;
import character.Warrior;
import character.service.DefaultPersonService;
import character.service.PersonService;

public class LetThePartyBegin {

	public static void main(String[] args) {

//        MainMenu mainMenu = new MainMenu();
//        mainMenu.clearConsole();
//        mainMenu.printMainLogo();
//        mainMenu.processMenu();

//        ExploreMenu menu = new ExploreMenu();
//        menu.processMenu();

		PersonService personService = new DefaultPersonService();
		personService.saveNewCharacter(new Warrior("Nik"));
		personService = null;

		PersonService personService2 = new DefaultPersonService();
		Person person = personService2.getPerson();
		System.out.println(person.getName());
	}

}
