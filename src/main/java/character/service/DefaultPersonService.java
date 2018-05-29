package character.service;

import character.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation of {@link PersonService}.
 */
public class DefaultPersonService implements PersonService {

	static final String CHARACTER_KEY = "Character";
	static final Map<String, Person> STORAGE = new HashMap<>();

	@Override
	public Person saveNewCharacter(Person person) {
		STORAGE.put(CHARACTER_KEY, person);
		return person;
	}

	@Override
	public Person getPerson() {
		return STORAGE.get(CHARACTER_KEY);
	}

	@Override
	public void removePerson() {
		STORAGE.clear();
	}
}
