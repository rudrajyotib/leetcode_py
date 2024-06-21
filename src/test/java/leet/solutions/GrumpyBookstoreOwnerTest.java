package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrumpyBookstoreOwnerTest {

    @Test
    public void testCase1(){
        assertEquals(16, new GrumpyBookstoreOwner().solve(new int[]{1,0,1,2,1,1,7,5},
                new int[]{0,1,0,1,0,1,0,1},
                3));
        assertEquals(1, new GrumpyBookstoreOwner().solve(new int[]{1},
                new int[]{0},
                1));
        assertEquals(0, new GrumpyBookstoreOwner().solve(new int[]{1},
                new int[]{1},
                0));
        assertEquals(13, new GrumpyBookstoreOwner().solve(new int[]{5,8},
                new int[]{0,1},
                1));
    }


}