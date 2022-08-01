package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathInMatrixTest {

    @Test
    public void shouldFindPathSet1(){
        assertTrue(new PathInMatrix().solve(
                new int[][]{
                        new int[]{0,1,0,0},
                        new int[]{0,3,3,0},
                        new int[]{0,0,3,2},
                }
        ));
    }

    @Test
    public void shouldNotFindPathSet1(){
        assertFalse(new PathInMatrix().solve(
                new int[][]{
                        new int[]{3,3,3,3},
                        new int[]{3,1,0,0},
                        new int[]{3,3,0,2}
                }
        ));
    }


}