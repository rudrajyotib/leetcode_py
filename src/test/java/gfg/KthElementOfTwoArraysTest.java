package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthElementOfTwoArraysTest {

    @Test
    public void testCase1(){
        assertEquals(256, new KthElementOfTwoArrays().kthElement(
                7, new int[]{100, 112, 256, 349, 770}, new int[]{72, 86, 113, 119, 265, 445, 892}
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(6, new KthElementOfTwoArrays().kthElement(
                5, new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}
        ));
    }


}