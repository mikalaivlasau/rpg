package experience;

import character.Person;

public class DefaultExperienceService implements ExperienceService {
	@Override
	public void processExperience(Person person, int experience) {

		person.setExperience(person.getExperience() + experience);
		System.out.println(person.getName() + " received " + experience + " experience!");

		Level nextLevel = Level.getByLevelNumber(person.getLevel().getLevelNumber() + 1);
		if (person.getExperience() >= nextLevel.getExp()) {
			person.levelUp(nextLevel);
			System.out.println(person.getName() + " reached " + nextLevel.getLevelNumber() + " level!");
		}
	}
}
