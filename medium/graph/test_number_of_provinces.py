from unittest import TestCase

from medium.graph.number_of_provinces import Solution


class TestSolution(TestCase):
    def test_find_circle_num_set1(self):
        solution = Solution()
        result = solution.findCircleNum(isConnected=[[1, 0, 0, 0],
                                                     [0, 1, 0, 0],
                                                     [0, 0, 1, 0],
                                                     [0, 0, 0, 1]])
        self.assertEqual(4, result)

    def test_find_circle_num_set2(self):
        solution = Solution()
        result = solution.findCircleNum(isConnected=[[1, 1, 0, 0],
                                                     [1, 1, 0, 0],
                                                     [0, 0, 1, 0],
                                                     [0, 0, 0, 1]])
        self.assertEqual(3, result)

    def test_find_circle_num_set3(self):
        solution = Solution()
        result = solution.findCircleNum(isConnected=[[1, 0, 0, 0],
                                                     [0, 1, 0, 1],
                                                     [0, 0, 0, 0],
                                                     [0, 1, 0, 1]])
        self.assertEqual(2, result)

    def test_find_circle_num_set4(self):
        solution = Solution()
        result = solution.findCircleNum(isConnected=[[1]])
        self.assertEqual(1, result)

    def test_find_circle_num_set5(self):
        solution = Solution()
        result = solution.findCircleNum(isConnected=[[1, 0, 0, 1],
                                                     [0, 1, 1, 0],
                                                     [0, 1, 1, 1],
                                                     [1, 0, 1, 1]])
        self.assertEqual(1, result)
