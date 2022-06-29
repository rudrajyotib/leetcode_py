package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/min-jumps-array/
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumJumpsArrayTest {

    @Test
    public void shouldReportJumpNotPossible(){
        assertEquals(-1, new MinimumJumpsArray().solve(
                new ArrayList<>(List.of(1,2,0,0,3,6))
        ));
    }

    @Test
    public void shouldReportMinimumJump(){
        assertEquals(3, new MinimumJumpsArray().solve(
                new ArrayList<>(List.of(1,3,5,8,9,2,6,7,6,8,9))
        ));
    }

    @Test
    public void shouldReportOnlyPossibleJump(){
        assertEquals(4, new MinimumJumpsArray().solve(
                new ArrayList<>(List.of(1,2,0,3,0,0,4,0,0,0,1))
        ));
    }

    @Test
    public void shouldReportNotPossibleWhenFirstStepIsZero(){
        assertEquals(-1, new MinimumJumpsArray().solve(
                new ArrayList<>(List.of(0,1,2,0,3,0,0,4,0,0,0,1))
        ));
    }

    @Test
    public void shouldSupportSingleCellList(){
        assertEquals(0, new MinimumJumpsArray().solve(
                new ArrayList<>(List.of(1))
        ));
    }

    @Test
    public void shouldSupportSingleCellListWithZero(){
        assertEquals(0, new MinimumJumpsArray().solve(
                new ArrayList<>(List.of(0))
        ));
    }




}