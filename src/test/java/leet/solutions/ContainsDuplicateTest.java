package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {

    @Test
    public void shouldFindDuplicateIfPresent()
    {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        assertTrue(containsDuplicate.solve(new int[]{1,2,3,4,5,6,1}));
        assertFalse(containsDuplicate.solve(new int[]{1,2,3,4,5,6,7}));
    }


}