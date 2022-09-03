package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestNumberTest {


    @Test
    public void shouldFindLargestNumberSet1(){
        assertEquals("3303001", new LargestNumber().solve(
                new int[]{1,3,30,300}
        ));
    }

    @Test
    public void shouldFindLargestNumberSet2(){
        assertEquals("33333", new LargestNumber().solve(
                new int[]{3,3,3,3,3}
        ));
    }

    @Test
    public void shouldFindLargestNumberSet3(){
        assertEquals("30000", new LargestNumber().solve(
                new int[]{3,0,0,0,0}
        ));
    }

    @Test
    public void shouldFindLargestNumberSet4(){
        assertEquals("0", new LargestNumber().solve(
                new int[]{0,0,0,0,0}
        ));
    }


}