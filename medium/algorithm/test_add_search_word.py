from unittest import TestCase

from medium.algorithm.add_search_word import WordDictionary


class TestWordDictionary(TestCase):
    def test_should_add_search_set1(self):
        dictionary = WordDictionary()
        dictionary.addWord("apple")
        self.assertTrue(dictionary.search("apple"))
        self.assertFalse(dictionary.search("app"))
        self.assertTrue(dictionary.search("app.e"))
        self.assertFalse(dictionary.search("app.f"))
        self.assertFalse(dictionary.search(".f"))
        self.assertTrue(dictionary.search("...le"))
        self.assertFalse(dictionary.search("...lf"))
        dictionary.addWord("a")
        self.assertTrue(dictionary.search("a"))
        self.assertFalse(dictionary.search("b"))

    def test_should_add_search_set2(self):
        dictionary = WordDictionary()
        dictionary.addWord("at")
        dictionary.addWord("and")
        dictionary.addWord("an")
        dictionary.addWord("add")
        self.assertFalse(dictionary.search("a"))
        self.assertFalse(dictionary.search("."))
        self.assertFalse(dictionary.search(".at"))
        dictionary.addWord("bat")
        self.assertTrue(dictionary.search(".at"))
        self.assertTrue(dictionary.search("an."))

        self.assertFalse(dictionary.search("a.d."))
        self.assertFalse(dictionary.search("b."))
        self.assertTrue(dictionary.search("a.d"))
        self.assertFalse(dictionary.search("."))
