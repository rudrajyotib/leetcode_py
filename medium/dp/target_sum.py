from typing import List, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
    def findTargetSumWays(self, nums: List[int], target: int) -> int:

        memory_map: Dict[int, int]
        if nums[0] == 0:
            memory_map = {0: 2}
        else:
            memory_map = {nums[0]: 1, -nums[0]: 1}
        for index in range(1, len(nums), 1):
            num = nums[index]
            temp_map = {}
            for item in memory_map.keys():
                pos = item + num
                neg = item - num
                if pos in temp_map:
                    temp_map[pos] += memory_map[item]
                else:
                    temp_map[pos] = memory_map[item]
                if neg in temp_map:
                    temp_map[neg] += memory_map[item]
                else:
                    temp_map[neg] = memory_map[item]
            memory_map.clear()
            memory_map = temp_map

        return memory_map[target] if target in memory_map else 0
