package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumTest {

    @Test
    public void shouldFindSum()
    {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.solve(new int[]{1, 3, 5}, 9);
        assertEquals(6, result.size());
    }

    @Test
    public void shouldNotFindAny()
    {
        CombinationSum combinationSum = new CombinationSum();
        assertEquals(0, combinationSum.solve(new int[]{4, 2}, 7).size());
    }


}