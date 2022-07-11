package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class NearestSmallerElementTest {


    @Test
    public void shouldFindNearestSmallerNumbersSet1(){
        assertArrayEquals(new int[]{-1,-1,-1},
                new NearestSmallerElement().solve(new int[]{3,2,1}));
    }

    @Test
    public void shouldFindNearestSmallerNumbersSet2(){
        assertArrayEquals(new int[]{-1,-1,-1,1,1,1,-1},
                new NearestSmallerElement().solve(new int[]{3,2,1,10,9,8,1}));
    }

}