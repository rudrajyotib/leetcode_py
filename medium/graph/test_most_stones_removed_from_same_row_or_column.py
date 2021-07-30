from unittest import TestCase

from medium.graph.most_stones_removed_from_same_row_or_column import Solution


class TestSolution(TestCase):
    def test_remove_stones(self):
        solution = Solution()
        self.assertEqual(5, solution.removeStones(stones=[[0, 0], [0, 1], [1, 0], [1, 2], [2, 1], [2, 2]]))
        self.assertEqual(3, solution.removeStones(stones=[[0, 0], [0, 2], [1, 1], [2, 0], [2, 2]]))
        self.assertEqual(0, solution.removeStones(stones=[[0, 0]]))
        self.assertEqual(4, solution.removeStones(stones=[[0, 1], [0, 2], [4, 3], [2, 4], [0, 3], [1, 1]]))
        self.assertEqual(11, solution.removeStones(stones=[[0, 0],
                                                           [0, 7],
                                                           [0, 3],
                                                           [3, 3],
                                                           [5, 3],
                                                           [0, 2],
                                                           [1, 4],
                                                           [3, 2],
                                                           [3, 7],
                                                           [4, 4],
                                                           [7, 4],
                                                           [3, 4]
                                                           ]))
