package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MotherVertexTest {

    @Test
    public void shouldFindMotherVertex(){
        assertTrue(new MotherVertex().solve(
                5, new int[][]{
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{3,4},
                        new int[]{3,5},
                }
        ));
    }


 @Test
    public void shouldNotFindMotherVertex(){
        assertFalse(new MotherVertex().solve(
                6, new int[][]{
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{3,4},
                        new int[]{3,5},
                        new int[]{6,3},
                }
        ));
    }


}