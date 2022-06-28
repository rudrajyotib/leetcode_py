package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RotatedSortedArraySearchTest {

    @Test
    public void shouldIdentifyNumberFromRotatedArrayTailPortion(){
        assertEquals(2, new RotatedSortedArraySearch().solve(10, new ArrayList<>(List.of(8,9,10,12,1,2,3,4,5,6,7))));
    }

    @Test
    public void shouldIdentifyNumberFromRotatedArraySortedPortion(){
        assertEquals(6, new RotatedSortedArraySearch().solve(3, new ArrayList<>(List.of(8,9,10,12,1,2,3,4,5,6,7))));
    }

    @Test
    public void shouldIdentifyNumberFromUnRotatedArray(){
        assertEquals(2, new RotatedSortedArraySearch().solve(3, new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,12))));
    }

    @Test
    public void shouldIdentifyNumberNotPresentInRotatedPortion(){
        assertEquals(-1, new RotatedSortedArraySearch().solve(11, new ArrayList<>(List.of(8,9,10,12,1,2,3,4,5,6,7))));
    }

    @Test
    public void shouldIdentifyNumberNotPresentInSortedPortion(){
        assertEquals(-1, new RotatedSortedArraySearch().solve(5, new ArrayList<>(List.of(8,9,10,12,1,2,3,4,6,7))));
    }

    @Test
    public void shouldIdentifyNumberNotPresentLessThanSmallestInArray(){
        assertEquals(-1, new RotatedSortedArraySearch().solve(0, new ArrayList<>(List.of(8,9,10,12,1,2,3,4,6,7))));
    }

    @Test
    public void shouldIdentifyNumberNotPresentMoreThanLargestInArray(){
        assertEquals(-1, new RotatedSortedArraySearch().solve(13, new ArrayList<>(List.of(8,9,10,12,1,2,3,4,6,7))));
    }




}