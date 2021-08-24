from unittest import TestCase

from medium.algorithm.longest_repeating_character_replacement import LongestRepeatingCharacterReplacement


class TestLongestRepeatingCharacterReplacement(TestCase):
    def test_solve(self):
        solver = LongestRepeatingCharacterReplacement()
        self.assertEqual(4, solver.solve("AABBCC",2))
        self.assertEqual(5, solver.solve("AABABBA", 2))
        self.assertEqual(4, solver.solve("AABABBA", 1))
        self.assertEqual(7, solver.solve("AABABBA", 10))
        self.assertEqual(7, solver.solve("CCCCCCC", 10))
        self.assertEqual(2, solver.solve("ABAA", 0))
        self.assertEqual(1, solver.solve("A", 10))
