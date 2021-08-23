package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {

    @Test
    public void shouldFindMissingNumber()
    {
        MissingNumber missingNumber = new MissingNumber();
        assertEquals(2, missingNumber.solve(new int[]{0,1,3}));
        assertEquals(1, missingNumber.solve(new int[]{0}));
    }


}