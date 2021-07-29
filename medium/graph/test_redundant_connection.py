from unittest import TestCase

from medium.graph.redundant_connection import Solution


class TestSolution(TestCase):
    def test_find_redundant_connection(self):
        solution = Solution()
        self.assertEqual([3, 4],
                         solution.findRedundantConnection(edges=[[0, 1],
                                                                 [0, 2],
                                                                 [1, 3],
                                                                 [1, 4],
                                                                 [3, 4],
                                                                 [2, 5],
                                                                 [5, 6],
                                                                 [5, 7]]))

