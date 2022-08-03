package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistributeCandiesTest {

    @Test
    public void shouldDistributeCandiesSet1(){
        assertEquals(7, new DistributeCandies().solve(
                new int[]{1,5,2,1}
        ));
    }


    @Test
    public void shouldDistributeCandiesSet2(){
        assertEquals(7, new DistributeCandies().solve(
                new int[]{1,5,2,2, 1}
        ));
    }

    @Test
    public void shouldDistributeCandiesSet3(){
        assertEquals(3, new DistributeCandies().solve(
                new int[]{10,10,10}
        ));
    }

    @Test
    public void shouldDistributeCandiesSet4(){
        assertEquals(1, new DistributeCandies().solve(
                new int[]{10}
        ));
    }




}