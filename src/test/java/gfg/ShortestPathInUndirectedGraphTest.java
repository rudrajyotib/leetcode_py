package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathInUndirectedGraphTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new int[]{0 ,1 ,2 ,1 ,2 ,3 ,3 ,4, 4},
                new ShortestPathInUndirectedGraph().shortestPath(
                        new int[][]{
                                new int[]{0,1},
                                new int[]{0,3},
                                new int[]{3,4},
                                new int[]{4,5},
                                new int[]{5,6},
                                new int[]{1,2},
                                new int[]{6,2},
                                new int[]{6,7},
                                new int[]{8,7},
                                new int[]{8,6},
                        }, 9, 0
                ));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new int[]{1 ,1, -1, 0},
                new ShortestPathInUndirectedGraph().shortestPath(
                        new int[][]{
                                new int[]{3,1},
                                new int[]{0,3}
                        }, 4, 3
                ));
    }

}