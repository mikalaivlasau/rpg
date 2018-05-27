package saving;

import character.Person;

public interface SaveService {

	void save(Person person, String filename);

	Person load(String filename);

}
