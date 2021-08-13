"""
Leet-code # 43
https://leetcode.com/problems/multiply-strings/
"""

from typing import List


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"

        result: List[int] = [0]

        def keep_adding_number(num: int, index: int):
            # if num == 0:
            #     return
            if index > len(result) - 1:
                result.append(0)
            after_add = result[index] + num
            result[index] = after_add % 10
            if after_add > 9:
                keep_adding_number(num=after_add // 10, index=index + 1)

        start_index_1 = -1
        for multiplier_1 in range( len(num1)-1, -1 , -1):
            start_index_1 += 1
            if start_index_1 > len(result) - 1:
                result.append(0)
            start_index_2 = start_index_1
            if num1[multiplier_1] == "0":
                continue
            for multiplier_2 in range(len(num2)-1, -1, -1):
                number = int(num1[multiplier_1]) * int(num2[multiplier_2])
                keep_adding_number(num=number, index=start_index_2)
                start_index_2 += 1
        result.reverse()
        return ''.join(list(map(lambda x: str(x), result)))
