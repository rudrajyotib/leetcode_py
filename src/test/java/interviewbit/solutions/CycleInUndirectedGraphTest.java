package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CycleInUndirectedGraphTest {

    @Test
    public void shouldIdentifyCycleSet1(){
        assertTrue(new CycleInUndirectedGraph().solve(
                4, new int[][]{
                        new int[]{1,2},
                        new int[]{3,2},
                        new int[]{3,4},
                        new int[]{4,2}
                }
        ));
    }

    @Test
    public void shouldNotIdentifyCycleSet1(){
        assertFalse(new CycleInUndirectedGraph().solve(
                4, new int[][]{
                        new int[]{1,2},
                        new int[]{3,2},
                        new int[]{4,3},
                }
        ));
    }

    @Test
    public void shouldNotIdentifyCycleSet2(){
        assertFalse(new CycleInUndirectedGraph().solve(
                7, new int[][]{
                        new int[]{1,2},
                        new int[]{3,1},
                        new int[]{4,3},
                        new int[]{5,6},
                        new int[]{5,7},
                }
        ));
    }


}