from unittest import TestCase

from medium.algorithm.restore_ip_addresses import Solution


class TestSolution(TestCase):
    def test_resolve(self):
        solution = Solution()
        self.assertEqual(0, len(solution.restoreIpAddresses(s="11111111111111111111111111111111111111111111")))
        self.assertEqual(2, len(solution.restoreIpAddresses(s="25525511135")))
        self.assertEqual(1, len(solution.restoreIpAddresses(s="1111")))
        self.assertEqual(4, len(solution.restoreIpAddresses(s="11110")))
        self.assertEqual(3, len(solution.restoreIpAddresses(s="10111")))
        self.assertEqual(2, len(solution.restoreIpAddresses(s="010010")))
