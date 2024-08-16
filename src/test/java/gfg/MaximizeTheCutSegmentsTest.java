package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximizeTheCutSegmentsTest {

    @Test
    public void testCase1(){
        assertEquals(5, new MaximizeTheCutSegments().maximizeCuts(
                5, 2,1,1
        ));

        assertEquals(2, new MaximizeTheCutSegments().maximizeCuts(
                5, 5, 3, 2
        ));

        assertEquals(5, new MaximizeTheCutSegments().maximizeCuts(
                10, 5, 3, 2
        ));

        assertEquals(0, new MaximizeTheCutSegments().maximizeCuts(
                97, 51, 31, 21
        ));
    }

}