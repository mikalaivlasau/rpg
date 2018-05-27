package fight;

import character.Person;
import character.Skeleton;
import character.Warrior;
import character.service.DefaultPersonService;
import location.map.Coordinate;
import location.map.service.MapLocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFightServiceTest {

	@InjectMocks
	private DefaultFightService fightService;

	@Mock
	private DefaultPersonService personService;
	@Mock
	private MapLocationService locationService;

	private Coordinate coordinate;
	private Person vovanchik;
	private Person skeleton;

	@Before
	public void setUp() throws Exception {
		vovanchik = new Warrior("Vovanchik");
		when(personService.getPerson()).thenReturn(vovanchik);
		skeleton = new Skeleton();
		when(locationService.getPersonByCoordinate(coordinate)).thenReturn(skeleton);
	}

	@Test
	public void testPlayersShouldAttackEachOther() {
//		fightService.fight(coordinate);

	}
}