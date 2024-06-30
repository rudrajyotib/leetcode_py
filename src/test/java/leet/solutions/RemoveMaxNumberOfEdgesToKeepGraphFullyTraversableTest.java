package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableTest {

    @Test
    public void testCase1() {
        assertEquals(2, new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable().solve(
                4,
                new int[][]{
                        new int[]{3, 1, 2},
                        new int[]{3, 2, 3},
                        new int[]{1, 1, 3},
                        new int[]{1, 2, 4},
                        new int[]{1, 1, 2},
                        new int[]{2, 3, 4},
                }));
        assertEquals(0, new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable().solve(
                4,
                new int[][]{
                        new int[]{3, 1, 2},
                        new int[]{3, 2, 3},
                        new int[]{1, 1, 4},
                        new int[]{2, 1, 4},
                }));
        assertEquals(-1, new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable().solve(
                4,
                new int[][]{
                        new int[]{3, 2, 3},
                        new int[]{1, 1, 2},
                        new int[]{2, 3, 4},
                }));
    }


}