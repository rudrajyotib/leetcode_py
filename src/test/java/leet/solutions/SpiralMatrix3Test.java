package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMatrix3Test {

    @Test
    public void testCase1() {
        int[][] answer = new SpiralMatrix3().solve(3, 4, 0, 1);
        int[][] expected = new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 2},
                new int[]{1, 1},
                new int[]{1, 0},
                new int[]{0, 0},
                new int[]{0, 3},
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{2, 2},
                new int[]{2, 1},
                new int[]{2, 0},
        };
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], answer[i]);
        }
        assertEquals(expected.length, answer.length);
    }


    @Test
    public void testCase2() {
        int[][] answer = new SpiralMatrix3().solve(1, 2, 0, 1);
        int[][] expected = new int[][]{
                new int[]{0, 1},
                new int[]{0, 0},

        };
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], answer[i]);
        }
        assertEquals(expected.length, answer.length);
    }

    @Test
    public void testCase3() {
        int[][] answer = new SpiralMatrix3().solve(1, 2, 0, 0);
        int[][] expected = new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},

        };
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], answer[i]);
        }
        assertEquals(expected.length, answer.length);
    }

}