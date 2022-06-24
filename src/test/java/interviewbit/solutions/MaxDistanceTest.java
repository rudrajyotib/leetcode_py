package interviewbit.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MaxDistanceTest {

    @Test
    public void shouldIdentifyExtremeCase(){
        assertEquals(4, new MaxDistance().solve(List.of(1,2,3,4,5)));
    }

    @Test
    public void shouldIdentifyReverseExtremeCase(){
        assertEquals(0, new MaxDistance().solve(List.of(5,4,3,2,1)));
    }

    @Test
    public void shouldIdentifyWhenAllNumbersAreEqual(){
        assertEquals(4, new MaxDistance().solve(List.of(5,5,5,5,5)));
    }


}