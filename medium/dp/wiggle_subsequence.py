from typing import List, Tuple


class Solution:
    # noinspection PyMethodMayBeStatic
    def wiggleMaxLength(self, nums: List[int]) -> int:
        length = len(nums)
        derivation: List[Tuple] = [(1, 1) for _ in range(0, len(nums))]
        for index in range(1, length, 1):
            if nums[index] > nums[index - 1]:
                derivation[index] = (derivation[index - 1][1] + 1, derivation[index - 1][1])
            elif nums[index] < nums[index - 1]:
                derivation[index] = (derivation[index - 1][0], derivation[index - 1][0] + 1)
            else:
                derivation[index] = derivation[index-1]

        return max(derivation[length - 1])
