package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void shouldCreateAllCombinationsOf2()
    {
        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.solve(4, 2);
        assertEquals(6, result.size());
    }

    @Test
    public void shouldAddAllElementsInSingleList()
    {
        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.solve(6, 6);
        assertEquals(1, result.size());
        assertEquals(6, result.get(0).size());
    }

    @Test
    public void shouldChoseSingleElementEachTime()
    {
        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.solve(2, 1);
        assertEquals(2, result.size());
        for (int i=1;i<=2;i++)
        {
            assertEquals(1, result.get(i - 1).size());
            assertEquals(i, result.get(i-1).get(0).intValue());
        }
    }


}