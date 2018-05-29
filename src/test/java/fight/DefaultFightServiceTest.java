package fight;

import character.Person;
import character.Skeleton;
import character.Warrior;
import character.service.PersonService;
import experience.ExperienceService;
import location.map.Coordinate;
import location.map.service.LocationService;
import menu.service.DisplayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFightServiceTest {

	@InjectMocks
	private DefaultFightService fightService;

	@Mock
	private PersonService personService;
	@Mock
	private LocationService locationService;
	@Mock
	private DisplayService displayService;
	@Mock
	private ExperienceService experienceService;

	private Coordinate coordinate;
	private Person vovanchik;
	private Person skeleton;

	@Before
	public void setUp() {
		coordinate = new Coordinate(1, 1);
		vovanchik = new Warrior("Vovanchik");
		when(personService.getPerson()).thenReturn(vovanchik);
		skeleton = new Skeleton();
		when(locationService.getPersonByCoordinate(coordinate)).thenReturn(skeleton);
	}

	@Test
	public void testPersonShouldWin() {
		boolean isWin = fightService.fight(coordinate);
		verify(experienceService).processExperience(vovanchik, skeleton.getExperience());
		assertTrue(vovanchik.isAlive());
		assertTrue(isWin);
	}

	@Test
	public void testSkeletonShouldWin() {
		vovanchik.setHealth(0);
		boolean isWin = fightService.fight(coordinate);
		verify(experienceService, never()).processExperience(vovanchik, skeleton.getExperience());
		assertTrue(skeleton.isAlive());
		assertFalse(isWin);
	}
}