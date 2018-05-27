package menu.explore;

import location.Direction;
import location.map.MapLocation;
import location.map.object.PersonMapObject;
import location.map.service.LocationService;
import location.map.service.MapLocationService;
import menu.GameMenu;

public class ExploreMenu extends GameMenu {
	LocationService locationService = new MapLocationService();

	@Override
	public void processMenu() {
		MapLocation mapLocation = (MapLocation) locationService.generateLocation(10);
		PersonMapObject personMapObject = mapLocation.getMapObject().getPersonMapObject();
		clearConsole();
		mapLocation.populate();
		mapLocation.draw();

		while (!mapLocation.getMapObject().isEmpty()) {
			selectedOption = scanner.next();
			switch (selectedOption) {
				case "w":
					clearConsole();
					personMapObject.move(Direction.NORTH, mapLocation);
					mapLocation.populate();
					mapLocation.draw();
					break;
				case "a":
					clearConsole();
					personMapObject.move(Direction.WEST, mapLocation);
					mapLocation.populate();
					mapLocation.draw();
					break;
				case "s":
					clearConsole();
					personMapObject.move(Direction.SOUTH, mapLocation);
					mapLocation.populate();
					mapLocation.draw();
					break;
				case "d":
					clearConsole();
					personMapObject.move(Direction.EAST, mapLocation);
					mapLocation.populate();
					mapLocation.draw();
					break;
				case "p":
					clearConsole();
					System.out.println("PAUSE!!!");
					break;
			}

		}

		GameMenu menu = new EndLevelMenu();
		menu.processMenu();
	}
}
