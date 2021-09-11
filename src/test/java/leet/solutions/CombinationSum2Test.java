package leet.solutions;


import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationSum2Test {

    @Test
    public void shouldFindCombination()
    {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        assertEquals(1, combinationSum2.solve(new int[]{1, 3, 5}, 9).size());
    }

    @Test
    public void shouldFindUniqueCombinationsFromDuplicateNumbersSet1()
    {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        assertEquals(3, combinationSum2.solve(new int[]{1, 1, 1, 3, 3, 3, 5}, 9).size());
    }

    @Test
    public void shouldFindUniqueCombinationsFromDuplicateNumbersSet2()
    {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        assertEquals(3, combinationSum2.solve(new int[]{1, 2, 2, 2, 3, 5}, 6).size());
    }

    @Test
    public void shouldNotFindCombination()
    {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        assertEquals(0, combinationSum2.solve(new int[]{4, 2}, 8).size());
    }


}