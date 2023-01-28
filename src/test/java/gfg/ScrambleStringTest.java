package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScrambleStringTest {

    @Test
    public void set1(){
        assertTrue(new ScrambleString().solve("coder","cerdo"));
        assertTrue(new ScrambleString().solve("coder","coedr"));
        assertFalse(new ScrambleString().solve("coder","cdroe"));
    }


}