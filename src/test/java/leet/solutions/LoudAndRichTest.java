package leet.solutions;

import org.junit.Assert;
import org.junit.Test;

public class LoudAndRichTest {

    @Test
    public void testCase1() {
        Assert.assertArrayEquals(new int[]{5, 5, 2, 5, 4, 5, 6, 7},
                new LoudAndRich().solve(
                        new int[][]{
                                new int[]{1, 0},
                                new int[]{2, 1},
                                new int[]{3, 1},
                                new int[]{6, 3},
                                new int[]{4, 3},
                                new int[]{5, 3},
                                new int[]{3, 7},
                        },
                        new int[]{3, 2, 5, 4, 6, 1, 7, 0}
                ));
    }

    @Test
    public void testCase2() {
        Assert.assertArrayEquals(new int[]{0},
                new LoudAndRich().solve(
                        new int[][]{
                                new int[]{}
                        },
                        new int[]{0}
                ));
    }

    @Test
    public void testCase3() {
        Assert.assertArrayEquals(new int[]{5, 5, 2, 5, 4, 5, 6, 7, 8, 9},
                new LoudAndRich().solve(
                        new int[][]{
                                new int[]{1, 0},
                                new int[]{2, 1},
                                new int[]{3, 1},
                                new int[]{6, 3},
                                new int[]{4, 3},
                                new int[]{5, 3},
                                new int[]{3, 7},
                                new int[]{9, 8}
                        },
                        new int[]{3, 2, 5, 4, 6, 1, 7, 0, 1, 2}
                ));
    }

}