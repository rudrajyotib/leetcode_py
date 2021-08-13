from unittest import TestCase

from medium.algorithm.repeated_dna_sequence import Solution


class TestSolution(TestCase):
    def test_find_repeated_dna_sequences(self):
        solution = Solution()
        self.assertEqual(10, len(solution.findRepeatedDnaSequences(s="AAAAAAAAACAAAAAAAAACAAAAAAAAAC")))
