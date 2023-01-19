package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstElementToAppearKTimesTest {

    @Test
    public void set1(){
        assertEquals(3, new FirstElementToAppearKTimes().solve(new int[]{1,1,2,3,3,4,5,3,1}, 3 ));
    }

    @Test
    public void set2(){
        assertEquals(-1, new FirstElementToAppearKTimes().solve(new int[]{1,1,2,3,3,4,5,3,1}, 4 ));
    }

}