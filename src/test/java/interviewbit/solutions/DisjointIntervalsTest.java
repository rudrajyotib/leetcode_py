package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class DisjointIntervalsTest {

    @Test
    public void shouldFindIntervalsWithoutOverlapSet1(){
        assertEquals(4, new DisjointIntervals().solve(
                new int[][]{
                        new int[]{1,2},
                        new int[]{3,4},
                        new int[]{13,14},
                        new int[]{23,24},
                }
        ));
    }

    @Test
    public void shouldFindIntervalsWithoutOverlapSet2(){
        assertEquals(3, new DisjointIntervals().solve(
                new int[][]{
                        new int[]{1,4},
                        new int[]{2,3},
                        new int[]{4,6},
                        new int[]{8,9},
                }
        ));
    }

    @Test
    public void shouldNotFindAnyDisjointIntervals(){
        assertEquals(2, new DisjointIntervals().solve(
                new int[][]{
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{3,4},
                        new int[]{4,5},
                }
        ));
    }

    @Test
    public void shouldConsiderIntervalsContainedWithinOther(){
        assertEquals(5, new DisjointIntervals().solve(
                new int[][]{
                        new int[]{1,2},
                        new int[]{3,4},
                        new int[]{0,10},
                        new int[]{11,100},
                        new int[]{12,15},
                        new int[]{16,18},
                        new int[]{102,110},
                }
        ));
    }



}