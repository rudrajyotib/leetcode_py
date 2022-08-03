package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class HighestProductTest {

    @Test
    public void shouldFindMaxProductFromAllPositiveNumbers(){
        assertEquals(120, new HighestProduct().solve(new int[]{1,2,3,4,5,6}));
    }

    @Test
    public void shouldFindMaxProductAsZero(){
        assertEquals(0, new HighestProduct().solve(new int[]{-1,0,2,3}));
    }

    @Test
    public void shouldFindMaxProductUsingNegativeNumbers(){
        assertEquals(18, new HighestProduct().solve(new int[]{-1,-2,-3,0,2,3}));
    }

    @Test
    public void shouldCalculateMaxProductFromAllNegativeNumbers(){
        assertEquals(-24, new HighestProduct().solve(new int[]{-2,-3,-4,-5,-6}));
    }
}