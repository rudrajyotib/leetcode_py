package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckIfTwoArraysAreEqualTest {


    @Test
    public void set1(){
        assertTrue(new CheckIfTwoArraysAreEqual().solve(new long[]{1,1,1,2,3,3}, new long[]{3,2,1,1,1,3}));
    }

    @Test
    public void set2(){
        assertTrue(new CheckIfTwoArraysAreEqual().solve(new long[]{1,1,1}, new long[]{1,1,1}));
    }

    @Test
    public void set3(){
        assertFalse(new CheckIfTwoArraysAreEqual().solve(new long[]{1,1,1,2,3}, new long[]{1,1,2,2,3}));
    }

    @Test
    public void set4(){
        assertFalse(new CheckIfTwoArraysAreEqual().solve(new long[]{1,1,1,2,3}, new long[]{1,1,2,2,3, 4}));
    }
}