package location.map.object;

import fight.DefaultFightService;
import fight.FightService;
import location.Direction;
import location.Location;
import location.map.Coordinate;
import location.map.MapFieldType;
import location.map.MapLocation;
import menu.GameMenu;
import menu.explore.TreasureMenu;
import menu.main.MainMenu;

import static menu.GameMenu.clearConsole;

public abstract class MapObject {
	Coordinate coordinate = new Coordinate(-1, -1);

	public abstract void arrange(MapFieldType[][] map);

	public void move(Direction direction, Location location) {
		Coordinate coordinate = changePosition(direction);
		MapFieldType fieldType = location.checkField(coordinate.getX(), coordinate.getY());
		switch (fieldType) {
			case EMPTY:
				this.coordinate = coordinate;
				break;
			case CREATURE:
				FightService fightService = new DefaultFightService();
				boolean isPersonWin = fightService.fight(coordinate);
				if (isPersonWin) {
					MapLocation mapLocation = (MapLocation) location;
					mapLocation.getMapObject().removeObject(coordinate, mapLocation.getMapObject());
				} else {
					clearConsole();
					System.out.println("THE END!!!");
					GameMenu mainMenu = new MainMenu();
					mainMenu.processMenu();
				}
				this.coordinate = coordinate;
				break;
			case TREASURE:
				GameMenu treasureMenu = new TreasureMenu();
				treasureMenu.processMenu();
				MapLocation mapLocation = (MapLocation) location;
				mapLocation.getMapObject().removeObject(coordinate, mapLocation.getMapObject());
				this.coordinate = coordinate;
				break;
		}

	}

	private Coordinate changePosition(Direction direction) {
		Coordinate coordinate = new Coordinate(getCoordinate().getX(), getCoordinate().getY());
		switch (direction) {
			case EAST:
				coordinate.setX(coordinate.getX() + 1);
				break;
			case WEST:
				coordinate.setX(coordinate.getX() - 1);
				break;
			case NORTH:
				coordinate.setY(coordinate.getY() - 1);
				break;
			case SOUTH:
				coordinate.setY(coordinate.getY() + 1);
				break;
		}
		return coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
}
