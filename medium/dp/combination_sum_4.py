from typing import List


class Solution:
    memory: List[int] = []

    # noinspection PyMethodMayBeStatic
    def combinationSum4(self, nums: List[int], target: int) -> int:

        if len(nums) == 1:
            if target % nums[0] == 0:
                return 1
            else:
                return 0

        Solution.memory = [-1 for _ in range(0, target + 1)]

        def reach_target_recursive(revised_target: int) -> int:
            if revised_target == 0:
                return 1
            if revised_target < 1:
                return 0
            if Solution.memory[revised_target] != -1:
                return Solution.memory[revised_target]
            combinations = 0
            for num in nums:
                combinations += reach_target_recursive(revised_target=revised_target - num)
            Solution.memory[revised_target] = combinations
            return combinations

        reach_target_recursive(revised_target=target)

        return Solution.memory[target]
