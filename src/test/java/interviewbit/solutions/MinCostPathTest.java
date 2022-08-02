package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostPathTest {


    @Test
    public void shouldFindMinPathSet1(){
        assertEquals(1, new MinCostPath().solve(
                3, 3, new String[]{"RRR","DDD","UUU"}
        ));
    }

    @Test
    public void shouldFindMinPathSet2(){
        assertEquals(3, new MinCostPath().solve(
                1, 4, new String[]{"LLLL"}
        ));
    }


}