package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CycleInDirectedGraphTest {

    @Test
    public void shouldIdentifyCycleSet1() {
        assertTrue(new CycleInDirectedGraph().solve(
                5, new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 1},
                        new int[]{3, 4},
                        new int[]{4, 5}
                }
        ));
    }

    @Test
    public void shouldIdentifyNoCycleSet1() {
        assertFalse(new CycleInDirectedGraph().solve(
                7, new int[][]{
                        new int[]{1, 2},
                        new int[]{1, 3},
                        new int[]{2, 4},
                        new int[]{3, 4},
                        new int[]{4, 5},
                        new int[]{5, 6},
                        new int[]{5, 7}
                }
        ));
    }

    @Test
    public void shouldIdentifyCycleSet2() {
        assertTrue(new CycleInDirectedGraph().solve(
                5, new int[][]{
                        new int[]{5, 5},
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 4},
                        new int[]{4, 4}
                }
        ));
    }


}