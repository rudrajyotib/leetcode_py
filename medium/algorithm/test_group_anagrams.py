from unittest import TestCase

from medium.algorithm.group_anagrams import Solution


class TestSolution(TestCase):
    def test_group_anagrams(self):
        solution = Solution()
        self.assertEqual(3, len(solution.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])))
        self.assertEqual(1, len(solution.groupAnagrams([""])))
        self.assertEqual([['']], (solution.groupAnagrams([""])))
        self.assertEqual([['a']], (solution.groupAnagrams(["a"])))
