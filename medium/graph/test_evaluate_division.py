from unittest import TestCase

from medium.graph.evaluate_division import Solution


class TestSolution(TestCase):
    def test_calc_equation_set1(self):
        solution = Solution()
        queries = [['a', 'c'], ['c', 'a'], ['a', 'd'], ['a', 'a'], ['a', 'e']]
        result = solution.calcEquation(equations=[['a', 'b'], ['b', 'c'], ['c', 'd']],
                                       values=[1, 0.5, 0.25],
                                       queries=queries)
        self.assertEqual(len(queries), len(result))
        self.assertEqual([0.5, 2, 0.125, 1, -1], result)

    def test_calc_equation_set2(self):
        solution = Solution()
        queries = [['b', 'd']]
        result = solution.calcEquation(equations=[['a', 'b'], ['b', 'c'], ['c', 'd'], ['d', 'e']],
                                       values=[3.0, 4.0, 5.0, 6.0],
                                       queries=queries)
        self.assertEqual(len(queries), len(result))
        self.assertEqual([20.0], result)
