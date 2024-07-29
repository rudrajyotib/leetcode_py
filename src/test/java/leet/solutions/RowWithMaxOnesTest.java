package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RowWithMaxOnesTest {
    @Test
    public void testCase1() {
        assertArrayEquals(new int[]{2, 3}, new RowWithMaxOnes().solve(
                new int[][]{
                        new int[]{0, 0, 0, 1},
                        new int[]{0, 0, 1, 1},
                        new int[]{0, 1, 1, 1},
                        new int[]{0, 1, 1, 1},
                }
        ));
    }

    @Test
    public void testCase2() {
        assertArrayEquals(new int[]{-1, -1}, new RowWithMaxOnes().solve(
                new int[][]{
                        new int[]{0, 0, 0, 0},
                        new int[]{0, 0, 0, 0},
                }
        ));
    }

    @Test
    public void testCase3() {
        assertArrayEquals(new int[]{3, 4}, new RowWithMaxOnes().solve(
                new int[][]{
                        new int[]{0, 0, 0, 1},
                        new int[]{0, 0, 1, 1},
                        new int[]{0, 1, 1, 1},
                        new int[]{1, 1, 1, 1},
                }
        ));
    }

    @Test
    public void testCase4() {
        assertArrayEquals(new int[]{0, 1}, new RowWithMaxOnes().solve(
                new int[][]{
                        new int[]{0, 0, 0, 1},
                }
        ));
    }

    @Test
    public void testCase5() {
        assertArrayEquals(new int[]{4, 1}, new RowWithMaxOnes().solve(
                new int[][]{
                        new int[]{0},
                        new int[]{0},
                        new int[]{0},
                        new int[]{0},
                        new int[]{1},
                        new int[]{1},
                        new int[]{1},
                        new int[]{0},
                }
        ));
    }

    @Test
    public void testCase6() {
        assertArrayEquals(new int[]{5, 2}, new RowWithMaxOnes().solve(
                new int[][]{
                        new int[]{0, 0},
                        new int[]{0, 0},
                        new int[]{0, 0},
                        new int[]{0, 0},
                        new int[]{0, 1},
                        new int[]{1, 1},
                        new int[]{0, 1},
                        new int[]{0, 0},
                }
        ));
    }

    @Test
    public void testCase7() {
        assertArrayEquals(new int[]{1, 2}, new RowWithMaxOnes().solve(
                new int[][]{
                        new int[]{0, 0, 0, 1},
                        new int[]{0, 0, 1, 1},
                        new int[]{0, 1, 0, 1},
                        new int[]{1, 0, 0, 1},
                }
        ));
    }
}