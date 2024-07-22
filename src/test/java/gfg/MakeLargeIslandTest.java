package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MakeLargeIslandTest {

    @Test
    public void testCase1(){
        assertEquals(11 ,
                new MakeLargeIsland().largestIsland(
                    4,
                        new int[][]{
                                new int[]{1,0,1,0},
                                new int[]{1,1,0,1},
                                new int[]{1,1,0,1},
                                new int[]{1,0,0,1},
                        }
                ));
    }

}