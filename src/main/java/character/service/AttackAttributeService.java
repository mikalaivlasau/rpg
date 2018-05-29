package character.service;

import attribute.Attribute;
import attribute.CompositeAttribute;
import attribute.RawBonus;
import character.Person;

/**
 * {@link AttributeService} implementation for calculating the attack. For now only basic attack is calculated
 * based on strength. Support of weapons, clothes and spells will be added later.
 */
public class AttackAttributeService implements AttributeService {
	@Override
	public void calculate(Person person) {
		Attribute basic = new RawBonus(person.getStrength());
		CompositeAttribute finalAttack = new CompositeAttribute();
		finalAttack.addComponent(basic);
		person.setAttack(finalAttack.calculate());
	}
}
