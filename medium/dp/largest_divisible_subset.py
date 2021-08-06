from typing import List, Dict


class Solution:
    max_length = 1
    memory: Dict[int, List[int]] = {}

    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        if len(nums) == 1:
            return nums
        Solution.max_length = 1
        Solution.memory = {}
        sorted_list = sorted(nums)

        def check_divisibility(start: int) -> List[int]:
            if start in Solution.memory:
                return Solution.memory[start]
            if start == len(nums) - 1:
                Solution.memory[start] = [sorted_list[start]]
                return Solution.memory[start]
            max_length = []
            for i in range(start + 1, len(nums), 1):
                if sorted_list[i] % sorted_list[start] == 0:
                    temp_result = check_divisibility(i)
                    if len(temp_result) > len(max_length):
                        max_length = temp_result
            Solution.memory[start] = [sorted_list[start]] + max_length
            return Solution.memory[start]

        max_len_subarray = []
        for index in range(0, len(nums) - 1, 1):
            temp_sub_array = max(max_len_subarray, check_divisibility(start=index))
            if len(temp_sub_array) > len(max_len_subarray):
                max_len_subarray = temp_sub_array
        return max_len_subarray
