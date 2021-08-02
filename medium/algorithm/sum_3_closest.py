import math
from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def threeSumClosest(self, nums: List[int], target: int) -> int:

        if len(nums) == 3:
            return nums[0] + nums[1] + nums[2]
        nums = sorted(nums)

        distance_from_target = math.inf
        nearest_sum = 0
        for index, number in enumerate(nums):
            if index > 0 and nums[index] == nums[index - 1]:
                continue
            left = index + 1
            right = len(nums) - 1
            while left < right:
                result_sum = number + nums[left] + nums[right]
                difference = target - result_sum
                if abs(difference) < abs(distance_from_target):
                    distance_from_target = difference
                    nearest_sum = result_sum
                if result_sum < target:
                    left += 1
                elif result_sum > target:
                    right -= 1
                else:
                    return target
        return nearest_sum
