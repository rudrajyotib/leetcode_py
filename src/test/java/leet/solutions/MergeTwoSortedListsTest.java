package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedListsTest {

    @Test
    public void shouldMergeSet1() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 7, 8, 11},
                mergeTwoSortedLists.merge(new int[]{1, 4, 8, 11},
                        new int[]{2, 3, 7}));
    }

    @Test
    public void shouldMergeSet2() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 7, 8, 11},
                mergeTwoSortedLists.merge(new int[]{1, 2, 3, 4, 7, 8},
                        new int[]{11}));
    }

}