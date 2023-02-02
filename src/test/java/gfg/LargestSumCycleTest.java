package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestSumCycleTest {

    @Test
    public void set1(){
        assertEquals(3, new LargestSumCycle().solve(4, new int[]{1, 2, 0, -1}));
    }

    @Test
    public void set3(){
        assertEquals(5, new LargestSumCycle().solve(4, new int[]{1,2,3,2}));
    }

    @Test
    public void set4(){
        assertEquals(18, new LargestSumCycle().solve(10, new int[]{8, 6, 5, 8 ,8 ,8 ,8 ,3 ,7 ,3}));
    }

    @Test
    public void set5(){
        assertEquals(14, new LargestSumCycle().solve(11, new int[]{1 ,2 ,3 ,4 ,5 ,2 ,3 ,6 ,9 ,7 ,7}));
    }

    @Test
    public void set2(){
        assertEquals(-1, new LargestSumCycle().solve(4, new int[]{2, 0, -1, 2}));
    }


}