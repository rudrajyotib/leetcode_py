package interviewbit.coderlift.july2022;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotTheShortestPathTest {

    @Test
    public void shouldFindPathSet1(){
        assertArrayEquals(new int[]{3,3,1,3},
                new NotTheShortestPath().solve(
                        6,
                        new int[][]{
                                new int[]{1,2},
                                new int[]{1,3},
                                new int[]{1,4},
                                new int[]{3,5},
                                new int[]{3,6}
                        },
                        new int[][]{
                                new int[]{2,5,6},
                                new int[]{5,2,6},
                                new int[]{2,5,4},
                                new int[]{2,5,3}
                        }
                ));
    }


}