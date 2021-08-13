from unittest import TestCase

from medium.algorithm.compare_version_numbers import Solution


class TestSolution(TestCase):
    def test_compare_version(self):
        solution = Solution()
        self.assertEqual(0, solution.compareVersion(version1="1.1", version2="1.1"))
        self.assertEqual(0, solution.compareVersion(version1="1.1", version2="1.1.0"))
        self.assertEqual(1, solution.compareVersion(version1="1.1.1", version2="1.1.0"))
        self.assertEqual(1, solution.compareVersion(version1="1.1.1", version2="1.1.."))
        self.assertEqual(-1, solution.compareVersion(version1="1.1.1", version2="1.1.1.....2"))
        self.assertEqual(0, solution.compareVersion(version1="1.1.1", version2="1.1.0000001"))
