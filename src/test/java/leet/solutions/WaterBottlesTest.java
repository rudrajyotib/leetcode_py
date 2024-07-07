package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaterBottlesTest {

    @Test
    public void testCase1(){
        assertEquals(13, new WaterBottles().solve(9, 3));
        assertEquals(21, new WaterBottles().solve(17, 5));
    }

}