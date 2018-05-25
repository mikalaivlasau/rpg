package location;

public interface Location {

    void populate();

    void draw();

    boolean isCellBusy(int x, int y);

}
