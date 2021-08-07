from typing import List, Tuple


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        length = len(nums)
        derivation: List[Tuple] = [(1, 1) for _ in range(0, len(nums))]
        for outer_index in range(0, length, 1):
            for inner_index in range(outer_index + 1, length, 1):
                if nums[inner_index] > nums[outer_index]:
                    derivation[inner_index] = (
                        max(derivation[outer_index][1] + 1, derivation[inner_index][0]),
                        derivation[inner_index][1])
                elif nums[inner_index] < nums[outer_index]:
                    derivation[inner_index] = (
                        derivation[inner_index][0],
                        max(derivation[outer_index][0] + 1, derivation[inner_index][1]))

        return max(derivation[length-1])
