package character.service;

import character.Person;

public interface PersonService {

	Person saveNewCharacter(Person person);

	Person getPerson();
}
