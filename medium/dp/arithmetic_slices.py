from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:

        if len(nums) < 3:
            return 0

        last_difference = nums[1] - nums[0]
        last_series_length = 1
        ap_count = 0

        for i in range(2, len(nums), 1):
            diff = nums[i] - nums[i - 1]
            if diff == last_difference and last_series_length >= 1:
                last_series_length += 1
                ap_count += last_series_length -1
            elif diff != last_difference:
                last_difference = diff
                last_series_length = 1

        return ap_count
