package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaximumNonNegativeSubArrayTest {

    @Test
    public void shouldIdentifyEntireListAsSegment()
    {
        assertArrayEquals(new Integer[]{1,2,3,4}, new MaximumNonNegativeSubArray().solve(new ArrayList<>(List.of(1,2,3,4))).toArray(new Integer[1]));
    }

    @Test
    public void shouldIdentifySinglePossibleSegment(){
        assertArrayEquals(new Integer[]{1,2,3,4}, new MaximumNonNegativeSubArray().solve(new ArrayList<>(List.of(1,2,3,4,-1,-2))).toArray(new Integer[1]));
    }

    @Test
    public void shouldIdentifySegmentWithHigherSum(){
        assertArrayEquals(new Integer[]{5,100}, new MaximumNonNegativeSubArray().solve(new ArrayList<>(List.of(1,2,3,4,-1,-2,5,100))).toArray(new Integer[1]));
    }


    @Test
    public void shouldIdentifySegmentWithSameSumAndHigherLength(){
        assertArrayEquals(new Integer[]{5,2,0,100}, new MaximumNonNegativeSubArray().solve(new ArrayList<>(List.of(1,2,3,4,-1,-2,5,2,0,100,-2,1,106))).toArray(new Integer[1]));
    }

    @Test
    public void shouldIdentifySegmentWithSameSumAndSameLengthButLowerIndex(){
        assertArrayEquals(new Integer[]{1,2,3,101}, new MaximumNonNegativeSubArray().solve(new ArrayList<>(List.of(1,2,3,101,-1,-2,5,2,0,100,-2,1,0,0,106))).toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleLargeNumberSet(){
        assertArrayEquals(new Integer[]{1101513929, 1315634022}, new MaximumNonNegativeSubArray().solve(new ArrayList<>(List.of(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421))).toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleListWithNoNegativeNumber(){
        ArrayList<Integer> result = new MaximumNonNegativeSubArray().solve(new ArrayList<>(List.of(-1, -2, -3)));
        assertTrue(result.isEmpty());
    }


}