package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingIntegerTest {


    @Test
    public void shouldFindFirstMissingIntegerTestSet1(){
        assertEquals(1, new FirstMissingInteger().solve(new int[]{-2,-3,-4}));
    }

    @Test
    public void shouldFindFirstMissingIntegerTestSet2(){
        assertEquals(1, new FirstMissingInteger().solve(new int[]{-2,-3,-4, 0}));
    }

    @Test
    public void shouldFindFirstMissingIntegerTestSet3(){
        assertEquals(3, new FirstMissingInteger().solve(new int[]{-2,1,2,4,-3,-4, 0}));
    }

    @Test
    public void shouldFindFirstMissingIntegerTestSet4(){
        assertEquals(4, new FirstMissingInteger().solve(new int[]{-2,1,2,3,-3,-4, 0}));
    }

    @Test
    public void shouldFindFirstMissingIntegerTestSet5(){
        assertEquals(1, new FirstMissingInteger().solve(new int[]{-1}));
    }

    @Test
    public void shouldFindFirstMissingIntegerTestSet6(){
        assertEquals(1, new FirstMissingInteger().solve(new int[]{}));
    }

    @Test
    public void shouldFindFirstMissingIntegerTestSet7(){
        assertEquals(1, new FirstMissingInteger().solve(new int[]{-2,10,20,30,-3,-4, 0}));
    }


    @Test
    public void shouldFindFirstMissingIntegerTestSet8(){
        assertEquals(1, new FirstMissingInteger().solve(new int[]{-2,10,20,30,-3,-4}));
    }

}