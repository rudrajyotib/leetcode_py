from unittest import TestCase

from medium.algorithm.multiply_strings import Solution


class TestSolution(TestCase):
    def test_multiply(self):
        solution = Solution()
        self.assertEqual("6", solution.multiply(num1="3", num2="2"))
        self.assertEqual("0", solution.multiply(num1="3", num2="0"))
        self.assertEqual("3000", solution.multiply(num1="3", num2="1000"))
        self.assertEqual("156", solution.multiply(num1="13", num2="12"))
        self.assertEqual("15600", solution.multiply(num1="13", num2="1200"))
        self.assertEqual("56088", solution.multiply(num1="123", num2="456"))
        self.assertEqual("309504172465880184646976372791072", solution.multiply(num1="1872767637656536", num2="165265656156454252"))
