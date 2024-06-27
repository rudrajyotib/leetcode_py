package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindNearestCloneTest {

    @Test
    public void testCase1(){
        assertEquals(1, FindNearestClone.findShortest(5, new int[]{1,2,2,3}, new int[]{2,3,4,5}, new long[]{1L,2L,3L,1L,3L},3));
    }

}