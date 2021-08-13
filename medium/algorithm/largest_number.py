"""
https://leetcode.com/problems/largest-number/
Leetcode#179
"""


from functools import cmp_to_key
from typing import List


def compare_from_left(num1_str: str, num2_str: str) -> int:
    left_first = num1_str + num2_str
    right_first = num2_str + num1_str
    if left_first > right_first:
        return -1
    else:
        return 1


class Solution:
    def largestNumber(self, nums: List[int]) -> str:

        decimal_list = [[] for _ in range(10)]
        for num in nums:
            num_str = str(num)
            decimal_list[ord(num_str[0]) - 48].append(num_str)
        for decimal_item in decimal_list:
            decimal_item.sort(key=cmp_to_key(compare_from_left))

        stupid_edge_case_zero_check = True
        for index in range(1, 10, 1):
            if len(decimal_list[index]) > 0:
                stupid_edge_case_zero_check = False
                break

        if stupid_edge_case_zero_check:
            return "0"

        result = ""
        decimal_list.reverse()
        for decimal_item in decimal_list:
            result += "".join(decimal_item)
        return result
