package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSwapsToGroupAll1sTest {


    @Test
    public void testCase1(){
        assertEquals(1, new MinimumSwapsToGroupAll1s().solve(new int[]{0,1,0,1,1,0,0}));
        assertEquals(2, new MinimumSwapsToGroupAll1s().solve(new int[]{0,1,1,1,0,0,1,1,0}));
        assertEquals(0, new MinimumSwapsToGroupAll1s().solve(new int[]{1,1,0,0,1}));
        assertEquals(0, new MinimumSwapsToGroupAll1s().solve(new int[]{0,0,0,0}));
        assertEquals(2, new MinimumSwapsToGroupAll1s().solve(new int[]{1,0,0,0,1,1,0,0,0,1}));
        assertEquals(0, new MinimumSwapsToGroupAll1s().solve(new int[]{1,1,1,1}));
        assertEquals(0, new MinimumSwapsToGroupAll1s().solve(new int[]{1,1,0,1,1}));
        assertEquals(1, new MinimumSwapsToGroupAll1s().solve(new int[]{1,1,0,1,1,0}));

    }

}