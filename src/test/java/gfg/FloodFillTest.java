package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloodFillTest {

    @Test
    public void testCase1(){
        int[][] image = new int[][]{
                new int[]{1,1,1},
                new int[]{1,1,0},
                new int[]{1,0,1},
        };
        new FloodFill().floodFill(image, 1,1, 2);
        assertArrayEquals(new int[]{2,2,2}, image[0]);
        assertArrayEquals(new int[]{2,2,0}, image[1]);
        assertArrayEquals(new int[]{2,0,1}, image[2]);
    }

    @Test
    public void testCase2(){
        int[][] image = new int[][]{
                new int[]{3,1,1},
                new int[]{1,3,0},
                new int[]{3,0,1},
        };
        new FloodFill().floodFill(image, 1,1, 2);
        assertArrayEquals(new int[]{3,1,1}, image[0]);
        assertArrayEquals(new int[]{1,2,0}, image[1]);
        assertArrayEquals(new int[]{3,0,1}, image[2]);
    }

}