package character.service;

import character.Person;
import character.Warrior;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static character.service.DefaultPersonService.CHARACTER_KEY;
import static character.service.DefaultPersonService.STORAGE;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @InjectMocks private DefaultPersonService service;

    private Person warrior;

    @Before
    public void setUp() {
        String name = "Ktulhu";
        warrior = new Warrior(name);
    }

    @Test
    public void shouldProcessPerson() {
        Person person = service.saveNewCharacter(warrior);
        assertEquals(warrior, person);
    }

    @Test
    public void shouldSavePerson() {
        service.saveNewCharacter(warrior);
        assertEquals(warrior, STORAGE.get(CHARACTER_KEY));
    }
}
