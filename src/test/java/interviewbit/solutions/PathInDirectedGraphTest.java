package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathInDirectedGraphTest {

    @Test
    public void shouldFindConnectedPathSet1(){
        assertTrue(new PathInDirectedGraph().solve(
                5, new int[][]{
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{3,4},
                        new int[]{4,5},
                }
        ));
    }

    @Test
    public void shouldFindConnectedPathSet2(){
        assertTrue(new PathInDirectedGraph().solve(
                5, new int[][]{
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{3,4},
                        new int[]{4,5},
                }
        ));
    }

    @Test
    public void shouldNotFindConnectedPathSet1(){
        assertFalse(new PathInDirectedGraph().solve(
                7, new int[][]{
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{3,4},
                        new int[]{4,5},
                        new int[]{6,7},
                }
        ));
    }


}