package menu.explore;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;
import experience.DefaultExperienceService;
import experience.ExperienceService;

public class TreasureMenu extends ExploreMenu {

	private PersonService personService = new DefaultPersonService();
	private ExperienceService experienceService = new DefaultExperienceService();

	@Override
	public void processMenu() {
		clearConsole();
		Person person = personService.getPerson();
		System.out.println("TREASURE!");
		System.out.println("Please choose the award:");
		System.out.println("1 - Regenerate 100% HP");
		System.out.println("2 - Receive experience");
		selectedOption = scanner.next();
		switch (selectedOption) {
			case "1":
				person.setHealth(person.getHealthMax());
				System.out.println("HP fully regenerated!");
				break;
			case "2":
				experienceService.processExperience(person, 100);
				break;
			default:
				processMenu();
				break;
		}
	}
}
