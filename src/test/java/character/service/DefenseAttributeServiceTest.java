package character.service;

import character.Person;
import character.Warrior;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefenseAttributeServiceTest {
	private AttributeService attributeService = new DefenseAttributeService();

	@Test
	public void testDefenseShouldBeCalculatedAndSet() {
		Person warrior = new Warrior("Warrior");
		int stamina = warrior.getStamina();
		assertEquals(0, warrior.getDefense());
		attributeService.calculate(warrior);
		assertEquals(stamina, warrior.getDefense());
	}
}