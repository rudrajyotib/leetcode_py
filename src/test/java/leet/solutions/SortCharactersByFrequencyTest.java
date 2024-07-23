package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortCharactersByFrequencyTest {

    @Test
    public void testCase1(){
        assertEquals("eert", new SortCharactersByFrequency().solve("tree"));
        assertEquals("eeee", new SortCharactersByFrequency().solve("eeee"));
        assertEquals("eeeeEEE", new SortCharactersByFrequency().solve("eeeeEEE"));
        assertEquals("666664444AAAaa", new SortCharactersByFrequency().solve("aaAAA444466666"));
    }

}