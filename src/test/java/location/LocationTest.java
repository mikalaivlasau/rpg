package location;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLOutput;
import java.util.Arrays;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LocationTest {

    @InjectMocks
    private MapLocation mapLocation = new MapLocation(3);

    @Test
    public void testMapShouldExist() {
        assertNotNull(mapLocation.getMap());
    }

    @Test
    public void testMapWidthShouldBeConfigurable() {
        assertEquals(3, mapLocation.getMap().length);
    }

    @Test
    public void testMapHeightShouldBeConfigurable() {
        assertEquals(3, mapLocation.getMap()[0].length);
        assertEquals(3, mapLocation.getMap()[1].length);
        assertEquals(3, mapLocation.getMap()[2].length);
    }

    @Test
    public void testMapShouldBeSquare() {
        assertEquals(mapLocation.getMap()[0].length, mapLocation.getMap().length);
    }

    @Test
    public void testMapShouldBeFilled() {
        Object[][] map = mapLocation.getMap();
        for (int i = 0; i < mapLocation.getMap().length; i++) {
            for (int j = 0; j < mapLocation.getMap()[i].length; j++) {
                assertNotNull(map[i][j]);
            }
        }
    }
}
