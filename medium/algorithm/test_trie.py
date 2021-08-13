from unittest import TestCase

from medium.algorithm.trie import Trie


class TestTrie(TestCase):
    def test_insert_search(self):
        trie = Trie()
        trie.insert("apple")
        trie.insert("mango")
        self.assertTrue(trie.search("mango"))
        self.assertTrue(trie.search("apple"))
        self.assertTrue(trie.startsWith("app"))
        self.assertFalse(trie.startsWith("jackfruit"))
        trie.insert("jackfruit")
        self.assertTrue(trie.startsWith("jackfruit"))
        self.assertTrue(trie.search("jackfruit"))
        self.assertFalse(trie.search(""))
        self.assertFalse(trie.startsWith("appy"))
        self.assertFalse(trie.search("appy"))
        self.assertFalse(trie.search("jack"))
        self.assertTrue(trie.startsWith("jack"))
