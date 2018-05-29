package saving;

import character.Person;

import java.io.File;
import java.io.IOException;

/**
 * Service allows saving and loading the game.
 */
public interface SaveService {

	/**
	 * Saves the game to file system.
	 *
	 * @param person   to save
	 * @param filename of the game
	 */
	void save(Person person, String filename);

	/**
	 * Loads saved game from file system.
	 *
	 * @param filename of game to load
	 * @return loaded person
	 */
	Person load(String filename) throws IOException;

	/**
	 * Lists all files in folder.
	 */
	void listFilesForFolder();
}
