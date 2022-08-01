package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileSearchTest {


    @Test
    public void shouldFindSingleSet(){
        assertEquals(1,
                new FileSearch().solve(
                        4,
                        new int[][]{
                                new int[]{1,2},
                                new int[]{2,3},
                                new int[]{3,4}
                        }
                ));
    }

    @Test
    public void shouldFindAMultipleSets(){
        assertEquals(3,
                new FileSearch().solve(
                        6,
                        new int[][]{
                                new int[]{1,2},
                                new int[]{5,3},
                                new int[]{6,4}
                        }
                ));
    }

    @Test
    public void shouldFindAllDisjointedNodes(){
        assertEquals(4, new FileSearch().solve(
                4, new int[][]{}
        ));
    }

}