from typing import List, Tuple


class Solution:
    # noinspection PyMethodMayBeStatic
    def rob(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])

        nums_length = len(nums)
        memory: List[Tuple] = [(0, 0) for _ in range(nums_length)]

        memory[nums_length - 1] = (nums[nums_length - 1], 0)
        memory[nums_length - 2] = (nums[nums_length - 2], nums[nums_length - 2])

        for index in range(nums_length - 1, 1, -1):
            if index > 3:
                memory[index - 2] = (max(memory[index - 2][0], nums[index - 2] + memory[index][0]),
                                     (max(memory[index - 2][1], nums[index - 2] + memory[index][1])))
                memory[index - 3] = (max(memory[index - 3][0], nums[index - 3] + memory[index][0]),
                                     (max(memory[index - 3][1], nums[index - 3] + memory[index][1])))
            elif index == 3:
                memory[index - 2] = (max(memory[index - 2][0], nums[index - 2] + memory[index][0]),
                                     (max(memory[index - 2][1], nums[index - 2] + memory[index][1])))
                memory[index - 3] = (memory[index][0],
                                     (max(memory[index - 3][1], nums[index - 3] + memory[index][1])))
            else:
                memory[index - 2] = (max(memory[index][0], memory[index-2][0]),
                                     max(memory[index - 2][1], nums[index - 2] + memory[index][1]))

        return max(memory[0][1], memory[0][0], memory[1][0], memory[1][1])
