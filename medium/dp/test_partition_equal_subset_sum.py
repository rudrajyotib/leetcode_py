from unittest import TestCase

from medium.dp.partition_equal_subset_sum import Solution


class TestSolution(TestCase):
    def test_can_partition(self):
        solution = Solution()
        self.assertTrue(solution.canPartition(nums=[2, 4, 6, 8]))
        self.assertTrue(solution.canPartition(nums=[1, 5, 5, 11]))
        self.assertFalse(solution.canPartition(nums=[1, 5, 5, 15]))
        self.assertFalse(solution.canPartition(nums=[1]))
        self.assertFalse(solution.canPartition(nums=[1, 3, 5]))
        self.assertTrue(solution.canPartition(nums=[1, 3, 5, 2 ,7]))
        self.assertFalse(solution.canPartition(nums=[1, 3, 5, 2 ,107]))
