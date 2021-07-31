from unittest import TestCase

from medium.graph.operations_to_make_network_connected import Solution


class TestSolution(TestCase):
    def test_make_connected_set1(self):
        solution = Solution()
        result = solution.makeConnected(5, [[0, 1], [1, 2], [2, 3], [3, 4]])
        self.assertEqual(0, result)

    def test_make_connected_set2(self):
        solution = Solution()
        result = solution.makeConnected(5, [[0, 1], [2, 3], [3, 4]])
        self.assertEqual(-1, result)

    def test_make_connected_set3(self):
        solution = Solution()
        result = solution.makeConnected(5, [[0, 1], [2, 3], [2, 4], [3, 4]])
        self.assertEqual(1, result)

    def test_make_connected_set4(self):
        solution = Solution()
        result = solution.makeConnected(5, [[0, 1], [2, 3], [1, 4], [3, 4]])
        self.assertEqual(0, result)

    def test_make_connected_set5(self):
        solution = Solution()
        result = solution.makeConnected(10, [[0, 1], [2, 3], [1, 4], [2, 4], [3, 4], [5, 6], [7, 8], [7, 9], [8, 9]])
        self.assertEqual(2, result)

    def test_make_connected_set6(self):
        solution = Solution()
        result = solution.makeConnected(10, [[0, 1], [2, 3], [2, 4], [3, 4], [5, 6], [7, 8], [7, 9], [8, 9]])
        self.assertEqual(-1, result)

    def test_make_connected_set7(self):
        solution = Solution()
        result = solution.makeConnected(10, [[0, 1], [2, 3], [2, 4], [3, 4], [5, 9], [5, 6], [7, 8], [7, 9], [8, 9]])
        self.assertEqual(2, result)

    def test_make_connected_set8(self):
        solution = Solution()
        result = solution.makeConnected(10,
                                        [[0, 1], [2, 3], [1, 4], [2, 4], [3, 4], [4, 9], [5, 9], [5, 6], [7, 8], [7, 9],
                                         [8, 9]])
        self.assertEqual(0, result)
