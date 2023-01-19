package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarpetBoxTest {

    @Test
    public void set1(){
        assertEquals(1, new CarpetBox().solve(8, 13, 6, 10));
    }

    @Test
    public void set2(){
        assertEquals(1, new CarpetBox().solve(4, 8, 3, 10));
    }

    @Test
    public void set3(){
        assertEquals(5, new CarpetBox().solve(10, 12, 2, 2));
    }


}