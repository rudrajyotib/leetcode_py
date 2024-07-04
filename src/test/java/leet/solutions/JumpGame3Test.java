package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGame3Test {

    @Test
    public void testCase1(){
        assertTrue(new JumpGame3().solve(
                new int[]{4,2,3,0,3,1,2}, 5
        ));
    }

    @Test
    public void testCase2(){
        assertTrue(new JumpGame3().solve(
                new int[]{4,2,3,0,3,1,2}, 0
        ));
    }

    @Test
    public void testCase3(){
        assertFalse(new JumpGame3().solve(
                new int[]{3,0,2,1,2}, 2
        ));
    }

    @Test
    public void testCase4(){
        assertTrue(new JumpGame3().solve(
                new int[]{0,3,0,6,3,3,4}, 6
        ));
    }

    @Test
    public void testCase5(){
        assertTrue(new JumpGame3().solve(
                new int[]{0}, 0
        ));
    }

    @Test
    public void testCase6(){
        assertTrue(new JumpGame3().solve(
                new int[]{0, 0}, 0
        ));
    }


}