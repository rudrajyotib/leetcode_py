package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AllAncestorsOfNodeInDirectedAcyclicGraphTest {

    @Test
    public void testCase1(){
        List<List<Integer>> result = new AllAncestorsOfNodeInDirectedAcyclicGraph().solve(
                4, new int[][]{
                        new int[]{0,1},
                        new int[]{0,2},
                        new int[]{1,3},
                        new int[]{2,3},
                }
        );

        assertEquals(4, result.size());
        assertEquals(0, result.get(0).size());
        assertArrayEquals(new Integer[]{0}, result.get(1).toArray());
        assertArrayEquals(new Integer[]{0}, result.get(2).toArray());
        assertArrayEquals(new Integer[]{0,1,2}, result.get(3).toArray());

    }



}