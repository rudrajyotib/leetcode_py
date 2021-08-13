from unittest import TestCase

from medium.algorithm.simplify_path import Solution


class TestSolution(TestCase):
    def test_simplify_path(self):
        solution = Solution()
        self.assertEqual("/c", solution.simplifyPath(path="/a/./b/../../c/"))
        self.assertEqual("/home/foo", solution.simplifyPath(path="/home//foo/"))
        self.assertEqual("/", solution.simplifyPath(path="//////////////////"))
        self.assertEqual("/...", solution.simplifyPath(path="/////////.../////////"))
