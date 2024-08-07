package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToEnglishWordTest {

    @Test
    public void testCase1(){
        Object[][] tests = new Object[][]{
                new Object[]{0, "Zero"},
                new Object[]{1, "One"},
                new Object[]{11, "Eleven"},
                new Object[]{100, "One Hundred"},
                new Object[]{101, "One Hundred One"},
                new Object[]{1001, "One Thousand One"},
                new Object[]{10001, "Ten Thousand One"},
                new Object[]{10101, "Ten Thousand One Hundred One"},
                new Object[]{100101, "One Hundred Thousand One Hundred One"},
                new Object[]{1000101, "One Million One Hundred One"},
                new Object[]{1001000101, "One Billion One Million One Hundred One"},
                new Object[]{1000000000, "One Billion"},
                new Object[]{1000000001, "One Billion One"},
                new Object[]{10, "Ten"},
                new Object[]{90, "Ninety"},
        };
        for (Object[] t : tests) {
            assertEquals(t[1], new IntegerToEnglishWord().solve((int)t[0]));
        }
    }

}