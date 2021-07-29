from unittest import TestCase

from medium.graph.network_delay_time import Solution


class TestSolution(TestCase):
    def test_network_delay_time_set1(self):
        solution = Solution()
        result = solution.networkDelayTime(times=[[1, 2, 10],
                                                  [1, 3, 5],
                                                  [2, 4, 6],
                                                  [3, 4, 8],
                                                  [4, 5, 5]], n=5, k=1)
        self.assertEqual(18, result)

    def test_network_delay_time_set2(self):
        solution = Solution()
        result = solution.networkDelayTime(times=[[1, 2, 10],
                                                  [1, 3, 5],
                                                  [2, 4, 6],
                                                  [3, 4, 8],
                                                  [4, 5, 5]], n=15, k=1)
        self.assertEqual(-1, result)

    def test_network_delay_time_set3(self):
        solution = Solution()
        result = solution.networkDelayTime(times=[[1, 2, 1],
                                                  [2, 1, 3]], n=2, k=2)
        self.assertEqual(3, result)

    def test_network_delay_time_set4(self):
        solution = Solution()
        result = solution.networkDelayTime(times=[[1, 2, 10],
                                                  [1, 3, 5],
                                                  [3, 2, 1],
                                                  [2, 4, 2],
                                                  [3, 4, 8],
                                                  [4, 5, 5]], n=5, k=1)
        self.assertEqual(13, result)

    def test_network_delay_time_set5(self):
        solution = Solution()
        result = solution.networkDelayTime(times=[[1, 2, 10],
                                                  [1, 3, 5],
                                                  [3, 2, 1],
                                                  [2, 5, 2],
                                                  [3, 5, 8],
                                                  [5, 6, 5]], n=6, k=1)
        self.assertEqual(-1, result)
