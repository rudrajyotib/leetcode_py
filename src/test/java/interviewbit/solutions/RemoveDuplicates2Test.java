package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemoveDuplicates2Test {


    @Test
    public void shouldRemoveDuplicatesSet1(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,1,1,1,2,2,2,2,2));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertArrayEquals(new Integer[]{1,1,2,2},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }

    @Test
    public void shouldRemoveDuplicatesSet2(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,1,1,1));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertArrayEquals(new Integer[]{1,1},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }

    @Test
    public void shouldRemoveDuplicatesSet3(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,1));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertArrayEquals(new Integer[]{1,1},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }


    @Test
    public void shouldRemoveDuplicatesSet4(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,1,1,1,2,2,2,2,2,3,3));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertArrayEquals(new Integer[]{1,1,2,2,3,3},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }

    @Test
    public void shouldRemoveDuplicatesSet5(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,1,1,1,2,2,2,2,2,3,3, 3));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertArrayEquals(new Integer[]{1,1,2,2,3,3},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }

    @Test
    public void shouldRemoveDuplicatesSet6(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertArrayEquals(new Integer[]{1},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }

    @Test
    public void shouldRemoveDuplicatesSet7(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,1,1,1,2,2,2,2,2,3));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertEquals(5, adjustedListIndex);
        assertArrayEquals(new Integer[]{1,1,2,2,3},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }

    @Test
    public void shouldRemoveDuplicatesSet8(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,1,2,2,3));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertEquals(5, adjustedListIndex);
        assertArrayEquals(new Integer[]{1,1,2,2,3},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }

    @Test
    public void shouldRemoveDuplicatesSet9(){
        ArrayList<Integer> list = new ArrayList<>(List.of(0, 0, 0, 1, 1, 2, 2, 3));
        int adjustedListIndex = new RemoveDuplicates2().solve(list);
        assertEquals(7, adjustedListIndex);
        assertArrayEquals(new Integer[]{0, 0, 1, 1, 2, 2, 3},
                list.subList(0, adjustedListIndex).toArray(new Integer[1]));
    }


}