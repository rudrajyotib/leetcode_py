package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareRootTest {

    @Test
    public void testCase1(){
        assertEquals(3143L, new SquareRoot().floorSqrt(9883934L));
        assertEquals(2L, new SquareRoot().floorSqrt(5L));
        assertEquals(5L, new SquareRoot().floorSqrt(25L));
        assertEquals(22L, new SquareRoot().floorSqrt(512L));
        assertEquals(24L, new SquareRoot().floorSqrt(576L));
    }

}