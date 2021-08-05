from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        longest_subsequence = [1] * len(nums)

        if len(nums) == 1:
            return 1

        def find_max_longest_subsequence_for_a_smaller_or_equal_val(limit: int) -> int:
            max_lis_with_smaller_val = 0
            max_lis_with_equal_val = 0
            for i in range(0, limit, 1):
                if nums[i] < nums[limit]:
                    if longest_subsequence[i] > max_lis_with_smaller_val:
                        max_lis_with_smaller_val = longest_subsequence[i]
                elif nums[i] == nums[limit]:
                    if longest_subsequence[i] > max_lis_with_equal_val:
                        max_lis_with_equal_val = longest_subsequence[i]
            return max(max_lis_with_equal_val - 1, max_lis_with_smaller_val)

        for index in range(1, len(nums), 1):
            longest_subsequence[index] = 1 + find_max_longest_subsequence_for_a_smaller_or_equal_val(index)

        return max(longest_subsequence)
