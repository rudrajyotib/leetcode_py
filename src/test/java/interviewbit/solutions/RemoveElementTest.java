package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemoveElementTest {

    @Test
    public void shouldRemoveElementSet1(){
        ArrayList<Integer> testSet = new ArrayList<>(List.of(4,2,3,1,1,3,4,1,2,1,3));
        assertEquals(7, new RemoveElement().solve(testSet, 1));
        assertEquals(7, testSet.size());
        assertFalse( testSet.contains(1));
    }


     @Test
    public void shouldRemoveElementSet2(){
        ArrayList<Integer> testSet = new ArrayList<>(List.of(1,1,1,1,1));
        assertEquals(0, new RemoveElement().solve(testSet, 1));
        assertEquals(0, testSet.size());
        assertFalse( testSet.contains(1));
    }

    @Test
    public void shouldRemoveElementSet3(){
        ArrayList<Integer> testSet = new ArrayList<>(List.of(4));
        assertEquals(1, new RemoveElement().solve(testSet, 1));
        assertEquals(1, testSet.size());
        assertTrue( testSet.contains(4));
    }


}