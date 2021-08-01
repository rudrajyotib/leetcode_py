from unittest import TestCase

from medium.graph.maximal_network_rank import Solution


class TestSolution(TestCase):
    def test_maximal_network_rank(self):
        solution = Solution()
        self.assertEqual(6, solution.maximalNetworkRank(n=7,
                                                        roads=[[0, 1], [1, 2], [5, 2],
                                                               [2, 3], [2, 6], [2, 4], [3, 4]]))
        self.assertEqual(4, solution.maximalNetworkRank(n=5,
                                                        roads=[[0, 1], [1, 2], [2, 3], [3, 4]]))
