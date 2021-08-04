from typing import List, Tuple


class Solution:
    def maxProduct(self, nums: List[int]) -> int:

        max_prod_array: List[Tuple] = [(0 if nums[0] < 0 else nums[0], 0 if nums[0] > 0 else nums[0])]

        max_prod = nums[0]

        for index in range(1, len(nums), 1):
            if nums[index] == 0:
                if max_prod < 0:
                    max_prod = 0
                max_prod_array.append((0, 0))
                continue
            positive_value = max_prod_array[index - 1][0] * nums[index]
            negative_value = max_prod_array[index - 1][1] * nums[index]
            if nums[index] < 0:
                max_prod_array.append((negative_value, min(positive_value, nums[index])))
            else:
                max_prod_array.append((max(nums[index], positive_value), negative_value))
            max_prod = max(positive_value, negative_value, max_prod, nums[index])

        return max_prod
