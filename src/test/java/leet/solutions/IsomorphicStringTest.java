package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsomorphicStringTest {

    @Test
    public void testCase1(){
        assertTrue(new IsomorphicString().solve("paper", "title"));
        assertFalse(new IsomorphicString().solve("badc", "baba"));
        assertTrue(new IsomorphicString().solve("egg", "+--"));
        assertFalse(new IsomorphicString().solve("egg", "acd"));
    }

}