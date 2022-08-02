package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathWithGoodNodesTest {

    @Test
    public void shouldFindPathSet1(){
        assertEquals(3, new PathWithGoodNodes().solve(
                new int[]{0,0,1,1,0,0,1,0,1,1},
                new int[][]{
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{2,4},
                        new int[]{2,5},
                        new int[]{3,6},
                        new int[]{3,7},
                        new int[]{6,8},
                        new int[]{7,9},
                        new int[]{7,10},
                },
                1
        ));
    }

    @Test
    public void shouldFindPathSet2(){
        assertEquals(3, new PathWithGoodNodes().solve(
                new int[]{1,0,0,0,1,1,1,0,1},
                new int[][]{
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{1,4},
                        new int[]{4,5},
                        new int[]{4,6},
                        new int[]{5,7},
                        new int[]{5,8},
                        new int[]{6,9},
                },
                2
        ));
    }


}