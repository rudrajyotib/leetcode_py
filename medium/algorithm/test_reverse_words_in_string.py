from unittest import TestCase

from medium.algorithm.reverse_words_in_string import Solution


class TestSolution(TestCase):
    def test_reverse_words(self):
        solution = Solution()
        self.assertEqual("blue is sky the", solution.reverseWords(s= "the sky is blue"))
        self.assertEqual("world hello", solution.reverseWords(s= "  hello world  "))
        self.assertEqual("111eg", solution.reverseWords(s= "  111eg "))
        self.assertEqual("", solution.reverseWords(s= "   "))
        self.assertEqual("c b a", solution.reverseWords(s= "  a b c "))
