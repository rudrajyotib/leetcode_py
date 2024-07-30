package gfg;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RatInMazeProblem1Test {

    @Test
    public void testCase1(){
        ArrayList<String> paths = new RatInMazeProblem1().findPath(
                new int[][]{
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 1, 0, 1},
                        new int[]{1, 1, 0, 0},
                        new int[]{0, 1, 1, 1},
                }
        );
        assertEquals(2, paths.size());
        assertTrue(paths.contains("DDRDRR"));
        assertTrue(paths.contains("DRDDRR"));
    }

    @Test
    public void testCase2(){
        assertEquals(0, new RatInMazeProblem1().findPath(
                new int[][]{
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 1, 0, 1},
                        new int[]{1, 1, 0, 0},
                        new int[]{0, 1, 0, 1},
                }
        ).size());
    }

    @Test
    public void testCase3(){
        assertEquals(0, new RatInMazeProblem1().findPath(
                new int[][]{
                        new int[]{0, 0, 0, 0},
                        new int[]{1, 1, 0, 1},
                        new int[]{1, 1, 1, 1},
                        new int[]{0, 1, 0, 1},
                }
        ).size());
    }

    @Test
    public void testCase4(){
        assertEquals(0, new RatInMazeProblem1().findPath(
                new int[][]{
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 1, 0, 1},
                        new int[]{1, 1, 1, 1},
                        new int[]{0, 1, 0, 0},
                }
        ).size());
    }

    @Test
    public void testCase5(){
        ArrayList<String> paths = new RatInMazeProblem1().findPath(
                new int[][]{
                        new int[]{1, 1, 1, 1},
                        new int[]{0, 0, 0, 1},
                        new int[]{0, 1, 1, 1},
                        new int[]{0, 0, 0, 1},
                }
        );
        assertEquals(1, paths.size());
        assertTrue(paths.contains("RRRDDD"));
    }


}