package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctNumbersInWindowTest {

    @Test
    public void shouldFindDistinctNumbersInWindowSet1(){
        assertArrayEquals(new int[]{4,4,4,4},
                new DistinctNumbersInWindow().solve(new int[]{1,2,3,4,5,6,7}, 4));
    }

    @Test
    public void shouldFindDistinctNumbersInWindowSet2(){
        assertArrayEquals(new int[]{4,4,3,3},
                new DistinctNumbersInWindow().solve(new int[]{1,2,3,4,5,3,4}, 4));
    }

    @Test
    public void shouldFindDistinctNumbersInWindowSet3(){
        assertArrayEquals(new int[]{1,1,1,1,1},
                new DistinctNumbersInWindow().solve(new int[]{1,1,1,1,1,1,1,1}, 4));
    }

    @Test
    public void shouldFindDistinctNumbersInWindowSet4(){
        assertArrayEquals(new int[]{1},
                new DistinctNumbersInWindow().solve(new int[]{1,1,1,1}, 4));
    }

    @Test
    public void shouldFindDistinctNumbersInWindowSet5(){
        assertArrayEquals(new int[]{1,2},
                new DistinctNumbersInWindow().solve(new int[]{1,1,1,1,2}, 4));
    }


}