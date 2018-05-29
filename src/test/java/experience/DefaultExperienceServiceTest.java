package experience;

import character.Person;
import character.Warrior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultExperienceServiceTest {
	private ExperienceService experienceService = new DefaultExperienceService();
	private Person person;

	@Before
	public void setUp() {
		person = new Warrior("Strongman");
	}

	@Test
	public void testPersonExperienceShouldBeUpdatedAndLevelUp() {
		int experience = Level.TWO.getExp() + 1;
		experienceService.processExperience(person, experience);
		assertEquals(experience, person.getExperience());
		assertEquals(Level.TWO, person.getLevel());
	}

	@Test
	public void testShouldNotReachNextLevelIfNotEnoughExperience() {
		int experience = Level.TWO.getExp() - 1;
		experienceService.processExperience(person, experience);
		assertEquals(experience, person.getExperience());
		assertEquals(Level.ONE, person.getLevel());
	}
}