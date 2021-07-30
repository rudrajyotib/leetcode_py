from unittest import TestCase

from medium.graph.possible_bipartition import Solution


class TestSolution(TestCase):
    def test_check_bipartite_graph_set1(self):
        solution = Solution()
        self.assertTrue(solution.possibleBipartition(n=5, dislikes=[[1, 2],
                                                                    [1, 3],
                                                                    [1, 4],
                                                                    [3, 5],
                                                                    [4, 5]]))

    def test_check_bipartite_graph_set2(self):
        solution = Solution()
        self.assertFalse(solution.possibleBipartition(n=5, dislikes=[[1, 2],
                                                                     [1, 3],
                                                                     [1, 4],
                                                                     [3, 4],
                                                                     [3, 5],
                                                                     [4, 5]]))

    def test_check_bipartite_graph_set3(self):
        solution = Solution()
        self.assertFalse(solution.possibleBipartition(n=5, dislikes=[[1, 2],
                                                                     [2, 3],
                                                                     [3, 4],
                                                                     [4, 5],
                                                                     [1, 5]]))

    def test_check_bipartite_graph_set4(self):
        solution = Solution()
        self.assertTrue(solution.possibleBipartition(n=10, dislikes=[[1, 2],
                                                                     [3, 4],
                                                                     [5, 6],
                                                                     [6, 7],
                                                                     [8, 9],
                                                                     [7, 8]]))
