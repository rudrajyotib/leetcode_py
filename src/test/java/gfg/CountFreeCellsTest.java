package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountFreeCellsTest {

    @Test
    public void set1(){
        assertArrayEquals(new long[]{4,2,1 },
                new CountFreeCells().solve(new int[][]{
            {2,2},{2,3},{3,2}}, 3));
    }

    @Test
    public void set2(){
        assertArrayEquals(new long[]{1,0 },
                new CountFreeCells().solve(new int[][]{
            {1,2},{1,1}}, 2));
    }

}