package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordLadderTest {


    @Test
    public void shouldFindDistanceWhenSinglePossiblePathExists() {
        assertEquals(4, new WordLadder().solve(
                "cat", "dog", List.of("cat", "cot", "cog", "dog")
        ));
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExist() {
        assertEquals(4, new WordLadder().solve(
                "cat", "dog", List.of("cat", "cot", "cut", "put", "pot", "cog", "dog")
        ));
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExistSet2() {
        assertEquals(5, new WordLadder().solve(
                "hit", "cog", List.of("hot","dot","dog","lot","log","cog")
        ));
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExistFromEndWord() {
        assertEquals(4, new WordLadder().solve(
                "cat", "dog", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        ));
    }

    @Test
    public void shouldFindDistanceWhenMultiplePossiblePathsExistFromEndWordAndBeginWordIsNotPartOfList() {
        assertEquals(5, new WordLadder().solve(
                "bat", "dog", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        ));
    }


    @Test
    public void shouldReportWhenNoPathsFromPossibleFromBeginWord() {
        assertEquals(0, new WordLadder().solve(
                "bxt", "dog", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        ));
    }

    @Test
    public void shouldReportWhenNoPathsFromPossibleToEndWord() {
        assertEquals(0, new WordLadder().solve(
                "bat", "log", List.of("cat", "cot", "cut", "put", "pog", "pot", "cot", "cog", "dog")
        ));
    }

    @Test
    public void shouldReportWhenListHasOneElement() {
        assertEquals(0, new WordLadder().solve(
                "bat", "log", List.of("cat")
        ));
    }

    @Test
    public void shouldReportWhenListHasOnlyBeginWord() {
        assertEquals(0, new WordLadder().solve(
                "bat", "log", List.of("bat")
        ));
    }

    @Test
    public void shouldReportWhenListHasOnlyEndWord() {
        assertEquals(0, new WordLadder().solve(
                "bat", "log", List.of("log")
        ));
    }


}