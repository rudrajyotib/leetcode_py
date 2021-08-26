package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicates2Test {

    @Test
    public void shouldIdentifyDuplicates()
    {
        ContainsDuplicates2 containsDuplicates2 = new ContainsDuplicates2();
        assertTrue(containsDuplicates2.solve(new int[]{1,2,3,4,5,1}, 5));
        assertFalse(containsDuplicates2.solve(new int[]{1,2,3,4,5,1}, 4));
        assertFalse(containsDuplicates2.solve(new int[]{1}, 4));
        assertTrue(containsDuplicates2.solve(new int[]{1}, 0));
    }

}