package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Subsets2Test {

    @Test
    public void shouldCreateSubsetsFromSetWithoutDuplicates()
    {
        Subsets2 subsets2 = new Subsets2();
        List<List<Integer>> result = subsets2.solve(new int[]{0, 1, 2});
        assertEquals(8, result.size());
    }

    @Test
    public void shouldCreateSubsetsFromSortedSetWithDuplicates()
    {
        Subsets2 subsets2 = new Subsets2();
        List<List<Integer>> result = subsets2.solve(new int[]{1, 2, 2});
        assertEquals(6, result.size());
    }

    @Test
    public void shouldCreateSubsetsFromUnsortedSetWithDuplicates()
    {
        Subsets2 subsets2 = new Subsets2();
        List<List<Integer>> result = subsets2.solve(new int[]{2, 1, 2});
        assertEquals(6, result.size());
    }


}