package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class IpoTest {

    @Test
    public void testCase1(){
        assertEquals(4, new Ipo().solve(
                2, 0, new int[]{1,2,3}, new int[]{0,1,1}
        ));
        assertEquals(6, new Ipo().solve(
                3, 0, new int[]{1,2,3}, new int[]{0,1,2}
        ));
    }


}