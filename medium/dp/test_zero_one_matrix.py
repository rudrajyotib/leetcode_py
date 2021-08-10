from unittest import TestCase

from medium.dp.zero_one_matrix import Solution


class TestSolution(TestCase):
    def test_update_matrix(self):
        solution = Solution()
        self.assertEqual([[0, 0, 0], [0, 1, 0], [1, 2, 1]],
                         solution.updateMatrix(mat=[[0, 0, 0], [0, 1, 0], [1, 1, 1]]))
        self.assertEqual([[0]], solution.updateMatrix(mat=[[0]]))
        self.assertEqual([[2, 1, 2, 3, 3, 2], [1, 0, 1, 2, 2, 1], [2, 1, 2, 2, 1, 0], [3, 2, 3, 3, 2, 1]],
                         solution.updateMatrix(mat=[[1, 1, 1, 1, 1, 1],
                                                    [1, 0, 1, 1, 1, 1],
                                                    [1, 1, 1, 1, 1, 0],
                                                    [1, 1, 1, 1, 1, 1]]))
