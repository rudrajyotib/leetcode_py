from unittest import TestCase

from medium.graph.satisfiability_of_equality_equations import Solution


class TestSolution(TestCase):
    def test_equations_possible(self):
        solution = Solution()
        self.assertTrue(solution.equationsPossible(equations=["a==b", "b==c", "c==d"]))
        self.assertTrue(solution.equationsPossible(equations=["a==b", "b==c", "d==e", "e==f", "d==f"]))
        self.assertTrue(solution.equationsPossible(equations=["a==b", "b==c", "d==e", "e==f", "d==a"]))
        self.assertTrue(solution.equationsPossible(equations=["a==a", "b==c", "a==c"]))
        self.assertFalse(solution.equationsPossible(equations=["a==a", "b==c", "a==c", "b==d", "a!=d"]))
        self.assertTrue(solution.equationsPossible(equations=["a==a", "b==c", "a==c", "b==d", "x!=y"]))
        self.assertTrue(solution.equationsPossible(equations=["a==a", "b==c", "x!=y"]))
        self.assertTrue(solution.equationsPossible(equations=["a==a", "b==c", "x!=c"]))
        self.assertFalse(solution.equationsPossible(equations=["a!=a"]))
