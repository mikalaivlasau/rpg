package character.service;

import character.Person;
import character.Warrior;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttackAttributeServiceTest {

	private AttributeService attributeService = new AttackAttributeService();

	@Test
	public void testAttackShouldBeCalculatedAndSet() {
		Person warrior = new Warrior("Warrior");
		int strength = warrior.getStrength();
		assertEquals(0, warrior.getDefense());
		attributeService.calculate(warrior);
		assertEquals(strength, warrior.getAttack());
	}

}