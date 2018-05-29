package character.service;

import attribute.Attribute;
import attribute.CompositeAttribute;
import attribute.RawBonus;
import character.Person;

/**
 * {@link AttributeService} implementation for calculating the defense. For now only basic defense is calculated
 * based on stamina. Support of armors, clothes and spells will be added later.
 */
public class DefenseAttributeService implements AttributeService {
	@Override
	public void calculate(Person person) {
		Attribute basic = new RawBonus(person.getStamina());
		CompositeAttribute finalDefense = new CompositeAttribute();
		finalDefense.addComponent(basic);
		person.setDefense(finalDefense.calculate());
	}
}
