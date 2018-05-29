package saving;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * Default implementation of {@link SaveService}.
 */
public class DefaultSaveService implements SaveService {

	private static final String SAVE_DIR = "save";

	private PersonService personService = new DefaultPersonService();

	@Override
	public void save(Person person, String filename) {
		File file = new File(SAVE_DIR);
		if (!file.exists()) {
			file.mkdir();
		}
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(SAVE_DIR + File.separator + filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(person);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Person load(String filename) throws IOException {
		Person person = null;
		FileInputStream fileInputStream = new FileInputStream(SAVE_DIR + File.separator + filename);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			person = (Person) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		objectInputStream.close();

		personService.removePerson();
		personService.saveNewCharacter(person);
		return person;
	}

	@Override
	public void listFilesForFolder() {
		File folder = new File(SAVE_DIR);
		if (folder.exists() ) {
			for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
				System.out.println(fileEntry.getName());
			}
		}
	}
}
