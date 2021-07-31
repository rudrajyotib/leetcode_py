from unittest import TestCase

from medium.graph.city_with_smallest_number_of_neigbours import Solution


class TestSolution(TestCase):
    def test_find_the_city(self):
        solution = Solution()
        self.assertEqual(0, solution.findTheCity(n=5, edges=[[0, 1, 2], [0, 4, 8], [1, 2, 3], [1, 4, 2], [2, 3, 1],
                                                             [3, 4, 1]], distanceThreshold=2))
        self.assertEqual(3, solution.findTheCity(n=4, edges=[[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]],
                                                 distanceThreshold=4))
