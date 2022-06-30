package interviewbit.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchForRangeTest {

    @Test
    public void shouldSearchRangeThatStartsFromBeginning() {
        assertArrayEquals(new Integer[]{0, 5},
                new SearchForRange().solve(List.of(4, 4, 4, 4, 4, 4, 5, 6, 7), 4).toArray(new Integer[1]));
    }

    @Test
    public void shouldSearchRangeThatStartsFromBeginningWithSinglePresence() {
        assertArrayEquals(new Integer[]{0, 0},
                new SearchForRange().solve(List.of(4, 5, 5, 5, 5, 5, 6, 7), 4).toArray(new Integer[1]));
    }

    @Test
    public void shouldSearchFromListThatEndsWithSearchKey() {
        assertArrayEquals(new Integer[]{4, 5},
                new SearchForRange().solve(List.of(0, 1, 2, 3, 4, 4), 4).toArray(new Integer[1]));
    }

    @Test
    public void shouldSearchFromListThatEndsWithSearchKeyWithSinglePresence() {
        assertArrayEquals(new Integer[]{5, 5},
                new SearchForRange().solve(List.of(0, 1, 2, 3, 3, 4), 4).toArray(new Integer[1]));
    }

    @Test
    public void shouldSearchKeySomewhereInTheMiddle() {
        assertArrayEquals(new Integer[]{2, 4},
                new SearchForRange().solve(List.of(0, 1, 2, 2, 2, 3, 4, 4), 2).toArray(new Integer[1]));
    }

    @Test
    public void shouldSearchKeySomewhereInTheMiddleWithSinglePresence() {
        assertArrayEquals(new Integer[]{1, 1},
                new SearchForRange().solve(List.of(1, 2, 6, 9, 9), 2).toArray(new Integer[1]));
    }

    @Test
    public void shouldReportWhenSearchKeyIsNotPresent() {
        assertArrayEquals(new Integer[]{-1, -1},
                new SearchForRange().solve(List.of(0, 1, 2, 2, 2, 13, 14, 14), 12).toArray(new Integer[1]));
    }

    @Test
    public void shouldReportWhenSearchKeyIsSmallerThanFirstElement() {
        assertArrayEquals(new Integer[]{-1, -1},
                new SearchForRange().solve(List.of(0, 1, 2, 2, 2, 13, 14, 14), -1).toArray(new Integer[1]));
    }


    @Test
    public void shouldReportWhenSearchKeyIsLargerThanLastElement() {
        assertArrayEquals(new Integer[]{-1, -1},
                new SearchForRange().solve(List.of(0, 1, 2, 2, 2, 13, 14, 14), 16).toArray(new Integer[1]));
    }

    @Test
    public void shouldFindRangeInSingleElementArray() {
        assertArrayEquals(new Integer[]{0, 0},
                new SearchForRange().solve(List.of(1), 1).toArray(new Integer[1]));
    }

    @Test
    public void shouldNotFindRangeInSingleElementArray() {
        assertArrayEquals(new Integer[]{-1, -1},
                new SearchForRange().solve(List.of(1), 2).toArray(new Integer[1]));
    }

}