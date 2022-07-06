package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestDistanceBetweenNodesOfTreeTest {

    @Test
    public void shouldFindDistanceFromDistributedTree(){
        assertEquals(4, new LargestDistanceBetweenNodesOfTree().solve(new int[]{
                3, 2, -1, 2, 3, 6, 3, 2
        }));
    }

    @Test
    public void shouldFindDistanceFromLinearTree(){
        assertEquals(2, new LargestDistanceBetweenNodesOfTree().solve(
                new int[]{1, -1, 0}
        ));
    }

    @Test
    public void shouldFindDistanceOfLinearShortTree(){
        assertEquals(1, new LargestDistanceBetweenNodesOfTree().solve(
                new int[]{-1, 0}
        ));
    }

    @Test
    public void shouldFindDistanceOfSingleNodeTree(){
        assertEquals(0, new LargestDistanceBetweenNodesOfTree().solve(
                new int[]{-1}
        ));
    }


}