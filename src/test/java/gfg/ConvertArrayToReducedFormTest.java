package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertArrayToReducedFormTest {

    @Test
    public void set1(){
        int[] arr = new int[]{5,20,1,22,16};
        new ConvertArrayToReducedForm().solve(arr);
        assertArrayEquals(new int[]{1,3,0,4,2}, arr);
    }

    @Test
    public void set2(){
        int[] arr = new int[]{5, 10, 40, 30, 20};
        new ConvertArrayToReducedForm().solve(arr);
        assertArrayEquals(new int[]{0,1,4,3,2}, arr);
    }


}