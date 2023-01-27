package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class GcdArrayTest {

    @Test
    public void set1(){
        assertEquals(3, new GcdArray().solve(4, new int[]{6, 7, 5, 27, 3}));
    }

    @Test
    public void set2(){
        assertEquals(5, new GcdArray().solve(2, new int[]{1, 4, 5}));
    }

    @Test
    public void set3(){
        assertEquals(6, new GcdArray().solve(1, new int[]{6}));
    }

}