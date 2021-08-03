"""
Greedy solution over DP
Concept : https://www.youtube.com/watch?v=dJ7sWiOoK7g
"""


from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def jump(self, nums: List[int]) -> int:
        result = 0
        left = right = 0
        while right < len(nums) - 1:
            farthest = 0
            for index in range(left, right + 1):
                farthest = max(farthest, index + nums[index])
            left = right + 1
            right = farthest
            result += 1

        return result
