"""
Concept video link
https://www.youtube.com/watch?v=jzZsG8n2R9A
"""

from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        if len(nums) < 3:
            return []
        if len(nums) == 3:
            if nums[0] + nums[1] + nums[2] == 0:
                return [nums]
        nums = sorted(nums)
        if nums[0] > 0:
            return []
        result_combination = []
        for index, number in enumerate(nums):
            if index > 0 and nums[index] == nums[index - 1]:
                continue
            left = index + 1
            right = len(nums) - 1
            while left < right:
                result_sum = number + nums[left] + nums[right]
                if result_sum < 0:
                    left += 1
                elif result_sum > 0:
                    right -= 1
                else:
                    result_combination.append([number, nums[left], nums[right]])
                    left += 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
        return result_combination
