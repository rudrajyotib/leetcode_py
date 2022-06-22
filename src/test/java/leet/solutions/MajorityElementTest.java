package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {

    @Test
    public void shouldFindElementWithMajority()
    {
        MajorityElement majorityElement = new MajorityElement();
        assertEquals(1, majorityElement.solve(new int[]{1,1,2,2,2,1,1,1,1,1,1,1,1,1}));
    }



}