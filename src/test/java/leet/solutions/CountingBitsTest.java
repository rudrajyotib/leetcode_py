package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountingBitsTest {

    @Test
    public void shouldCountBits() {
        CountingBits countingBits = new CountingBits();
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countingBits.solve(5));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2, 2, 3}, countingBits.solve(7));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1}, countingBits.solve(8));
        assertArrayEquals(new int[]{0}, countingBits.solve(0));
        assertArrayEquals(new int[]{0, 1}, countingBits.solve(1));
        assertArrayEquals(new int[]{0, 1, 1}, countingBits.solve(2));
    }


}