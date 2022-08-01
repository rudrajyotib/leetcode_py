package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommutableIslandsTest {

    @Test
    public void shouldFindMinCost(){
        assertEquals(6, new CommutableIslands().solve(
                4, new int[][]{
                        new int[]{1,2,1},
                        new int[]{2,3,4},
                        new int[]{1,4,3},
                        new int[]{4,3,2},
                        new int[]{1,3,10},
                }
        ));
    }

}