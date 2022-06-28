package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakInterviewBit2Test {


    @Test
    public void shouldIdentifyAllDistinctStringsWithoutReuse() {
        List<String> allSentences = new WordBreakInterviewBit2().solve("applemangopen", new ArrayList<>(List.of(
                "apple", "man", "mango", "pet", "pen"
        )));
        assertEquals(1, allSentences.size());
        assertEquals("apple mango pen", allSentences.get(0));
    }

    @Test
    public void shouldIdentifyAllDistinctStringsWithReuse() {
        List<String> allSentences = new WordBreakInterviewBit2().solve("pineapplepenapple", new ArrayList<>(List.of(
                "apple", "pen", "applepen", "pine", "pineapple"
        )));
        assertEquals(3, allSentences.size());
        assertArrayEquals(new String[]{
                "pine apple pen apple",
                "pine applepen apple",
                "pineapple pen apple"

        }, allSentences.toArray(new String[1]));
        assertTrue(allSentences.contains("pine apple pen apple"));
        assertTrue(allSentences.contains("pineapple pen apple"));
        assertTrue(allSentences.contains("pine applepen apple"));
    }


    @Test
    public void shouldReturnEmptyListWhenNothingMatches() {
        List<String> allSentences = new WordBreakInterviewBit2().solve("somethingdoesnotexist", new ArrayList<>(List.of(
                "apple", "man", "mango", "pet", "pen"
        )));
        assertEquals(0, allSentences.size());
    }

}