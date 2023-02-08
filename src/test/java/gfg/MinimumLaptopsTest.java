package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumLaptopsTest {

    @Test
    public void set1(){
        assertEquals(3, new MinimumLaptops().solve(new int[] {1, 2, 3},
                new int[]{4,4,6}));
    }

    @Test
    public void set2(){
        assertEquals(1, new MinimumLaptops().solve(new int[] {1, 5, 2},
                new int[]{2, 6, 3}));
    }


}