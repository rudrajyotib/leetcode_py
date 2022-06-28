package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindPeakElementTest {

    @Test
    public void shouldFindPeakOfSingleNumber() {
        assertEquals(1, new FindPeakElement().solve(new ArrayList<>(List.of(1))));
    }

    @Test
    public void shouldFindPeakAsFirstOfTwoNumbers() {
        assertEquals(1, new FindPeakElement().solve(new ArrayList<>(List.of(1, 0))));
    }

    @Test
    public void shouldFindPeakAsSecondOfTwoNumbers() {
        assertEquals(2, new FindPeakElement().solve(new ArrayList<>(List.of(1, 2))));
    }

    @Test
    public void shouldFindPeakAsFirstOfAscendingSortedArray() {
        assertEquals(42, new FindPeakElement().solve(new ArrayList<>(List.of(42, 12, 22, 32))));
    }

    @Test
    public void shouldFindPeakAsFirstOfDescendingSortedArray() {
        assertEquals(32, new FindPeakElement().solve(new ArrayList<>(List.of(2, 12, 22, 32))));
    }

    @Test
    public void shouldFindPeak() {
        assertEquals(22, new FindPeakElement().solve(new ArrayList<>(List.of(2, 12, 22, 20, 14, 13, 11, 10, 8, 6))));
    }

}