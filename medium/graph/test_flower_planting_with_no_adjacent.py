from unittest import TestCase

from medium.graph.flower_planting_with_no_adjacent import Solution


class TestSolution(TestCase):
    def test_garden_no_adj_set1(self):
        solution = Solution()
        result = solution.gardenNoAdj(n=8,
                                      paths=[[1, 2], [1, 3], [2, 3], [2, 4],
                                             [3, 4], [3, 6], [4, 5], [5, 6], [7, 8]])

        self.assertTrue(result[0] != result[1])
        self.assertTrue(result[0] != result[2])
        self.assertTrue(result[1] != result[2])
        self.assertTrue(result[1] != result[3])
        self.assertTrue(result[2] != result[3])
        self.assertTrue(result[2] != result[5])
        self.assertTrue(result[3] != result[1])
        self.assertTrue(result[3] != result[4])
        self.assertTrue(result[4] != result[5])
        self.assertTrue(result[6] != result[7])

    def test_garden_no_adj_set2(self):
        solution = Solution()
        result = solution.gardenNoAdj(n=8,
                                      paths=[[1, 2], [3, 4], [5, 6]])

        self.assertTrue(result[0] != result[1])
        self.assertTrue(result[3] != result[2])
        self.assertTrue(result[4] != result[5])

    def test_garden_no_adj_set3(self):
        solution = Solution()
        result = solution.gardenNoAdj(n=6,
                                      paths=[[1, 2], [1, 3], [2, 4], [3, 4], [3, 5], [5, 6]])

        self.assertTrue(result[0] != result[1])
        self.assertTrue(result[0] != result[2])
        self.assertTrue(result[1] != result[3])
        self.assertTrue(result[2] != result[4])
        self.assertTrue(result[2] != result[4])
        self.assertTrue(result[4] != result[5])

    def test_garden_no_adj_set4(self):
        solution = Solution()
        result = solution.gardenNoAdj(n=6,
                                      paths=[[1, 2], [1, 3], [1, 6], [2, 5], [6, 5], [5, 4], [6, 4]])

        self.assertTrue(result[0] != result[1])
        self.assertTrue(result[0] != result[2])
        self.assertTrue(result[0] != result[5])
        self.assertTrue(result[1] != result[4])
        self.assertTrue(result[1] != result[3])
        self.assertTrue(result[4] != result[5])
        self.assertTrue(result[3] != result[4])
