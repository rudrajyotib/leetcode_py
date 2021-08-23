package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {


    @Test
    public void shouldSearchWord()
    {
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.solve(new char[][]{{'A','P','P'},{'X','X','L'},{'W','R','E'}}, "APPLE"));
        assertFalse(wordSearch.solve(new char[][]{{'A','P','P'},{'X','X','L'},{'W','R','E'}}, "APPLEJUICE"));
        assertTrue(wordSearch.solve(new char[][]{{'X','X','X'},{'X','Y','X'},{'W','R','X'}}, "XXXXXX"));
        assertFalse(wordSearch.solve(new char[][]{{'X'}}, "XXXXXX"));
        assertFalse(wordSearch.solve(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

}