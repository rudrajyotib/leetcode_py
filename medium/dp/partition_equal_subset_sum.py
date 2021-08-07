from typing import List


class Solution:
    partition_found = False

    def canPartition(self, nums: List[int]) -> bool:

        if len(nums) == 1:
            return False
        Solution.partition_found = False

        total = sum(nums)
        if total % 2 == 1:
            return False

        target = total // 2

        sorted_nums = sorted(nums)
        if sorted_nums[-1] > target:
            return False

        def check_if_half_filled_recursive(current_index: int, deficit: int):
            if Solution.partition_found:
                return
            if current_index == len(nums):
                return
            deficit = deficit - sorted_nums[current_index]
            if deficit < 0:
                return
            if deficit == 0:
                Solution.partition_found = True
                return
            for index in range(current_index + 1, len(nums) - 1, 1):
                check_if_half_filled_recursive(current_index=index, deficit=deficit)

        for i in range(0, len(nums), 1):
            if not Solution.partition_found:
                check_if_half_filled_recursive(current_index=i, deficit=target)

        return Solution.partition_found
