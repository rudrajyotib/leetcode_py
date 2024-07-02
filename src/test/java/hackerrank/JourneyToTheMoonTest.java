package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JourneyToTheMoonTest {

    @Test
    public void testCase1(){
        assertEquals(6, JourneyToTheMoon.journeyToMoon(
                5, List.of(
                        List.of(0,1),
                        List.of(0,4),
                        List.of(2,3)
                )
        ));

        assertEquals(10, JourneyToTheMoon.journeyToMoon(
                5, List.of(
                        List.of(0,1),
                        List.of(0,4),
                        List.of(0,3),
                        List.of(2,3)
                )
        ));
    }

}