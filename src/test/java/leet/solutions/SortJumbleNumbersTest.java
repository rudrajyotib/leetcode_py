package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortJumbleNumbersTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new int[]{338,38,991},
                new SortJumbleNumbers().solve(
                        new int[]{8,9,4,0,2,1,3,5,7,6},
                        new int[]{991,338,38}
                ));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new int[]{123,456,789},
                new SortJumbleNumbers().solve(
                        new int[]{0,1,2,3,4,5,6,7,8,9},
                        new int[]{789,456,123}
                ));
    }

}