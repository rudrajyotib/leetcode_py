from unittest import TestCase

from medium.graph.find_eventual_safe_states import Solution


class TestSolution(TestCase):
    def test_eventual_safe_nodes_set1(self):
        solution = Solution()
        result = solution.eventualSafeNodes(graph=[[1, 2],
                                                   [3, 7, 2],
                                                   [5],
                                                   [0],
                                                   [5],
                                                   [],
                                                   [],
                                                   []])
        self.assertEqual(5, len(result))
        self.assertEqual([2, 4, 5, 6, 7], result)

    def test_eventual_safe_nodes_set2(self):
        solution = Solution()
        result = solution.eventualSafeNodes(graph=[[],
                                                   [],
                                                   []])
        self.assertEqual(3, len(result))
        self.assertEqual([0, 1, 2], result)

    def test_eventual_safe_nodes_set3(self):
        solution = Solution()
        result = solution.eventualSafeNodes(graph=[[1, 2], [2, 3], [5], [0], [5], [], []])
        self.assertEqual(4, len(result))
        self.assertEqual([2, 4, 5, 6], result)
