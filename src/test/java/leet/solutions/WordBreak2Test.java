package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordBreak2Test {

    @Test
    public void shouldIdentifyAllDistinctStringsWithoutReuse(){
        List<String> allSentences = new WordBreak2().solve("applemangopen", List.of(
                "apple","man", "mango", "pet", "pen"
        ));
        assertEquals(1, allSentences.size());
        assertEquals("apple mango pen", allSentences.get(0));
    }

    @Test
    public void shouldIdentifyAllDistinctStringsWithReuse(){
        List<String> allSentences = new WordBreak2().solve("pineapplepenapple", List.of(
                "apple","pen","applepen","pine","pineapple"
        ));
        assertEquals(3, allSentences.size());
        assertTrue(allSentences.contains("pine apple pen apple"));
        assertTrue(allSentences.contains("pineapple pen apple"));
        assertTrue(allSentences.contains("pine applepen apple"));
    }


    @Test
    public void shouldReturnEmptyListWhenNothingMatches(){
        List<String> allSentences = new WordBreak2().solve("somethingdoesnotexist", List.of(
                "apple","man", "mango", "pet", "pen"
        ));
        assertEquals(0, allSentences.size());
    }

}