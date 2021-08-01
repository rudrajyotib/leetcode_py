from unittest import TestCase

from medium.graph.minimum_number_of_vertices_to_reach_node import Solution


class TestSolution(TestCase):
    def test_find_smallest_set_of_vertices(self):
        solution = Solution()
        self.assertEqual([0, 3],
                         solution.findSmallestSetOfVertices(n=6, edges=[[0, 1], [1, 2], [3, 2], [2, 4], [2, 5]]))
