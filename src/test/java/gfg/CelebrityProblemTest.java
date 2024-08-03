package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CelebrityProblemTest {

    @Test
    public void testCase1(){
        assertEquals(1, new CelebrityProblem().celebrity(
                new int[][]{
                        new int[]{0,1,0},
                        new int[]{0,0,0},
                        new int[]{1,0,1},
                }
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(-1, new CelebrityProblem().celebrity(
                new int[][]{
                        new int[]{0,1},
                        new int[]{1,0},
                }
        ));
    }

}