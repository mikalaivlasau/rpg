package location.map.object;

import location.Direction;
import location.Location;
import location.map.Coordinate;
import location.map.MapFieldType;

public abstract class MapObject {
	Coordinate coordinate;

	public abstract void arrange(MapFieldType[][] map);

	public void move(Direction direction, Location location) {
		Coordinate coordinate = changePosition(direction);
		MapFieldType fieldType = location.checkField(coordinate.getX(), coordinate.getY());
		switch (fieldType) {
			case EMPTY:
				this.coordinate = coordinate;
				break;
			case CREATURE:
				break;
			case TREASURE:
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
