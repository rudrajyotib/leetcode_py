package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RevealCardsInIncreasingOrderTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new int[]{2,13,3,11,5,17,7},
                new RevealCardsInIncreasingOrder().solve(
                        new int[]{17,13,11,2,3,5,7}
                ));
        assertArrayEquals(new int[]{1,10},
                new RevealCardsInIncreasingOrder().solve(
                        new int[]{1, 10}
                ));
        assertArrayEquals(new int[]{1,7, 3, 10, 5, 9},
                new RevealCardsInIncreasingOrder().solve(
                        new int[]{1, 3, 5, 7, 9, 10}
                ));

    }

}