from unittest import TestCase

from medium.dp.word_break import Solution


class TestSolution(TestCase):

    def test_word_found(self):
        solution = Solution()
        dictionary = ["leet", "code"]
        self.assertTrue(solution.wordBreak(s="leetcode", wordDict=dictionary))
        self.assertFalse(solution.wordBreak(s="leetacode", wordDict=dictionary))
        self.assertTrue(solution.wordBreak(s="leetleetleet", wordDict=dictionary))
        self.assertFalse(solution.wordBreak(s="leetleetleetaleetleetleetleet", wordDict=dictionary))
        self.assertTrue(solution.wordBreak(s="leetcodecodeleet", wordDict=dictionary))
        self.assertFalse(solution.wordBreak(s="leetcodecodeleetcole", wordDict=dictionary))
        self.assertFalse(solution.wordBreak(
            s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            wordDict=["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"]))
        self.assertTrue(solution.wordBreak(s="a", wordDict=["a", "b"]))
        self.assertTrue(solution.wordBreak(s="abc", wordDict=["a", "b", "c"]))
        self.assertTrue(solution.wordBreak(s="ab", wordDict=["a", "b", "c"]))
        self.assertTrue(solution.wordBreak(s="aaaaaaabbb", wordDict=["a", "b", "c"]))
        self.assertFalse(solution.wordBreak(
            s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            , wordDict=["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"]))
