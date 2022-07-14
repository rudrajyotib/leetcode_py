package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeTwoSortedLists2Test {

    @Test
    public void shouldMergeSet1(){
        ArrayList<Integer> first = new ArrayList<>(List.of(1,3,5,7));
        ArrayList<Integer> second = new ArrayList<>(List.of(2,4,6));

        new MergeTwoSortedLists2().solve(first, second);

        assertEquals(7, first.size());

        for (int i=1;i<=7;i++){
            assertEquals(i, first.get(i-1).intValue());
        }
    }

    @Test
    public void shouldMergeSet2(){
        ArrayList<Integer> first = new ArrayList<>(List.of(1,2,3,5,7));
        ArrayList<Integer> second = new ArrayList<>(List.of(2,4,6));

        new MergeTwoSortedLists2().solve(first, second);

        assertEquals(8, first.size());
        assertArrayEquals(new Integer[]{1,2,2,3,4,5,6,7},
                first.toArray(new Integer[1]));
    }

    @Test
    public void shouldMergeSet3(){
        ArrayList<Integer> first = new ArrayList<>(List.of(1,2,3,5,7));
        ArrayList<Integer> second = new ArrayList<>(List.of(12,14,16));

        new MergeTwoSortedLists2().solve(first, second);

        assertEquals(8, first.size());
        assertArrayEquals(new Integer[]{1,2,3,5,7,12,14,16},
                first.toArray(new Integer[1]));
    }


}