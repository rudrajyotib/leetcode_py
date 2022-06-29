package interviewbit.solutions;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MedianOfTwoSortedArraysTest {


    @Test
    public void shouldFindMedianWhenTwoArraysDoNotConflictInRange() {
        assertEquals(10, new MedianOfTwoSortedArrays().solve(
                List.of(1, 2, 3),
                List.of(10, 11, 12, 13)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraysConflictInRange() {
        assertEquals(11, new MedianOfTwoSortedArrays().solve(
                List.of(1, 2, 30),
                List.of(10, 11, 12, 13)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraySet1() {
        assertEquals(7.5, new MedianOfTwoSortedArrays().solve(
                List.of(4, 6, 8, 10),
                List.of(1, 5, 7, 9, 15, 22)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraySet2() {
        assertEquals(7, new MedianOfTwoSortedArrays().solve(
                List.of(4, 6, 8, 11),
                List.of(1, 3, 5, 7, 9, 14, 23)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraySet3() {
        assertEquals(36.5, new MedianOfTwoSortedArrays().solve(
                List.of(40, 46, 48, 51),
                List.of(10, 20, 25, 30, 35, 38)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraySet4() {
        assertEquals(38, new MedianOfTwoSortedArrays().solve(
                List.of(40, 46, 48, 51, 62),
                List.of(10, 20, 25, 30, 35, 38)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraySet5() {
        assertEquals(42.5, new MedianOfTwoSortedArrays().solve(
                List.of(10, 15, 20, 30, 35),
                List.of(40, 45, 50, 55, 60, 65, 70)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraySet6() {
        assertEquals(45, new MedianOfTwoSortedArrays().solve(
                List.of(10, 15, 20, 30),
                List.of(40, 45, 50, 55, 60, 65, 70)
        ), 0.0d);
    }

    @Test
    public void shouldFindMedianWhenTwoArraySet7() {
        assertEquals(5.0d, new MedianOfTwoSortedArrays().solve(
                List.of( -50, -47, -36, -35, 0, 13, 14, 16),
                List.of( -31, 1, 9, 23, 30, 39)
        ), 0.0d);
    }


    @Test
    public void shouldFindMedianWhenTwoArraySet8() {
        assertEquals(33.0d, new MedianOfTwoSortedArrays().solve(
                List.of(  -49, 33, 35, 42),
                List.of( -26)
        ), 0.0d);
    }


    @Test
    public void shouldHandleOneEmptyListAndOtherEvenSizedList() {
        assertEquals(11.5d, new MedianOfTwoSortedArrays().solve(
                Collections.emptyList(),
                List.of(0, 23)
        ), 0.0d);
    }

    @Test
    public void shouldHandleOneEmptyListAndOtherOddSizedList() {
        assertEquals(23.0d, new MedianOfTwoSortedArrays().solve(
                Collections.emptyList(),
                List.of(0, 23, 26)
        ), 0.0d);
    }

    @Test
    public void shouldHandleOneEmptyListAndOtherSingularList() {
        assertEquals(5.0d, new MedianOfTwoSortedArrays().solve(
                Collections.emptyList(),
                List.of(5)
        ), 0.0d);
    }

}