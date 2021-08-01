from unittest import TestCase

from medium.graph.path_with_max_probability import Solution


class TestSolution(TestCase):
    def test_max_probability_set1(self):
        solution = Solution()
        result = solution.maxProbability(4,
                                         edges=[[0, 1], [0, 2], [1, 2], [1, 3], [2, 3]],
                                         succProb=[0.9, 0.8, 0.9, 0.02, 0.01],
                                         start=0, end=3)

        self.assertEqual('0.018', format(result, '.3f'))

    def test_max_probability_set2(self):
        solution = Solution()
        result = solution.maxProbability(6,
                                         edges=[[0, 1], [0, 2], [1, 2], [1, 3], [2, 3]],
                                         succProb=[0.9, 0.8, 0.9, 0.02, 0.01],
                                         start=0, end=6)

        self.assertEqual('0.0', format(result, '.1f'))
