package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class GasStationTest {

    @Test
    public void shouldAssertWhenCircuitIsPossible()
    {
        GasStation gasStation = new GasStation();
        assertEquals(3, gasStation.solve(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

    @Test
    public void shouldNotAssertWhenCircuitIsNotPossible()
    {
        GasStation gasStation = new GasStation();
        assertEquals(-1, gasStation.solve(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,3}));
    }



}