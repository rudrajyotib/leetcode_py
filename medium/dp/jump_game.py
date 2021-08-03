"""
Problem 55
"""
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:

        if len(nums) <= 1:
            return True

        for index in range(1, len(nums) - 1):
            if nums[index - 1] < 1:
                return False
            if nums[index] > nums[index - 1] - 1:
                continue
            else:
                nums[index] = nums[index - 1] - 1

        return nums[len(nums) - 2] > 0
