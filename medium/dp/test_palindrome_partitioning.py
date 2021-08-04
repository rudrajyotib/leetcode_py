from unittest import TestCase

from medium.dp.palindrome_partitioning import Solution


class TestSolution(TestCase):
    def test_partition_set1(self):
        solution = Solution()
        result = solution.partition(s="abc")
        self.assertEqual(1, len(result))

    def test_partition_set2(self):
        solution = Solution()
        result = solution.partition(s="aabbcc")
        self.assertEqual(4, len(result))

    def test_partition_set3(self):
        solution = Solution()
        result = solution.partition(s="aab")
        self.assertEqual(2, len(result))

    def test_partition_set4(self):
        solution = Solution()
        result = solution.partition(s="a")
        self.assertEqual(1, len(result))
