package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordSearch2Test {

    @Test
    public void shouldAddAndSearchInDictionary() {
        WordSearch2.Dictionary dictionary = new WordSearch2.Dictionary();
        dictionary.addWord("eat");
        dictionary.addWord("bat");
        dictionary.addWord("aaa");
        assertTrue(dictionary.isWordPresent("eat"));
        assertTrue(dictionary.isWordPresent("bat"));
        assertFalse(dictionary.isWordPresent("cat"));
        assertFalse(dictionary.isWordPresent("bate"));
        assertTrue(dictionary.isWordPresent("aaa"));
        assertFalse(dictionary.isWordPresent("aaaa"));


    }

    @Test
    public void shouldFindDataInGridSet1() {
        WordSearch2 wordSearch2 = new WordSearch2();
        List<String> result = wordSearch2.solve(new char[][]{{'a', 'p', 'p'}, {'i', 'r', 'l'}, {'x', 'y', 'e'}}, new String[]{"apple", "air", "axe"});
        assertEquals(2, result.size());
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("air"));
    }


}