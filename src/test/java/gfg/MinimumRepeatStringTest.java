package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumRepeatStringTest {

    @Test
    public void set1(){
        assertEquals(3, new MinimumRepeatString().solve("aaa","aaaaaaaaa"));
        assertEquals(3, new MinimumRepeatString().solve("acxd","cxdacxdacxd"));
        assertEquals(4, new MinimumRepeatString().solve("acxd","cxdacxdacxda"));
        assertEquals(-1, new MinimumRepeatString().solve("acxd","xcdacxdacxda"));
    }


}