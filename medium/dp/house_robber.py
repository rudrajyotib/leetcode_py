from typing import List


class Solution:

    # noinspection PyMethodMayBeStatic
    def rob(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])

        memory: List[int] = [-1 for _ in range(len(nums))]

        def rob_recursive(start: int, limit: int) -> int:
            if start == limit:
                return nums[start]
            if start > limit:
                return 0
            if memory[start] != -1:
                return memory[start]
            result = nums[start] + max(rob_recursive(start + 2, limit),
                                       rob_recursive(start + 3, limit))
            memory[start] = result
            return result

        return max(rob_recursive(start=0, limit=len(nums) - 1),
                   rob_recursive(start=1, limit=len(nums) - 1))
