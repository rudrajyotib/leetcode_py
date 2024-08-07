package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPenaltyForShopTest {

    @Test
    public void testCase1(){
        Object[][] tests = new Object[][]{
                new Object[]{"NNYNYNYYYNYNYN", 9},
                new Object[]{"YYNY", 2},
                new Object[]{"NNNNN", 0},
                new Object[]{"YYYY", 4},
                new Object[]{"YN", 1},
        };
        for (Object[] t: tests){
            assertEquals(t[1], new MinimumPenaltyForShop().solve((String)t[0] ));
        }
    }


}