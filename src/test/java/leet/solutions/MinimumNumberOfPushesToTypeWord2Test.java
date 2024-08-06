package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumNumberOfPushesToTypeWord2Test {

    @Test
    public void testCase1(){
        assertEquals(5, new MinimumNumberOfPushesToTypeWord2().solve("abcde"));
        assertEquals(11, new MinimumNumberOfPushesToTypeWord2().solve("abcdefghhi"));
        assertEquals(12, new MinimumNumberOfPushesToTypeWord2().solve("xyzxyzxyzxyz"));
        assertEquals(24, new MinimumNumberOfPushesToTypeWord2().solve("aabbccddeeffgghhiiiiii"));
    }

}