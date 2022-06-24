package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PascalTriangleKthRowTest {

    @Test
    public void shouldGetFirstRow(){
        assertArrayEquals(new Integer[]{1}, new PascalTriangleKthRow().solve(0).toArray(new Integer[1]));
    }

    @Test
    public void shouldGetSecondRow(){
        assertArrayEquals(new Integer[]{1,1}, new PascalTriangleKthRow().solve(1).toArray(new Integer[2]));
    }

    @Test
    public void shouldGetSixthRow(){
        assertArrayEquals(new Integer[]{1,5,10,10,5,1}, new PascalTriangleKthRow().solve(5).toArray(new Integer[6]));
    }

}