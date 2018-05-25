package fight;

import character.Person;
import character.service.DefaultPersonService;
import character.service.PersonService;
import location.map.Coordinate;
import location.map.service.LocationService;
import location.map.service.MapLocationService;

public class DefaultFightService implements FightService {
	PersonService personService = new DefaultPersonService();
	LocationService locationService = new MapLocationService();

	@Override
	public void fight(Coordinate coordinate) {
		Person person = personService.getPerson();
		Person creature = locationService.getCreature(coordinate);

	}
}
