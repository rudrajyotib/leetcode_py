package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOf1BitsTest {

    @Test
    public void shouldFindNumberOf1Bits()
    {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        assertEquals(1, numberOf1Bits.solve(1));
        assertEquals(1, numberOf1Bits.solve(2));
        assertEquals(2, numberOf1Bits.solve(5));
        assertEquals(3, numberOf1Bits.solve(7));
        assertEquals(1, numberOf1Bits.solve(4));
        assertEquals(0, numberOf1Bits.solve(0));
        assertEquals(5, numberOf1Bits.solve(31));
        assertEquals(18, numberOf1Bits.solve(111111111));
    }


}