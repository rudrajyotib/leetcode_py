package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimizeTheSumTest {

    @Test
    public void set1(){
        assertEquals(39, new MinimizeTheSum().solve(new int[]{1,4,7,10}));
    }

    @Test
    public void set2(){
        assertEquals(48, new MinimizeTheSum().solve(new int[]{1, 3, 7, 5, 6}));
    }


}