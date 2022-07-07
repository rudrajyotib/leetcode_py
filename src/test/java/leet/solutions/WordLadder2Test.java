package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordLadder2Test {
    @Test
    public void shouldFindDistanceWhenSinglePossiblePathExists() {
        List<List<String>> paths = new WordLadder2().solve(
                "cat", "dog", List.of("cat", "cot", "cog", "dog")
        );
        assertEquals(1, paths.size());
        assertEquals(4, paths.get(0).size());
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExist() {
        List<List<String>> paths = new WordLadder2().solve(
                "cat", "dog", List.of("cat", "cot", "cut", "put", "pot", "cog", "dog")
        );
        assertEquals(1, paths.size());
        assertEquals(4, paths.get(0).size());
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExistSet2() {
        List<List<String>> paths = new WordLadder2().solve(
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")
        );
        assertEquals(2, paths.size());
        assertEquals(5, paths.get(0).size());
        assertTrue(paths.stream().allMatch(strings -> (strings.contains("dog") || strings.contains("log"))
                && !strings.containsAll(List.of("dog", "log"))));
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExistSet3() {
        List<List<String>> paths = new WordLadder2().solve(
                "red", "tax", List.of("ted","tex","red","tax","tad","den","rex","pee")
        );
        assertEquals(3, paths.size());
        assertEquals(4, paths.get(0).size());

    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExistFromEndWord() {
        List<List<String>> paths = new WordLadder2().solve(
                "cat", "dog", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        );
        assertEquals(1, paths.size());
        assertEquals(4, paths.get(0).size());
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExistFromEndWordAndBeginWordIsNotPartOfList() {
        List<List<String>> paths = new WordLadder2().solve(
                "bat", "dog", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        );
        assertEquals(1, paths.size());
        assertEquals(5, paths.get(0).size());
    }


    @Test
    public void shouldReportWhenNoPathsFromPossibleFromBeginWord() {
        List<List<String>> paths = new WordLadder2().solve(
                "bxt", "dog", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        );
        assertEquals(0, paths.size());
    }

    @Test
    public void shouldReportWhenPathDoesNotExistTillEndWord() {
        List<List<String>> paths = new WordLadder2().solve(
                "bat", "dog", List.of("cat", "cot", "put", "pog", "cug", "dog")
        );
        assertEquals(0, paths.size());
    }

    @Test
    public void shouldReportWhenNoPathsFromPossibleToEndWord() {
        List<List<String>> paths = new WordLadder2().solve(
                "bat", "log", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        );
        assertEquals(0, paths.size());
    }

    @Test
    public void shouldReportWhenListHasOneElement() {
        List<List<String>> paths = new WordLadder2().solve(
                "bat", "log", List.of("cat")
        );
        assertEquals(0, paths.size());
    }

    @Test
    public void shouldReportWhenListHasOnlyBeginWord() {
        List<List<String>> paths = new WordLadder2().solve(
                "bat", "log", List.of("bat")
        );
        assertEquals(0, paths.size());
    }

    @Test
    public void shouldReportWhenListHasOnlyEndWord() {
        List<List<String>> paths = new WordLadder2().solve(
                "bat", "log", List.of("log")
        );
        assertEquals(0, paths.size());
    }
}