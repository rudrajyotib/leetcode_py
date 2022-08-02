package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectedComponentsTest {


    @Test
    public void shouldIdentifyConnectedComponentsSet1(){
        assertEquals(1, new ConnectedComponents().solve(
                5, new int[][]{
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{1,4},
                        new int[]{1,5},
                }
        ));
    }

    @Test
    public void shouldIdentifyConnectedComponentsSet2(){
        assertEquals(2, new ConnectedComponents().solve(
                5, new int[][]{
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{4,5},
                }
        ));
    }

    @Test
    public void shouldIdentifyConnectedComponentsSet3(){
        assertEquals(5, new ConnectedComponents().solve(
                5, new int[][]{}
        ));
    }

}