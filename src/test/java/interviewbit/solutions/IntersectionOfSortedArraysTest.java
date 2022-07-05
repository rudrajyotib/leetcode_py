package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IntersectionOfSortedArraysTest {


    @Test
    public void shouldFindIntersectionSet1(){
        assertArrayEquals(new Integer[]{4,5},
                new IntersectionOfSortedArrays().solve(
                        new ArrayList<>(List.of(0,1,2,4,5,6,7)),
                        new ArrayList<>(List.of(3,4,5))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldFindIntersectionSet2(){
        assertArrayEquals(new Integer[]{4,5},
                new IntersectionOfSortedArrays().solve(
                        new ArrayList<>(List.of(0,1,2,4,5)),
                        new ArrayList<>(List.of(3,4,5))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldFindIntersectionSet3(){
        assertEquals(0,
                new IntersectionOfSortedArrays().solve(
                        new ArrayList<>(List.of(0,1,2,4,5)),
                        new ArrayList<>(List.of(13,14,15))
                ).size());
    }

    @Test
    public void shouldFindIntersectionSet4(){
        assertArrayEquals(new Integer[]{4,4,5,5},
                new IntersectionOfSortedArrays().solve(
                        new ArrayList<>(List.of(0,1,2,4,4,4,4,5,5,5,5,5,5,5,5)),
                        new ArrayList<>(List.of(3,4,4,5,5))
                ).toArray(new Integer[1]));
    }

}