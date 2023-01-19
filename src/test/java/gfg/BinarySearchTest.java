package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void set1(){
        assertEquals(3, new BinarySearch().solve(new int[]{1,2,3,4,5,6,7}, 7, 4));
    }

    @Test
    public void set2(){
        assertEquals(0, new BinarySearch().solve(new int[]{1,2,3,4,5,6,7}, 7, 1));
    }

    @Test
    public void set3(){
        assertEquals(6, new BinarySearch().solve(new int[]{1,2,3,4,5,6,7}, 7, 7));
    }

    @Test
    public void set4(){
        assertEquals(-1, new BinarySearch().solve(new int[]{11,22,33,44,55,66,77}, 7, 40));
    }

    @Test
    public void set5(){
        assertEquals(-1, new BinarySearch().solve(new int[]{11,22,33,44,55,66,77}, 7, 80));
    }

    @Test
    public void set6(){
        assertEquals(-1, new BinarySearch().solve(new int[]{11,22,33,44,55,66,77}, 7, 10));
    }

}