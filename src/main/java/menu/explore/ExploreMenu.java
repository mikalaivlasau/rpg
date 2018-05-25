package menu.explore;

import location.Location;
import location.MapLocation;
import location.object.*;
import menu.GameMenu;

public class ExploreMenu extends GameMenu {
    @Override
    public void processMenu() {
        MapObject personMapObject = new PersonMapObject(0, 0);

        MapObject creature1 = new CreatureMapObject(2, 2);
        MapObject creature2 = new CreatureMapObject(2, 0);

        CompositeMapObject creatures = new CompositeMapObject();
        creatures.addObject(creature1);
        creatures.addObject(creature2);

        MapObject treasure = new TreasureMapObject(2, 1);

        CompositeMapObject treasures = new CompositeMapObject();
        treasures.addObject(treasure);

        CompositeMapObject allObjects = new CompositeMapObject();
        allObjects.addObject(personMapObject);
        allObjects.addObject(creatures);
        allObjects.addObject(treasure);

        int size = 3;
        Location mapLocation = new MapLocation(size, allObjects);

        clearConsole();
        mapLocation.populate();
        mapLocation.draw();

        while (true) {
            selectedOption = scanner.next();
            switch (selectedOption) {
                case "w":
                    clearConsole();
                    personMapObject.goNorth();
                    mapLocation.isCellBusy(personMapObject.getX(), personMapObject.getY());
                    mapLocation.populate();
                    mapLocation.draw();
                    break;
                case "a":
                    clearConsole();
                    personMapObject.goWest();
                    mapLocation.isCellBusy(personMapObject.getX(), personMapObject.getY());
                    mapLocation.populate();
                    mapLocation.draw();
                    break;
                case "s":
                    clearConsole();
                    personMapObject.goSouth(size);
                    mapLocation.isCellBusy(personMapObject.getX(), personMapObject.getY());
                    mapLocation.populate();
                    mapLocation.draw();
                    break;
                case "d":
                    clearConsole();
                    personMapObject.goEast(size);
                    mapLocation.isCellBusy(personMapObject.getX(), personMapObject.getY());
                    mapLocation.populate();
                    mapLocation.draw();
                    break;
                case "p":
                    clearConsole();
                    System.out.println("PAUSE!!!");
                    break;
            }

        }
    }
}
