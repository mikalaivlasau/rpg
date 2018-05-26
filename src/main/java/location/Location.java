package location;

import location.map.MapFieldType;

public interface Location {

	void populate();

	void draw();

	MapFieldType checkField(int x, int y);
}
