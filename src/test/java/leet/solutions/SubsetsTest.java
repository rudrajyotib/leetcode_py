package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {


    @Test
    public void shouldAddSubsets()
    {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.solve(new int[]{0, 1, 2});
        assertEquals(8, result.size());
    }

    @Test
    public void shouldHandleSingeNumber()
    {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.solve(new int[]{0});
        assertEquals(2, result.size());
    }


}