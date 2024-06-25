package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    @Test
    public void testCase1(){
        String text = "abbbbbbbbbbbbcccde";
        char[] input = text.toCharArray();
        assertEquals(8, new StringCompression().solve(input));
        assertEquals("ab12c3de", new String(input).substring(0, 8));
    }

    @Test
    public void testCase2(){
        String text = "aaaabbbbbbbbbbbbcccde";
        char[] input = text.toCharArray();
        assertEquals(9, new StringCompression().solve(input));
        assertEquals("a4b12c3de", new String(input).substring(0, 9));
    }

    @Test
    public void testCase3(){
        String text = "aaaabbbbbbbbbbbbcccdddeee";
        char[] input = text.toCharArray();
        assertEquals(11, new StringCompression().solve(input));
        assertEquals("a4b12c3d3e3", new String(input).substring(0, 11));
    }

    @Test
    public void testCase4(){
        String text = "a";
        char[] input = text.toCharArray();
        assertEquals(1, new StringCompression().solve(input));
        assertEquals("a", new String(input).substring(0, 1));
    }

    @Test
    public void testCase5(){
        String text = "aaaa";
        char[] input = text.toCharArray();
        assertEquals(2, new StringCompression().solve(input));
        assertEquals("a4", new String(input).substring(0, 2));
    }

}