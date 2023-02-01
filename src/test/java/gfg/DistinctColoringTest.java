package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctColoringTest {

    @Test
    public void set1(){
        assertEquals(4, new DistinctColoring().solve(
                3, new int[]{1,1,1}, new int[]{2,2,2}, new int[]{3,3,3}
        ));
    }

    @Test
    public void set2(){
        assertEquals(3, new DistinctColoring().solve(
                3, new int[]{2,1,3}, new int[]{3,2,1}, new int[]{1,3,2}
        ));
    }


}