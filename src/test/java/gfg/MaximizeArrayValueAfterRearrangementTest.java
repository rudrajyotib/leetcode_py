package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximizeArrayValueAfterRearrangementTest {

    @Test
    public void testCase1(){
        assertEquals(40, new MaximizeArrayValueAfterRearrangement().maximize(new int[]{5, 3, 2, 4, 1}));
    }

}