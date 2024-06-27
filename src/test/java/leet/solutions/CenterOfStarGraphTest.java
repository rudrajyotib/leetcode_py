package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CenterOfStarGraphTest {

    @Test
    public void testCase1(){
        assertEquals(2, new CenterOfStarGraph().solve(
                new int[][]{new int[]{1,2},
                        new int[]{4,2},
                        new int[]{3,2}}
        ));
    }

}