package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void shouldPerformDictionaryOperations()
    {
        Trie trie = new Trie();
        assertFalse(trie.search("apple"));
        trie.insert("apple");
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("appl"));
        assertTrue(trie.startsWith("a"));
        trie.insert("appl");
        assertTrue(trie.search("appl"));
    }


}