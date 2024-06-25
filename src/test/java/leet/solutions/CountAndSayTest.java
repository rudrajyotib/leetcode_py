package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountAndSayTest {

    @Test
    public void testCase1(){
        assertEquals("1211", new CountAndSay().solve(4));
        assertEquals("1", new CountAndSay().solve(1));
        assertEquals("11", new CountAndSay().solve(2));
    }

}