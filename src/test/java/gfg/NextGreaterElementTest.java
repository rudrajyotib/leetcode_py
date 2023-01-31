package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextGreaterElementTest {

    @Test
    public void set1(){
        assertArrayEquals(new long[]{8L, -1L, 1L, 3L, -1L}, new NextGreaterElement().solve(
                new long[]{6,8,0,1,3}
        ));
    }

    @Test
    public void set2(){
        assertArrayEquals(new long[]{-1,-1,-1,-1,-1}, new NextGreaterElement().solve(
                new long[]{6,5,4,3,2}
        ));
    }

    @Test
    public void set3(){
        assertArrayEquals(new long[]{3, 4, 4, -1}, new NextGreaterElement().solve(
                new long[]{1 ,3 ,2, 4}
        ));
    }


}