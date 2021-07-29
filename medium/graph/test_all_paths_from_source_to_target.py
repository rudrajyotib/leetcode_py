from unittest import TestCase

from medium.graph.all_paths_from_source_to_target import Solution


class TestSolution(TestCase):
    def test_all_paths_source_target_set1(self):
        solution = Solution()
        result = solution.allPathsSourceTarget(graph=[[1, 2],
                                                      [3, 5],
                                                      [3, 4, 6],
                                                      [5],
                                                      [5, 6],
                                                      [],
                                                      []])
        self.assertEqual(2, len(result))
        self.assertTrue([0, 2, 4, 6] in result)

    def test_all_paths_source_target_set2(self):
        solution = Solution()
        result = solution.allPathsSourceTarget(graph=[[1, 2],
                                                      [2],
                                                      []])
        self.assertEqual(2, len(result))
        self.assertTrue([0, 2] in result)
        self.assertTrue([0, 1, 2] in result)
