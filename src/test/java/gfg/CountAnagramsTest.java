package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountAnagramsTest {

    @Test
    public void testCase1(){
        assertEquals(3, new CountAnagrams().search("for", "forxxorfxdofr"));
    }


}