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

/**
 * The object on the map.
 */
public abstract class MapObject {
	Coordinate coordinate = new Coordinate(-1, -1);

	/**
	 * Arranges map. Put specific objects.
	 *
	 * @param map to arrange
	 */
	public abstract void arrange(MapFieldType[][] map);

	/**
	 * Moves character on the map. Checks the target field and decides what to do: fight, get treasure or just go.
	 *
	 * @param direction to move
	 * @param location  the map
	 */
	public void move(Direction direction, Location location) {
		Coordinate coordinate = changePosition(direction);
		MapFieldType fieldType = location.checkField(coordinate);
		MapLocation mapLocation = (MapLocation) location;
		switch (fieldType) {
			case EMPTY:
				this.coordinate = coordinate;
				break;
			case CREATURE:
				FightService fightService = new DefaultFightService();
				boolean isPersonWin = fightService.fight(coordinate);
				if (isPersonWin) {
					mapLocation.getMapObject().removeObject(coordinate, mapLocation.getMapObject());
					this.coordinate = coordinate;
				} else {
					clearConsole();
					System.out.println("THE END!!!");
					GameMenu mainMenu = new MainMenu();
					mainMenu.processMenu();
				}
				break;
			case TREASURE:
				GameMenu treasureMenu = new TreasureMenu();
				treasureMenu.processMenu();
				mapLocation.getMapObject().removeObject(coordinate, mapLocation.getMapObject());
				this.coordinate = coordinate;
				break;
		}

	}

	/**
	 * Changes coordinate based on {@link Direction}.
	 *
	 * @param direction to go
	 * @return new coordinate
	 */
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
